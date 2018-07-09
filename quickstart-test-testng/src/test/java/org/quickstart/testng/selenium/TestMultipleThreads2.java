/**
 * 项目名称：quickstart-testng 
 * 文件名：TestMultipleThreads2.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.selenium;

import org.testng.annotations.Test;

/**
 * TestMultipleThreads2
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月21日 上午11:56:05
 * @since 1.0
 */
public class TestMultipleThreads2 {

    // - 启动包含3个线程的线程池，并运行测试方法10次。
    @Test(invocationCount = 10, threadPoolSize = 3)
    public void testThreadPools() {

        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

    }

}
