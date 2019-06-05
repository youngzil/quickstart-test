/**
 * 项目名称：quickstart-testng 
 * 文件名：TestMultipleThreads.java
 * 版本信息：
 * 日期：2017年11月20日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * TestMultipleThreads
 * 
 * @author：youngzil@163.com
 * @2017年11月20日 下午9:16:10
 * @since 1.0
 */
public class TestMultipleThreads {

    @Test(invocationCount = 3)
    public void loadTestThisWebsite() {

        // System.setProperty("webdriver.chrome.driver", "/Users/yangzl/mysoft/selenium/chromedriver");
        // WebDriver driver = new ChromeDriver();

        // https://github.com/mozilla/geckodriver
        System.setProperty("webdriver.gecko.driver", "/Users/yangzl/mysoft/selenium/geckodriver");
        // 定义驱动对象为 FirefoxDriver 对象
        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.yiibai.com");
        System.out.println("Page Title is " + driver.getTitle());
        // AssertJUnit.assertEquals("Google", driver.getTitle());
        AssertJUnit.assertEquals(driver.getTitle(), driver.getTitle());

        // driver.quit();
        // 关闭驱动
        driver.close();

    }

}
