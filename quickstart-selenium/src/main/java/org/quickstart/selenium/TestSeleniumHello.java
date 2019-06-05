/**
 * 项目名称：quickstart-selenium 
 * 文件名：TestSeleniumHello.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

/**
 * TestSeleniumHello http://blog.csdn.net/jinhe123/article/details/69946234
 * 
 * @author：youngzil@163.com
 * @2017年11月21日 上午10:00:54
 * @since 1.0
 */
public class TestSeleniumHello {

    public static void main(String[] args) throws InterruptedException {

        // 如果火狐浏览器没有默认安装在C盘，需要自己确定其路径
        // System.setProperty("webdriver.firefox.bin", "D:/Program Files/Mozilla Firefox/firefox.exe");
        // System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
        // System.setProperty("webdriver.gecko.driver", "D:\\selenium\\geckodriver.exe");

        /* 什么是Gecko和Gecko Driver
        Gecko是由Mocilla开发的许多应用程序中的Web浏览器引擎。
        Gecko则是一种介于你的Selenium的测试代码与Firfox浏览器之间的链接，是使用W3C 
        WebDriver兼容客户端的一种代理与Gecko核心浏览器交互。
        火狐浏览器用可执行程序GeckoDriver.exe的方式执行WebDriver协议。所有的测试脚本都通过GeckoDriver来执行。*/

        // 支持的浏览器：chrome、edge、firefox、ie、opera、safari、

        /*System.setProperty("webdriver.gecko.driver", "/Users/yangzl/mysoft/selenium/geckodriver");
        // 定义驱动对象为 FirefoxDriver 对象
         WebDriver driver = new FirefoxDriver();*/

        System.setProperty("webdriver.chrome.driver", "/Users/yangzl/mysoft/selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        /*System.setProperty("webdriver.safari.driver", "/Users/extrabux/library/safari/extensions");
        SafariDriver driver = new SafariDriver();*/

        /*System.setProperty("webdriver.edge.driver", "/Users/yangzl/mysoft/selenium/MicrosoftWebDriver.exe");
        EdgeDriver driver = new EdgeDriver();*/

        /*System.setProperty("webdriver.ie.driver", "/Users/yangzl/mysoft/selenium/IEDriverServer.exe");
        InternetExplorerDriver driver = new InternetExplorerDriver();*/

        /*System.setProperty("webdriver.opera.driver", "/Users/yangzl/mysoft/selenium/operadriver");
        OperaDriver driver = new OperaDriver();*/

        // 打开的网址
        driver.get("https://www.baidu.com/");
        // driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        // 定位输入框元素
        WebElement txtbox = driver.findElement(By.name("wd"));
        // 在输入框输入文本
        txtbox.sendKeys("WebDriver");
        // 定位按钮元素
        WebElement btn = driver.findElement(By.id("su"));
        // 点击按钮
        btn.click();

        // 为了查看打开浏览器效果，在关闭之前睡眠10s
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭驱动
        driver.close();

    }

}
