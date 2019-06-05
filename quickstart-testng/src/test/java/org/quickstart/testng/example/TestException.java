/**
 * 项目名称：quickstart-testng 
 * 文件名：TestGroup.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.example;

import org.testng.annotations.Test;

/**
 * TestGroup
 * 
 * @author：youngzil@163.com
 * @2017年11月21日 下午2:23:16
 * @since 1.0
 */
public class TestException {

    // 忽略测试：enabled = false
    @Test(expectedExceptions = ArithmeticException.class, timeOut = 1000, enabled = true)
    public void divisionWithException() throws InterruptedException {
        // “时间测试”表示如果单元测试所花费的时间超过指定的毫秒数，则测试将会终止，并将其标记为失败，
        Thread.sleep(2_000);
        int i = 1 / 0;
    }

}
