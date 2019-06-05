/**
 * 项目名称：quickstart-jmh 
 * 文件名：MultithreadCalculator.java
 * 版本信息：
 * 日期：2018年9月14日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.jmh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * MultithreadCalculator
 * 
 * @author：youngzil@163.com
 * @2018年9月14日 下午3:58:07
 * @since 1.0
 */
public class MultithreadCalculator implements Calculator {

    // 并行算法：将所需要计算的 n 个正整数分成 m 份，交给 m 个线程分别计算出和以后，再把它们的结果相加。

    private final int nThreads;
    private final ExecutorService pool;

    public MultithreadCalculator(int nThreads) {
        this.nThreads = nThreads;
        this.pool = Executors.newFixedThreadPool(nThreads);
    }

    private class SumTask implements Callable<Long> {
        private int[] numbers;
        private int from;
        private int to;

        public SumTask(int[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        public Long call() throws Exception {
            long total = 0L;
            for (int i = from; i < to; i++) {
                total += numbers[i];
            }
            return total;
        }
    }

    public long sum(int[] numbers) {
        int chunk = numbers.length / nThreads;

        int from, to;
        List<SumTask> tasks = new ArrayList<SumTask>();
        for (int i = 1; i <= nThreads; i++) {
            if (i == nThreads) {
                from = (i - 1) * chunk;
                to = numbers.length;
            } else {
                from = (i - 1) * chunk;
                to = i * chunk;
            }
            tasks.add(new SumTask(numbers, from, to));
        }

        try {
            List<Future<Long>> futures = pool.invokeAll(tasks);

            long total = 0L;
            for (Future<Long> future : futures) {
                total += future.get();
            }
            return total;
        } catch (Exception e) {
            // ignore
            return 0;
        }
    }

    @Override
    public void shutdown() {
        pool.shutdown();
    }
}
