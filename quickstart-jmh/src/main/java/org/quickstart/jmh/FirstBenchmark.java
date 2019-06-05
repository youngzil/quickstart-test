/**
 * 项目名称：quickstart-jmh 
 * 文件名：FirstBenchmark.java
 * 版本信息：
 * 日期：2018年9月14日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.jmh;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * FirstBenchmark
 * 
 * @author：youngzil@163.com
 * @2018年9月14日 下午3:21:38
 * @since 1.0
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class FirstBenchmark {

    @Benchmark
    public int sleepAWhile() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // ignore
        }
        return 0;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()//
                .include(FirstBenchmark.class.getSimpleName())// include：benchmark 所在的类的名字，注意这里是使用正则表达式对所有类进行匹配的。
                .forks(1)// fork：进行 fork 的次数。如果 fork 数是2的话，则 JMH 会 fork 出两个进程来进行测试。
                .warmupIterations(5)// warmupIterations：预热的迭代次数。
                .measurementIterations(5)// measurementIterations：实际测量的迭代次数。
                .output("/Users/yangzl/Benchmark.log")// 输出信息到文件

                // 使用之前要安装hsdis
                // -XX:-TieredCompilation 关闭分层优化 -server
                // -XX:+LogCompilation 运行之后项目路径会出现按照测试顺序输出hotspot_pid<PID>.log文件,可以使用JITWatch进行分析,可以根据最后运行的结果的顺序按文件时间找到对应的hotspot_pid<PID>.log文件
                // .jvmArgs("-XX:+UnlockDiagnosticVMOptions", "-XX:+LogCompilation", "-XX:+TraceClassLoading", "-XX:+PrintAssembly")
                // .addProfiler(CompilerProfiler.class) // report JIT compiler profiling via standard MBeans
                // .addProfiler(GCProfiler.class) // report GC time
                // .addProfiler(StackProfiler.class) // report method stack execution profile
                // .addProfiler(PausesProfiler.class)
                /*
                WinPerfAsmProfiler
                You must install Windows Performance Toolkit. Once installed, locate directory with xperf.exe file
                and either add it to PATH environment variable, or set it to jmh.perfasm.xperf.dir system property.
                 */
                // .addProfiler(WinPerfAsmProfiler.class)
                // 更多Profiler,请看JMH介绍

                .build();

        new Runner(opt).run();
    }
}
