/**
 * 项目名称：quickstart-testng 
 * 文件名：TestRepeatThis.java
 * 版本信息：
 * 日期：2017年11月20日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.selenium;

import org.testng.annotations.Test;

/**
 * TestRepeatThis
 * 
 * @author：youngzil@163.com
 * @2017年11月20日 下午9:13:07
 * @since 1.0
 */
public class TestRepeatThis {

    // 这个invocationCount确定TestNG应该运行这个测试方法的次数
    @Test(invocationCount = 10)
    public void repeatThis() {
        System.out.println("repeatThis ");
    }

}
