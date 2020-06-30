# java8

#### 1、[四大函数式接口](./src/main/java/com/javaniuniu/function/)

| 接口名称                 | 说明                            | demo                                                         |
| ------------------------ | ------------------------------- | ------------------------------------------------------------ |
| Consumer 消费型接口      | 有输入，无返回                  | [ConsumerDemo](./src/main/java/com/javaniuniu/function/ConsumerDemo.java) |
| Function     函数型接口  | 有输，有输出                    | [FunctionDemo](./src/main/java/com/javaniuniu/function/FunctionDemo.java) |
| Predicate    断定型接口  | 有输入，有返回 只能是一个布尔值 | [PredicateDemo](./src/main/java/com/javaniuniu/function/PredicateDemo.java) |
| Supplier      供给型接口 | 无输入，有返回                  | [SupplierDemo](./src/main/java/com/javaniuniu/function/SupplierDemo.java) |



####  2、jdk1.8 新增方法

|jdk1.8新增|链接|说明|
|:--|:--|:--|
|stream|[Collection.stream()](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Collection.html) |在jdk1.8中，Collection接口类新增了`stream()`流方法，所有实现了 Collection 的类都可以使用（List,Set,Queue）|
|forEach|[Iterable.forEach()](https://www.matools.com/file/manual/jdk_api_1.8_google/java/lang/Iterable.html#forEach-java.util.function.Consumer-) |同时 Collection 继承了 Iterable，所有 Collection 实现类 也可使用 forEach|
|merge|[Map.merge()](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Map.html#merge-K-V-java.util.function.BiFunction-) |merge(K key, V value,  BiFunction<? super V,? super V,? extends V> remappingFunction)|
|forEach|[Map.forEach()](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Map.html#forEach-java.util.function.BiConsumer-) |forEach(BiConsumer<? super K,? super V> action)|

​    



#### 3、[关键字](./src/main/java/com/javaniuniu/keyword/)

`::` 关键字来访问类的构造方法，对象方法，静态方法。

| 方式                | 可访问的类型                                       | 示例                                                         |
| ------------------- | -------------------------------------------------- | ------------------------------------------------------------ |
| __结合函数式接口:__ | 关键字 `::`  访问 __构造方法，对象方法，静态方法__ | [Something](./src/main/java/com/javaniuniu/keyword/Something.java) |
| __不含函数式接口:__ | 关键字 `::`  可通过 Class 访问 __静态方法__        | [AcceptMethod](./src/main/java/com/javaniuniu/keyword/AcceptMethod.java) |

 

#### 4、示例

##### 4.1 Map 相关示例

| 示例链接                                                     | 使用方法        | 说明 |
| ------------------------------------------------------------ | --------------- | ---- |
| [stream 流遍历 List分组Map](./src/main/java/com/javaniuniu/stream/FooTest.java) | stream          |      |
| [stream 流遍历 List分组Map](./src/main/java/com/javaniuniu/stream/MapGroupBy.java) | stream          |      |
| [合并map](./src/main/java/com/javaniuniu/map/SumMap.java)    | stream, merge   |      |
| [StudentScoreTest](./src/main/java/com/javaniuniu/map/StudentScoreTest.java) | stream ,  merge |      |
| [Merge示例](./src/main/java/com/javaniuniu/map/MergeDemo.java) | merge           |      |
|                                                              |                 |      |



##### 4.2 其他示例

[Map](./src/main/java/com/javaniuniu/map) 

[HashMap负载因子](./src/main/java/com/javaniuniu/map/loadFactor.md)

[map初始化](./src/main/java/com/javaniuniu/map/MapInitDemo.java) 







