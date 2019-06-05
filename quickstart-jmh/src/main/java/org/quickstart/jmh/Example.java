/**
 * 项目名称：quickstart-jmh 
 * 文件名：Example.java
 * 版本信息：
 * 日期：2018年9月14日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Example
 * 
 * @author：youngzil@163.com
 * @2018年9月14日 下午2:56:12
 * @since 1.0
 */
public class Example {

    @Benchmark
    public void test() {
        // todo
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(Example.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    // 方法一：方法返回值
    @Benchmark
    public int testMethod() {
        int a = 1;
        int b = 2;
        int sum = a + b;

        return sum;
    }

    // 方法二：交给Blackhole
    @Benchmark
    public void testMethod2(Blackhole blackhole) {
        int a = 1;
        int b = 2;
        int sum = a + b;
        blackhole.consume(sum);
    }
    

}
