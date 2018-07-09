/**
 * 项目名称：quickstart-testng 
 * 文件名：TestDatabase.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.example.test;

import org.testng.annotations.Test;

/**
 * TestDatabase
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月21日 下午5:42:51
 * @since 1.0
 */
public class TestDatabase {

    @Test(groups = "db")
    public void testConnectOracle() {
        System.out.println("testConnectOracle()");
    }

    @Test(groups = "db")
    public void testConnectMsSQL() {
        System.out.println("testConnectMsSQL");
    }

    @Test(groups = "db-nosql")
    public void testConnectMongoDB() {
        System.out.println("testConnectMongoDB");
    }

    @Test(groups = {"db", "brokenTests"})
    public void testConnectMySQL() {
        System.out.println("testConnectMySQL");
    }

}
