/**
 * 项目名称：quickstart-jmh 
 * 文件名：SecondBenchmark.java
 * 版本信息：
 * 日期：2018年9月14日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.jmh;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.quickstart.jmh.service.Calculator;
import org.quickstart.jmh.service.MultithreadCalculator;
import org.quickstart.jmh.service.SinglethreadCalculator;

/**
 * SecondBenchmark
 * 
 * @author：yangzl@asiainfo.com
 * @2018年9月14日 下午3:56:17
 * @since 1.0
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class SecondBenchmark {

    // 计算 1 ~ n 之和，比较串行算法和并行算法的效率，看 n 在大约多少时并行算法开始超越串行算法
    // 串行算法：使用 for-loop 来计算 n 个正整数之和。
    // 并行算法：将所需要计算的 n 个正整数分成 m 份，交给 m 个线程分别计算出和以后，再把它们的结果相加。

    // 我在自己的 mac 上跑下来的结果，总数在10000时并行算法不如串行算法，总数达到100000时并行算法开始和串行算法接近，总数达到1000000时并行算法所耗时间约是串行算法的一半左右。

    // @Param 可以用来指定某项参数的多种情况。特别适合用来测试一个函数在不同的参数输入的情况下的性能。
    @Param({"10000", "100000", "1000000"})
    private int length;

    private int[] numbers;
    private Calculator singleThreadCalc;
    private Calculator multiThreadCalc;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()//
                .include(SecondBenchmark.class.getSimpleName())//
                .forks(2)//
                .warmupIterations(5)//
                .measurementIterations(5)//
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public long singleThreadBench() {
        return singleThreadCalc.sum(numbers);
    }

    @Benchmark
    public long multiThreadBench() {
        return multiThreadCalc.sum(numbers);
    }

    // @Setup 会在执行 benchmark 之前被执行，正如其名，主要用于初始化。
    @Setup(Level.Trial) // Level用于控制 @Setup，@TearDown 的调用时机，默认是 Level.Trial，即benchmark开始前和结束后。
    public void prepare() {
        numbers = IntStream.rangeClosed(1, length).toArray();
        singleThreadCalc = new SinglethreadCalculator();
        multiThreadCalc = new MultithreadCalculator(Runtime.getRuntime().availableProcessors());
    }

    // @TearDown 和 @Setup 相对的，会在所有 benchmark 执行结束以后执行，主要用于资源的回收等。
    @TearDown(Level.Trial) // Level用于控制 @Setup，@TearDown 的调用时机，默认是 Level.Trial，即benchmark开始前和结束后。
    public void shutdown() {
        singleThreadCalc.shutdown();
        multiThreadCalc.shutdown();
    }

    // 还有一些 JMH 的常用选项没有提及的，简单地在此介绍一下
    // CompilerControl
    // 控制 compiler 的行为，例如强制 inline，不允许编译等。
    // Group
    // 可以把多个 benchmark 定义为同一个 group，则它们会被同时执行，主要用于测试多个相互之间存在影响的方法。
    // Profiler
    // JMH 支持一些 profiler，可以显示等待时间和运行时间比，热点函数等。

}
