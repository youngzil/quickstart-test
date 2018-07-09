/**
 * 项目名称：quickstart-testng 
 * 文件名：TestDependsOnMethods.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.example;

import org.testng.annotations.Test;

/**
 * TestDependsOnMethods
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月21日 下午4:19:03
 * @since 1.0
 */
public class TestDependsOnMethods {

    // “method2()”只有在“method1()”运行成功的情况下才会执行，否则“method2()”将跳过测试。
    @Test
    public void method1() {
        int dd = 2 / 0;
        System.out.println("This is method 1");
    }

    @Test(dependsOnMethods = {"method1"})
    public void method2() {
        System.out.println("This is method 2");
    }

}
