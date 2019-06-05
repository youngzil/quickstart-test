/**
 * 项目名称：quickstart-selenium 
 * 文件名：ElementLocalizeExample.java
 * 版本信息：
 * 日期：2017年11月25日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ElementLocalizeExample https://www.cnblogs.com/qingchunjun/p/4208159.html
 * 
 * @author：youngzil@163.com
 * @2017年11月25日 下午6:20:50
 * @since 1.0
 */
public class ElementLocalizeExample {

    public static void main(String[] args) {
        // Selenium Webdriver元素定位的八种常用方式
        // 在使用selenium webdriver进行元素定位时，通常使用findElement或findElements方法结合By类返回的元素句柄来定位元素。
        // 其中By类的常用定位方式共八种，现分别介绍如下。

        System.setProperty("webdriver.chrome.driver", "/Users/yangzl/mysoft/selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        // By类对应HTML的几种查找元素的方法
        // 定位输入框元素
        WebElement txtbox = driver.findElement(By.name("wd"));// 1

        WebElement searchBox = driver.findElement(By.id("gbqfba"));// 2

        // 该方法可以通过元素的标签名称来查找元素。该方法跟之前两个方法的区别是，这个方法搜索到的元素通常不止一个，所以一般建议结合使用findElements方法来使用。比如我们现在要查找页面上有多少个button，就可以用button这个tagName来进行查找
        List<WebElement> buttons = driver.findElements(By.tagName("button"));// 3
        System.out.println(buttons.size()); // 打印出button的个数

        List<WebElement> allInputs = driver.findElements(By.tagName("input"));

        // 只打印所有文本框的值
        // 单选框、复选框、文本框和密码框的元素标签都是input，此时单靠tagName无法准确地得到我们想要的元素，需要结合type属性才能过滤出我们要的元素。
        for (WebElement e : allInputs) {
            if (e.getAttribute("type").equals("text")) {
                System.out.println(e.getText().toString()); // 打印出每个文本框里的值
            }
        }

        WebElement searchBox2 = driver.findElement(By.className("buttonStyle"));// 4

        // 这个方法比较直接，即通过超文本链接上的文字信息来定位元素，这种方式一般专门用于定位页面上的超文本链接。通常一个超文本链接会长成这个样子：
        // <a href="/intl/en/about.html">About Google</a>
        WebElement aboutLink = driver.findElement(By.linkText("About Google"));// 5

        // 这个方法是上一个方法的扩展。当你不能准确知道超链接上的文本信息或者只想通过一些关键字进行匹配时，可以使用这个方法来通过部分链接文字进行匹配。
        // 注意：使用这种方法进行定位时，可能会引起的问题是，当你的页面中不止一个超链接包含About时，findElement方法只会返回第一个查找到的元素，而不会返回所有符合条件的元素。如果你要想获得所有符合条件的元素，还是只能使用findElements方法。
        WebElement aboutLink2 = driver.findElement(By.partialLinkText("About"));// 6

        // 这个方法是非常强大的元素查找方式，使用这种方法几乎可以定位到页面上的任意元素。在正式开始使用XPath进行定位前，我们先了解下什么是XPath。XPath是XML Path的简称，由于HTML文档本身就是一个标准的XML页面，所以我们可以使用XPath的语法来定位页面元素。
        // 如果我们现在要引用id为“J_password”的input元素，该怎么写呢？我们可以像下面这样写：
        WebElement password = driver.findElement(By.xpath("//*[@id='J_login_form']/dl/dt/input[@id='J_password']"));// 7
        // 也可以写成：
        WebElement password2 = driver.findElement(By.xpath("//*[@id='J_login_form']/*/*/input[@id='J_password']"));// 7
        // 用xpath的几种模糊匹配模式来定位它吧，主要有三种方式
        // a. 用contains关键字，定位代码如下：
        driver.findElement(By.xpath("//a[contains(@href, 'logout')]"));
        // b. 用start-with，定位代码如下：
        driver.findElement(By.xpath("//a[starts-with(@rel, 'nofo')]"));
        // c. 用Text关键字，定位代码如下：
        driver.findElement(By.xpath("//*[text()='退出']"));
        // 如果知道超链接元素的文本内容，也可以用,这种方式一般用于知道超链接上显示的部分或全部文本信息时，可以使用。
        driver.findElement(By.xpath("//a[contains(text(), '退出')]"));

        /*cssSelector这种元素定位方式跟xpath比较类似，但执行速度较快，而且各种浏览器对它的支持都相当到位，所以功能也是蛮强大的。
        下面是一些常见的cssSelector的定位方式：
        定位id为flrs的div元素，可以写成：#flrs     注：相当于xpath语法的//div[@id=’flrs’]
        定位id为flrs下的a元素，可以写成 #flrs > a  注：相当于xpath语法的//div[@id=’flrs’]/a
        定位id为flrs下的href属性值为/forexample/about.html的元素，可以写成： #flrs > a[href=”/forexample/about.html”]
        如果需要指定多个属性值时，可以逐一加在后面，如#flrs > input[name=”username”][type=”text”]。*/

        // 明白基本语法后，我们来尝试用cssSelector方式来引用图（3）中选中的那个input对象，代码如下：
        WebElement password3 = driver.findElement(By.cssSelector("#J_login_form>dl>dt>input[id=’ J_password’]"));
        driver.findElement(By.cssSelector("button.btn.btn_big.btn_submit"));

    }

}
