/**
 * 项目名称：quickstart-testng 
 * 文件名：TestNGTest.java
 * 版本信息：
 * 日期：2017年11月20日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.example;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * TestNGTest
 * 
 * @author：youngzil@163.com
 * @2017年11月20日 下午6:06:26
 * @since 1.0
 */
public class TestNGTest {

    @BeforeTest // 标记指定所有测试进行前呼叫此 method
    public void beforeAllTest() {
        System.out.println(" Before All Test ");
    }

    @AfterTest // 标记指定所有测试进行后呼叫此 method
    public void afterAllTest() {
        System.out.println(" After All Test ");
    }

    @BeforeMethod // 标记指定每个测试进行前呼叫此 method
    public void setUp() {
        System.out.println(" Before Each Test Method ");
    }

    @AfterMethod // 标记指定每个测试进行后呼叫此 method
    public void tearDown() {
        System.out.println(" After Each Test Method ");
    }

    @Test(groups = {" group1 "}) // 标记为测试程式，并为分组 group1
    public void group1Test() {
        System.out.println(" Group 1 ");
    }

    @Test(groups = {" group2 "}) // 标记为测试程式，并为分组 group2
    public void group2Test() {
        System.out.println(" Group 2 ");
    }

    @Test(groups = {" group3 "}) // 标记为测试程式，并为分组 group3
    public void group3Test() {
        System.out.println(" Group 3 ");
    }

}
