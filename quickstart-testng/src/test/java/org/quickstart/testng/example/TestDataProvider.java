/**
 * 项目名称：quickstart-testng 
 * 文件名：TestDataProvider.java
 * 版本信息：
 * 日期：2017年11月20日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.example;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.junit.Ignore;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TestDataProvider 将数据值拉入XML文件可能非常方便，但测试偶尔会需要复杂的类型，这些类型不能被表示为一个字符串或一个原始类型值。 TestNG使用@DataProvider注解来处理这种情况，这有助于将复杂参数类型映射到测试方法。
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月20日 下午8:32:27
 * @since 1.0
 */
public class TestDataProvider {

    // 通过@DataProvider传递参数
    @Test(dataProvider = "provideNumbers", enabled = false)
    public void test(int number, int expected) {
        // Assert.assertEquals(number + 10, expected);
        System.out.println("number=" + number + ",expected=" + expected);
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {
        return new Object[][] {{10, 20}, {100, 110}, {200, 210}};
    }

    // @DataProvider支持传递一个对象参数。 下面的例子显示了如何传递一个Map对象作为参数。
    @Test(dataProvider = "dbconfig", enabled = false)
    public void testConnection(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
        }
    }

    @DataProvider(name = "dbconfig")
    public Object[][] provideDbConfig() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "yangzl");
        map.put("password", "123456");
        return new Object[][] {{map}};
    }

    // @DataProvider + 方法，此示例显示如何根据测试方法名称传递不同的参数。
    @Test(dataProvider = "dataProvider", enabled = false)
    public void test1(int number, int expected) {
        Assert.assertEquals(number, expected);
    }

    @Test(dataProvider = "dataProvider", enabled = false)
    public void test2(String email, String expected) {
        Assert.assertEquals(email, expected);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(Method method) {

        Object[][] result = null;

        if (method.getName().equals("test1")) {
            result = new Object[][] {{1, 1}, {200, 200}};
        } else if (method.getName().equals("test2")) {
            result = new Object[][] {{"test@gmail.com", "test@gmail.com"}, {"test@yahoo.com", "test@yahoo.com"}};
        }

        return result;

    }

    // @DataProvider + ITestContext，在TestNG中，我们可以使用org.testng.ITestContext来确定调用当前测试方法的运行时参数。 在最后一个例子中，我们将演示如何根据包含的分组名称传递参数。

    @Test(dataProvider = "dataProviderGroup", groups = {"groupA"}, enabled = false)
    public void testGroup1(int number) {
        Assert.assertEquals(number, 1);
    }

    @Test(dataProvider = "dataProviderGroup", groups = "groupB", enabled = false)
    public void testGroup2(int number) {
        Assert.assertEquals(number, 2);
    }

    @DataProvider(name = "dataProviderGroup")
    public Object[][] provideData(ITestContext context) {
        Object[][] result = null;

        // get test name
        System.out.println(context.getName());

        for (String group : context.getIncludedGroups()) {

            System.out.println("group : " + group);

            if ("groupA".equals(group)) {
                result = new Object[][] {{1}};
                break;
            }

        }

        if (result == null) {
            result = new Object[][] {{2}};
        }
        return result;
    }

    // @DataProvider for Vector，String或Integer作为参数，参考如下代码 -
    @Test(dataProvider = "Data-Provider-Function", enabled = false)
    public void parameterIntTest(Class clzz, String[] number) {
        System.out.println("Parameterized clzz is : " + clzz);
        System.out.println("Parameterized Number[0] is : " + number[0]);
        System.out.println("Parameterized Number[1] is : " + number[1]);
    }

    // This function will provide the patameter data
    @DataProvider(name = "Data-Provider-Function")
    public Object[][] parameterIntTestProvider() {
        return new Object[][] {{Vector.class, new String[] {"java.util.AbstractList", "java.util.AbstractCollection"}}, {String.class, new String[] {"1", "2"}},
                {Integer.class, new String[] {"3", "4"}}};
    }

    @Test(dataProvider = "Data-Provider-Function-object", enabled = true)
    public void parameterIntTest2(People people) {
        System.out.println("people.getName()=" + people.getName());
        System.out.println("people.getAge()=" + people.getAge());
    }

    // This function will provide the patameter data
    @DataProvider(name = "Data-Provider-Function-object")
    public Object[][] parameterIntTestProvider2() {

        People people = new People();
        people.setName("yangzl");
        people.setAge(21);

        return new Object[][] {{people}};
    }

}
