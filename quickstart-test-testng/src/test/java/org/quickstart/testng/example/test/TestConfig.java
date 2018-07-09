/**
 * 项目名称：quickstart-testng 
 * 文件名：TestConfig.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.example.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * TestConfig
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月21日 下午5:42:26
 * @since 1.0
 */
// show the use of @BeforeSuite and @BeforeTest
public class TestConfig {

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("testBeforeSuite()");
    }

    @AfterSuite
    public void testAfterSuite() {
        System.out.println("testAfterSuite()");
    }

    @BeforeTest
    public void testBeforeTest() {
        System.out.println("testBeforeTest()");
    }

    @AfterTest
    public void testAfterTest() {
        System.out.println("testAfterTest()");
    }

}
