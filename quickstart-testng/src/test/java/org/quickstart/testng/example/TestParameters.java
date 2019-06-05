/**
 * 项目名称：quickstart-testng 
 * 文件名：TestParameters.java
 * 版本信息：
 * 日期：2017年11月20日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.example;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * TestParameters
 * 
 * @author：youngzil@163.com
 * @2017年11月20日 下午8:32:52
 * @since 1.0
 */
public class TestParameters {

    @Parameters({"username", "password"})
    // @Test(groups = "login")
    @Test(groups = "login", testName = "example1")
    public void createConnection(@Optional("sss") String username, @Optional("dddd") String password) {
        System.out.println("Input Username: " + username);
        System.out.println("Input Password: " + password);
    }

}
