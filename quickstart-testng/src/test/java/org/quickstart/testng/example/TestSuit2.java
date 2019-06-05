/**
 * 项目名称：quickstart-testng 
 * 文件名：TestSuit.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.example;

import org.testng.annotations.Test;

/**
 * TestSuit
 * 
 * @author：youngzil@163.com
 * @2017年11月21日 下午2:36:25
 * @since 1.0
 */
public class TestSuit2 {

    @Test(groups = "group2")
    public void testingGroup2() {
        System.out.println("class:TestSuit2 - Method - testingGroup2()");
    }

}
