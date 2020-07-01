### JDK8源码之Spliterator并行遍历迭代器

#### Spliterator是什么？

```java
public interface Spliterator<T> {
```

Spliterator是一个__可分割迭代器(splitable iterator)__，__可以和iterator顺序遍历迭代器一起看__。jdk1.8发布后，对于__并行处理__的能力大大增强，Spliterator就是为了并行遍历元素而设计的一个迭代器，jdk1.8中的集合框架中的数据结构都默认实现了spliterator，后面我们也会结合ArrayList中的spliterator()一起解析。

#### Spliterator内部结构

```java
 //单个对元素执行给定的动作，如果有剩下元素未处理返回true，否则返回false
 boolean tryAdvance(Consumer<? super T> action);

 //对每个剩余元素执行给定的动作，依次处理，直到所有元素已被处理或被异常终止。默认方法调用tryAdvance方法
 default void forEachRemaining(Consumer<? super T> action) {
    do { } while (tryAdvance(action));
 }

 //对任务分割，返回一个新的Spliterator迭代器
 Spliterator<T> trySplit();

 //用于估算还剩下多少个元素需要遍历
 long estimateSize();

 //当迭代器拥有SIZED特征时，返回剩余元素个数；否则返回-1
 default long getExactSizeIfKnown() {
    return (characteristics() & SIZED) == 0 ? -1L : estimateSize();
 }

  //返回当前对象有哪些特征值
 int characteristics();

 //是否具有当前特征值
 default boolean hasCharacteristics(int characteristics) {
    return (characteristics() & characteristics) == characteristics;
 }
 //如果Spliterator的list是通过Comparator排序的，则返回Comparator
 //如果Spliterator的list是自然排序的 ，则返回null
 //其他情况下抛错
 default Comparator<? super T> getComparator() {
     throw new IllegalStateException();
 }
```




特征值其实就是为表示该Spliterator有哪些特性，用于可以更好控制和优化Spliterator的使用。关于获取比较器getComparator这一个方法，目前我还没看到具体使用的地方，所以可能理解有些误差。特征值如下：（部分属于猜测）

```java
 //
 public static final int ORDERED    = 0x00000010;
 //
 public static final int DISTINCT   = 0x00000001;
 //排序
 public static final int SORTED     = 0x00000004;
 //大小
 public static final int SIZED      = 0x00000040;
 //没有null
 public static final int NONNULL    = 0x00000100;
 public static final int IMMUTABLE  = 0x00000400;
 public static final int CONCURRENT = 0x00001000;
 public static final int SUBSIZED = 0x00004000;
```



#### ArrayListSpliterator

```java
static final class ArrayListSpliterator<E> implements Spliterator<E> {
    //用于存放ArrayList对象
   private final ArrayList<E> list;
   //起始位置（包含），advance/split操作时会修改
   private int index; 
   //结束位置（不包含），-1 表示到最后一个元素
   private int fence; 
   //用于存放list的modCount
   private int expectedModCount; 

   ArrayListSpliterator(ArrayList<E> list, int origin, int fence,
                             int expectedModCount) {
            this.list = list; 
            this.index = origin;
            this.fence = fence;
            this.expectedModCount = expectedModCount;
        }
    //获取结束位置（存在意义：首次初始化石需对fence和expectedModCount进行赋值）
   private int getFence() { 
        int hi; 
        ArrayList<E> lst;
        //fence<0时（第一次初始化时，fence才会小于0）：
        if ((hi = fence) < 0) {
            //list 为 null时，fence=0
            if ((lst = list) == null)
                hi = fence = 0;
            else {
            //否则，fence = list的长度。
                expectedModCount = lst.modCount;
                hi = fence = lst.size;
            }
        }
        return hi;
    }
    //分割list，返回一个新分割出的spliterator实例
    public ArrayListSpliterator<E> trySplit() {
        //hi为当前的结束位置
        //lo 为起始位置
        //计算中间的位置
        int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
        //当lo>=mid,表示不能在分割，返回null
        //当lo<mid时,可分割，切割（lo，mid）出去，同时更新index=mid
        return (lo >= mid) ? null : 
            new ArrayListSpliterator<E>(list, lo, index = mid,                                         expectedModCount);
    }
    //返回true 时，只表示可能还有元素未处理
    //返回false 时，没有剩余元素处理了。。。
    public boolean tryAdvance(Consumer<? super E> action) {
         if (action == null)
             throw new NullPointerException();
         //hi为当前的结束位置
         //i 为起始位置
         int hi = getFence(), i = index;
         //还有剩余元素未处理时
         if (i < hi) {
             //处理i位置，index+1
             index = i + 1;
             @SuppressWarnings("unchecked") E e = (E)list.elementData[i];
             action.accept(e);
             //遍历时，结构发生变更，抛错
             if (list.modCount != expectedModCount)
                 throw new ConcurrentModificationException();
             return true;
         }
         return false;
     }
    //顺序遍历处理所有剩下的元素
   public void forEachRemaining(Consumer<? super E> action) {
       int i, hi, mc; // hoist accesses and checks from loop
       ArrayList<E> lst; Object[] a;
       if (action == null)
           throw new NullPointerException();
       if ((lst = list) != null && (a = lst.elementData) != null) {
           //当fence<0时，表示fence和expectedModCount未初始化，可以思考一下这里能否直接调用getFence()，嘿嘿？
           if ((hi = fence) < 0) {
               mc = lst.modCount;
               hi = lst.size;
           }
           else
               mc = expectedModCount;
           if ((i = index) >= 0 && (index = hi) <= a.length) {
               for (; i < hi; ++i) {
                   @SuppressWarnings("unchecked") E e = (E) a[i];
                   //调用action.accept处理元素
                   action.accept(e);
               }
               //遍历时发生结构变更时抛出异常
               if (lst.modCount == mc)
                   return;
           }
       }
       throw new ConcurrentModificationException();
   }

   public long estimateSize() {
        return (long) (getFence() - index);
    }
  public int characteristics() {
    //打上特征值：、可以返回size
    return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
	}
}
```



