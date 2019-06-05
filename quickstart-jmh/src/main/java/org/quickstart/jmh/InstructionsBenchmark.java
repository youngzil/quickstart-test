/**
 * 项目名称：quickstart-jmh 
 * 文件名：InstructionsBenchmark.java
 * 版本信息：
 * 日期：2018年9月14日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.jmh;

import java.util.concurrent.TimeUnit;
import java.util.Arrays;
 
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * InstructionsBenchmark
 * 
 * @author：youngzil@163.com
 * @2018年9月14日 下午2:30:26
 * @since 1.0
 */

@BenchmarkMode(Mode.Throughput) // 基准测试类型
@OutputTimeUnit(TimeUnit.SECONDS) // 基准测试结果的时间类型
@Warmup(iterations = 3) // 预热的迭代次数
@Threads(2) // 测试线程数量
@State(Scope.Thread) // 该状态为每个线程独享
// 度量:iterations进行测试的轮次，time每轮进行的时长，timeUnit时长单位,batchSize批次数量
@Measurement(iterations = 2, time = -1, timeUnit = TimeUnit.SECONDS, batchSize = -1)
public class InstructionsBenchmark {
    static int staticPos = 0;
    // String src = "SELECT a FROM ab , ee.ff AS f,(SELECT a FROM `schema_bb`.`tbl_bb`,(SELECT a FROM ccc AS c, `dddd`));";
    final byte[] srcBytes = {83, 69, 76, 69, 67, 84, 32, 97, 32, 70, 82, 79, 77, 32, 97, 98, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 44, 32, 101, 101, 46, 102, 102, 32, 65, 83, 32, 102,
            44, 40, 83, 69, 76, 69, 67, 84, 32, 97, 32, 70, 82, 79, 77, 32, 96, 115, 99, 104, 101, 109, 97, 95, 98, 98, 96, 46, 96, 116, 98, 108, 95, 98, 98, 96, 44, 40, 83, 69, 76, 69, 67, 84, 32,
            97, 32, 70, 82, 79, 77, 32, 99, 99, 99, 32, 65, 83, 32, 99, 44, 32, 96, 100, 100, 100, 100, 96, 41, 41, 59};
    int len = srcBytes.length;
    byte[] array = new byte[8192];
    int memberVariable = 0;

    // run
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(InstructionsBenchmark.class.getSimpleName()).forks(1)
                // 使用之前要安装hsdis
                // -XX:-TieredCompilation 关闭分层优化 -server
                // -XX:+LogCompilation 运行之后项目路径会出现按照测试顺序输出hotspot_pid<PID>.log文件,可以使用JITWatch进行分析,可以根据最后运行的结果的顺序按文件时间找到对应的hotspot_pid<PID>.log文件
                .jvmArgs("-XX:+UnlockDiagnosticVMOptions", "-XX:+LogCompilation", "-XX:+TraceClassLoading", "-XX:+PrintAssembly")
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
                // .output("InstructionsBenchmark.log")//输出信息到文件
                .build();
        new Runner(opt).run();
    }

    // 空循环 对照项
    @Benchmark
    public int emptyLoop() {
        int pos = 0;
        while (pos < len) {
            ++pos;
        }
        return pos;
    }

    @Benchmark
    public int increment() {
        int pos = 0;
        int result = 0;
        while (pos < len) {
            ++result;
            ++pos;
        }
        return result;
    }

    @Benchmark
    public int decrement() {
        int pos = 0;
        int result = 0;
        while (pos < len) {
            --result;
            ++pos;
        }
        return result;
    }

    @Benchmark
    public int ifElse() {
        int pos = 0;
        int result = 0;
        while (pos < len) {
            if (pos == 10) {
                ++result;
                ++pos;
            } else {
                ++pos;
            }
        }
        return result;
    }

    @Benchmark
    public int ifElse2() {
        int pos = 0;
        int result = 0;
        while (pos < len) {
            if (pos == 10) {
                ++result;
                ++pos;
            } else if (pos == 20) {
                ++result;
                ++pos;
            } else {
                ++pos;
            }
        }
        return result;
    }

    @Benchmark
    public int ifnotElse() {
        int pos = 0;
        int result = 0;
        while (pos < len) {
            if (pos != 10) {
                ++pos;
            } else {
                ++result;
                ++pos;
            }
        }
        return result;
    }

    @Benchmark
    public int ifLessthanElse() {
        int pos = 0;
        int result = 0;
        while (pos < len) {
            if (pos < 10) {
                ++pos;
            } else {
                ++result;
                ++pos;
            }
        }
        return result;
    }

    @Benchmark
    public int ifGreaterthanElse() {
        int pos = 0;
        int result = 0;
        while (pos < len) {
            if (pos > 10) {
                ++pos;
            } else {
                ++result;
                ++pos;
            }
        }
        return result;
    }

    @Benchmark
    public int readMemberVariable_a_byteArray() {
        int pos = 0;
        int result = 0;
        while (pos < len) {
            result = srcBytes[pos];
            pos++;
        }
        return result;
    }

}
