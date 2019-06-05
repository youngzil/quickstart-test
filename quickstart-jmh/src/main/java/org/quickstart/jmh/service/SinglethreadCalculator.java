/**
 * 项目名称：quickstart-jmh 
 * 文件名：SinglethreadCalculator.java
 * 版本信息：
 * 日期：2018年9月14日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.jmh.service;

/**
 * SinglethreadCalculator 
 *  
 * @author：youngzil@163.com
 * @2018年9月14日 下午3:57:11 
 * @since 1.0
 */
public class SinglethreadCalculator implements Calculator {
    
//    串行算法：使用 for-loop 来计算 n 个正整数之和。
    public long sum(int[] numbers) {
        long total = 0L;
        for (int i : numbers) {
            total += i;
        }
        return total;
    }

    @Override
    public void shutdown() {
        // nothing to do
    }
}