测试代码如下：

```java
List<String>  arrs = new ArrayList<>();
 arrs.add("a");
 arrs.add("b"); 
 arrs.add("c");
 arrs.add("d");
 arrs.add("e");
 arrs.add("f");
 arrs.add("h");
 arrs.add("i");
 arrs.add("j");
 Spliterator<String> a =  arrs.spliterator();
 //此时结果：a:0-9（index-fence）
 Spliterator<String> b = a.trySplit();
 //此时结果：b:4-9,a:0-4
 Spliterator<String> c = a.trySplit();
 //此时结果：c:4-6,b:4-9,a:6-9
 Spliterator<String> d = a.trySplit();
 //此时结果：d:6-7,c:4-6,b:4-9,a:7-9
```


可以看到__每次分割，都会分割剩余的前一半__，fence之不变，index后移。同时也发现： 

1. ArrayListSpliterator本质上还是对原list进行操作，只是通过index和fence来控制每次处理范围 

2. 也可以得出，ArrayListSpliterator在遍历元素时，不能对list进行结构变更操作，否则抛错。

   <img src="/Users/minp/GitHub/java8/image-20200701110554559.png" alt="image-20200701110554559" style="zoom:50%;" />



#### 衍生接口OfPrimitive

可以看到Spliterator类里面可以看到这么一个接口，那么这个接口是干什么的，源码：

```java
 public interface OfPrimitive<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>>
            extends Spliterator<T> {
        @Override
        T_SPLITR trySplit();
        @SuppressWarnings("overloads")
        boolean tryAdvance(T_CONS action);
        @SuppressWarnings("overloads")
        default void forEachRemaining(T_CONS action) {
            do { } while (tryAdvance(action));
        }
    }
```


可以看到，这个接口基本没有变动，这是多增加两个泛型声明而已，本质上和Spliterator没有太大的区别，只不过，它限制tryAdvance的参数action类型T_CONS和trySplit的返回参数T_SPLITR必须在实现接口时先声明类型。 
基于OfPrimitive接口，又衍生出了OfInt、OfLong、OfDouble等专门用来处理int、Long、double等分割迭代器接口（在Spliterators有具体的实现）。

#### Spliterator.OfInt的实现

在Spliterators类中，已经实现了针对int[]数据分割迭代器，和ArrayList差不多，所以接下来只会简单的阅读一下：

```java
 //与ArrayList不同的是，array是实现声明的，因此不必担心遍历过程中发生结构变更。
 static final class IntArraySpliterator implements Spliterator.OfInt {
    private final int[] array;
    private int index;       
     private final int fence;
     //用于记录特征值
     private final int characteristics;
// 初始构造器
 public IntArraySpliterator(int[] array, int additionalCharacteristics) {
     this(array, 0, array.length, additionalCharacteristics);
 }

 public IntArraySpliterator(int[] array, int origin, int fence, int additionalCharacteristics) {
     this.array = array;
     this.index = origin;
     this.fence = fence;
     this.characteristics = additionalCharacteristics | Spliterator.SIZED | Spliterator.SUBSIZED;
 }

 @Override
 public OfInt trySplit() {
     //分割，上面做个介绍，不在赘述
     int lo = index, mid = (lo + fence) >>> 1;
     return (lo >= mid)
            ? null
            : new IntArraySpliterator(array, lo, index = mid, characteristics);
 }

 @Override
 public void forEachRemaining(IntConsumer action) {
     int[] a; int i, hi; // hoist accesses and checks from loop
     if (action == null)
         throw new NullPointerException();  
     if ((a = array).length >= (hi = fence) &&
         (i = index) >= 0 && i < (index = hi)) {
         do { action.accept(a[i]); } while (++i < hi);
     }
 }

 @Override
 public boolean tryAdvance(IntConsumer action) {
     if (action == null)
         throw new NullPointerException();
     if (index >= 0 && index < fence) {
         action.accept(array[index++]);
         return true;
     }
     return false;
 }

 @Override
 public long estimateSize() { return (long)(fence - index); }

 @Override
 public int characteristics() {
     return characteristics;
 }

 @Override
 public Comparator<? super Integer> getComparator() {
     if (hasCharacteristics(Spliterator.SORTED))
         return null;
     throw new IllegalStateException();
 }
}
```

