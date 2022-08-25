[JUnit5官网](https://junit.org/junit5/)  
[JUnit5 Github](https://github.com/junit-team/junit5/)  
[JUnit5文档](https://junit.org/junit5/docs/current/user-guide/)  
[JUnit5 API文档](https://junit.org/junit5/docs/current/api/)  
[JUnit5 Samples](https://github.com/junit-team/junit5-samples)  
[Junit 5官方文档中文版](https://doczhcn.gitbook.io/junit5/index/index-1/dependency-metadata-junit-jupiter-samples)


junit5:Group ID: org.junit.jupiter




JUnit 是一个 Java 语言的单元测试框架。它有自己的 JUnit 扩展生态圈，多数 Java 开发环境都已经集成了JUnit 作为单元测试的工具。JUnit 测试是程序员测试，即所谓白盒测试，因为程序员知道被测试的软件如何（How）完成功能和完成什么样（What）的功能。另外 JUnit 是在极限编程和重构中被极力推荐使用的工具。

JUnit 5 由三个不同的模块组成：

JUnit 平台，其主要作用是在 JVM 上启动测试框架。它定义了一个抽象的 TestEngine API 来定义运行在平台上的测试框架，同时还支持通过命令行、Gradle 和 Maven 来运行平台。

JUnit Jupiter，包含了 JUnit 5 最新的编程模型和扩展机制。

JUnit Vintage，允许在平台上运行 JUnit 3 和 JUnit 4 的测试用例。

JUnit 5 对 Java 运行环境的最低要求是 Java 8，同时也兼容测试旧版本 JDK 编译出来的代码。



示例博客
https://www.ibm.com/developerworks/cn/java/j-junit5/


名称	说明
@Test	表明一个测试方法
@DisplayName	测试类或方法的显示名称
@BeforeEach	表明在单个测试方法运行之前执行的方法
@AfterEach	表明在单个测试方法运行之后执行的方法
@BeforeAll	表明在所有测试方法运行之前执行的方法
@AfterAll	表明在所有测试方法运行之后执行的方法
@Disabled	禁用测试类或方法
@Tag	为测试类或方法添加标签


断言（assertions）是测试方法中的核心部分，用来对测试需要满足的条件进行验证。这些断言方法都是 org.junit.jupiter.api.Assertions 的静态方法。JUnit 5 内置的断言可以分成如下几个类别：

第一类是简单断言，用来对单个值进行简单的验证，常用的方法见表 2。

表 2. 常用的断言方法
方法	说明
assertEquals	判断两个对象或两个原始类型是否相等
assertNotEquals	判断两个对象或两个原始类型是否不相等
assertSame	判断两个对象引用是否指向同一个对象
assertNotSame	判断两个对象引用是否指向不同的对象
assertTrue	判断给定的布尔值是否为 true
assertFalse	判断给定的布尔值是否为 false
assertNull	判断给定的对象引用是否为 null
assertNotNull	判断给定的对象引用是否不为 null





教程  
[A Guide to JUnit 5](https://www.baeldung.com/junit-5)  
[JUnit 5 教程 之 基础篇](https://www.jianshu.com/p/3183fb69fd74)  
[Spring Boot 集成 JUnit5，更优雅单元测试](https://blog.51cto.com/u_15310381/3197004)  
[]()  


