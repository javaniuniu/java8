# java8

#### 1、[四大函数式接口](./src/main/java/com/javaniuniu/function/)

| 接口名称                 | 说明                            | demo                                                         |
| ------------------------ | ------------------------------- | ------------------------------------------------------------ |
| Consumer 消费型接口      | 有输入，无返回                  | [ConsumerDemo](./src/main/java/com/javaniuniu/function/ConsumerDemo.java) |
| Function     函数型接口  | 有输，有输出                    | [FunctionDemo](./src/main/java/com/javaniuniu/function/FunctionDemo.java) |
| Predicate    断定型接口  | 有输入，有返回 只能是一个布尔值 | [PredicateDemo](./src/main/java/com/javaniuniu/function/PredicateDemo.java) |
| Supplier      供给型接口 | 无输入，有返回                  | [SupplierDemo](./src/main/java/com/javaniuniu/function/SupplierDemo.java) |



####  2、jdk1.8 新增方法

|jdk1.8新增|链接|说明|使用方式|
|:--|:--|:--|---|
|stream|[Collection.stream()](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Collection.html) |在jdk1.8中，Collection接口类新增了`stream()`流方法，所有实现了 Collection 的类都可以使用（List,Set,Queue）||
|forEach|[Iterable.forEach()](https://www.matools.com/file/manual/jdk_api_1.8_google/java/lang/Iterable.html#forEach-java.util.function.Consumer-) |同时 Collection 继承了 Iterable，所有 Collection 实现类 也可使用 forEach||
|merge|[Map.merge()](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Map.html#merge-K-V-java.util.function.BiFunction-) |merge(K key, V value,  BiFunction<? super V,? super V,? extends V> remappingFunction)||
|forEach|[Map.forEach()](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Map.html#forEach-java.util.function.BiConsumer-) |forEach(BiConsumer<? super K,? super V> action)||
|parallelStream|[parallelStream](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Collection.html#parallelStream--) |parallelStream 通过并行，即是通过__多线程__的方式提高运算效率，其底层使用__Fork/Join__框架实现，需要注意并发编程中存在的问题，使用方式和 stream 一样|如何正确使用:<br/>1.确保要执行的任务对线程<br/> 2.环境没有依赖任务消耗时间长 /数据量大到不用思考是否要用parallel<br/>3.结果没有顺序要求|
|removeIf|[removeIf](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Collection.html#removeIf-java.util.function.Predicate-) |默认实现使用__其iterator()遍历集合的所有元素__。 使用Iterator.remove()删除每个匹配元素。 如果集合的迭代器不支持删除，那么UnsupportedOperationException将被抛出第一个匹配元素。||
|spliterator|[spliterator](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Spliterators.html#emptySpliterator--) |Spliterator就是为了__并行__遍历元素而设计的一个迭代器，__可以和iterator顺序遍历迭代器一起看__||

​    

#### 3、[关键字](./src/main/java/com/javaniuniu/keyword/)

`::` 关键字来访问类的构造方法，对象方法，静态方法。

| 方式                | 可访问的类型                                       | 示例                                                         |
| ------------------- | -------------------------------------------------- | ------------------------------------------------------------ |
| __结合函数式接口:__ | 关键字 `::`  访问 __构造方法，对象方法，静态方法__ | [Something](./src/main/java/com/javaniuniu/keyword/Something.java) |
| __不含函数式接口:__ | 关键字 `::`  可通过 Class 访问 __静态方法__        | [AcceptMethod](./src/main/java/com/javaniuniu/keyword/AcceptMethod.java) |

 

#### 4、示例

##### 4、1 Map 相关示例

| 示例链接                                                     | 使用方法         | 说明          |
| ------------------------------------------------------------ | ---------------- | ------------- |
| [stream 流遍历 List分组Map](./src/main/java/com/javaniuniu/stream/FooTest.java) | stream           |               |
| [stream 流遍历 List分组Map](./src/main/java/com/javaniuniu/stream/MapGroupBy.java) | stream           |               |
| [合并map](./src/main/java/com/javaniuniu/map/SumMap.java)    | stream ,   merge |               |
| [StudentScoreTest](./src/main/java/com/javaniuniu/map/StudentScoreTest.java) | stream ,  merge  |               |
| [Merge示例](./src/main/java/com/javaniuniu/map/MergeDemo.java) | merge            |               |
| [GroupBy](./src/main/java/com/javaniuniu/stream/GroupBy.java) | stream , groupby |               |
| [Java8合并两个Map中元素](./src/main/java/com/javaniuniu/map/MergeEmp.java) | stream           | 5中方法，很全 |



##### 4、2 List 相关示例

| 示例链接                                                     | 使用方法                  | 说明 |
| ------------------------------------------------------------ | ------------------------- | ---- |
| [Iterator 遍历](./src/main/java/com/javaniuniu/list/ListIterator.java) | Iterator                  |      |
| [查询list 中字段](./src/main/java/com/javaniuniu/list/ListSearch.java) | filter sorted map forEach |      |
| [sort Comparator 排序](./src/main/java/com/javaniuniu/list/ListSort.java) | sort Comparator           |      |
| [RemoveIf](./src/main/java/com/javaniuniu/list/RemoveIf.java) | RemoveIf                  |      |





##### 4、3 其他示例

[Map](./src/main/java/com/javaniuniu/map) 

[HashMap负载因子](./src/main/java/com/javaniuniu/map/loadFactor.md)

[map初始化](./src/main/java/com/javaniuniu/map/MapInitDemo.java) 







