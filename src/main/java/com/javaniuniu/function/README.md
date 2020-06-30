#### 1、四大函数式接口

#### 1.1  Consumer  消费型接口:  有输入，无返回

```java
public class ConsumerDemo {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String> () {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("adf");
    }
}
```



##### 1.2 Function  函数型接口:  有输，有输出

```java
public class FunctionDemo {
    public static void main(String[] args) {
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };
        Function<String,String> function = (str)->{return str;};
        System.out.println(function.apply("ads"));
    }
}
```

##### 1.4 Predicate 断定型接口:   有输入，有返回 只能是一个布尔值

```java
public class PredicateDemo {
    public static void main(String[] args) {
        // 判断字符串是否为空
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };
        Predicate<String> predicate = (str) -> {return str.isEmpty();};
        System.out.println(predicate.test(""));
    }
}
```

##### 1.3 Supplier 供给型接口:  无输入，有返回

```java
public class SupplierDemo {
    public static void main(String[] args) {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "1234";
//            }
//        };
        Supplier<String> supplier = () -> {return "1234";};
        System.out.println(supplier.get());
    }
}
```
