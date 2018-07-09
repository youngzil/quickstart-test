/**
 * 项目名称：quickstart-testng 
 * 文件名：TestGroup.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.example;

import org.testng.annotations.Test;

/**
 * TestGroup
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月21日 下午2:23:16
 * @since 1.0
 */
@Test()
public class TestGroup {

    @Test(groups = "method1")
    public void testingMethod1() {
        System.out.println("Method - testingMethod1()");
    }

    @Test(groups = "method1")
    public void testingMethod1_1() {
        System.out.println("Method - testingMethod1_1()");
    }

    @Test(groups = "method2")
    public void testingMethod2() {
        System.out.println("Method - testingMethod2()");
    }

    @Test(groups = "method3")
    public void testingMethod3() {
        System.out.println("Method - testingMethod3()");
    }

}
