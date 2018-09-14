JMH是一个Java工具，用于构建、运行和分析基于JVM的（纳秒/微秒/毫秒/宏）基准测试。基准测试可以用Java或其他语言编写。

执行JMH基本测试建议使用Maven建立一个依赖应用jar文件的独立项目。这么做可以提供相对准确的测试结果。当然，也可以在已有项目中或者通过IDE执行基准测试。然而，这样的设置过程相对复杂，结果的可靠性也相对较低。

无论何种方式，使用JMH的关键是启用基于注解或者字节码处理器来生成合成的基准测试代码。Maven的原型（archetypes）是机制的关键。强烈推荐JMH的心用户使用Maven来之环境。


JMH 是一个由 OpenJDK/Oracle 里面那群开发了 Java 编译器的大牛们所开发的 Micro Benchmark Framework 。何谓 Micro Benchmark 呢？简单地说就是在 method 层面上的 benchmark，精度可以精确到微秒级。可以看出 JMH 主要使用在当你已经找出了热点函数，而需要对热点函数进行进一步的优化时，就可以使用 JMH 对优化的效果进行定量的分析。

比较典型的使用场景还有：
想定量地知道某个函数需要执行多长时间，以及执行时间和输入 n 的相关性
一个函数有两种不同实现（例如实现 A 使用了 FixedThreadPool，实现 B 使用了 ForkJoinPool），不知道哪种实现性能更好


基本概念
Mode
Mode 表示 JMH 进行 Benchmark 时所使用的模式。通常是测量的维度不同，或是测量的方式不同。目前 JMH 共有四种模式：

Throughput: 整体吞吐量，例如“1秒内可以执行多少次调用”。
AverageTime: 调用的平均时间，例如“每次调用平均耗时xxx毫秒”。
SampleTime: 随机取样，最后输出取样结果的分布，例如“99%的调用在xxx毫秒以内，99.99%的调用在xxx毫秒以内”
SingleShotTime: 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为0，用于测试冷启动时的性能。
Iteration
Iteration 是 JMH 进行测试的最小单位。在大部分模式下，一次 iteration 代表的是一秒，JMH 会在这一秒内不断调用需要 benchmark 的方法，然后根据模式对其采样，计算吞吐量，计算平均执行时间等。

Warmup
Warmup 是指在实际进行 benchmark 前先进行预热的行为。为什么需要预热？因为 JVM 的 JIT 机制的存在，如果某个函数被调用多次之后，JVM 会尝试将其编译成为机器码从而提高执行速度。所以为了让 benchmark 的结果更加接近真实情况就需要进行预热。


注解
现在来解释一下上面例子中使用到的注解，其实很多注解的意义完全可以望文生义 :)

@Benchmark
表示该方法是需要进行 benchmark 的对象，用法和 JUnit 的 @Test 类似。

@Mode
Mode 如之前所说，表示 JMH 进行 Benchmark 时所使用的模式。

@State
State 用于声明某个类是一个“状态”，然后接受一个 Scope 参数用来表示该状态的共享范围。因为很多 benchmark 会需要一些表示状态的类，JMH 允许你把这些类以依赖注入的方式注入到 benchmark 函数里。Scope 主要分为两种。
Thread: 该状态为每个线程独享。
Benchmark: 该状态在所有线程间共享。
关于State的用法，官方的 code sample 里有比较好的例子。

@OutputTimeUnit
benchmark 结果所使用的时间单位。


JMH 官方介绍
http://openjdk.java.net/projects/code-tools/jmh/
http://openjdk.java.net/projects/code-tools/jmh/
JMH Samples
http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/


Google的java微基准框架
Micro-benchmarking library for Java
https://github.com/google/caliper


http://blog.dyngr.com/blog/2016/10/29/introduction-of-jmh/
http://tutorials.jenkov.com/java-performance/jmh.html
https://www.xncoding.com/2018/01/07/java/jmh.html

http://tutorials.jenkov.com/java-performance/jmh.html
https://blog.csdn.net/EatAnApple/article/details/78252098
http://www.importnew.com/12548.html


示例项目
https://github.com/nitsanw/jmh-samples
https://github.com/cowtowncoder/java-json-performance-benchmarks
https://github.com/stephenc/java-logging-benchmarks
https://github.com/lmdbjava/benchmarks







