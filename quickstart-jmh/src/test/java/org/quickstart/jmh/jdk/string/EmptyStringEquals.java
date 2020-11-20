package org.quickstart.jmh.jdk.string;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * The Blynk Project. Created by Dmitro Dumanskiy. Created on 13.12.16.
 */
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, time = 1)
public class EmptyStringEquals {

  // 结果（分数越低意味着速度越快）：

  @Param({"", "nonEmptyString"})
  private String strParams;

  @Benchmark
  public boolean nonNullAndIsEmpty() {
    return strParams != null && strParams.isEmpty();
  }

  @Benchmark
  public boolean equalsPost() {
    return strParams != null && strParams.equals("");
  }

  @Benchmark
  public boolean preEquals() {
    return "".equals(strParams);
  }

  public static void main(String[] args) throws RunnerException {

    Paths.get("");

    Options opt = new OptionsBuilder()//
        .include(EmptyStringEquals.class.getSimpleName())//
        .build();

    new Runner(opt).run();
  }

}
