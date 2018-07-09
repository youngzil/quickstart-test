/**
 * 项目名称：quickstart-testng 
 * 文件名：TestOrder.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.example.test;

import org.testng.annotations.Test;

/**
 * TestOrder
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月21日 下午5:43:21
 * @since 1.0
 */
public class TestOrder {

    @Test(groups = {"orderBo", "save"})
    public void testMakeOrder() {
        System.out.println("testMakeOrder");
    }

    @Test(groups = {"orderBo", "save"})
    public void testMakeEmptyOrder() {
        System.out.println("testMakeEmptyOrder");
    }

    @Test(groups = "orderBo")
    public void testUpdateOrder() {
        System.out.println("testUpdateOrder");
    }

    @Test(groups = "orderBo")
    public void testFindOrder() {
        System.out.println("testFindOrder");
    }

}
