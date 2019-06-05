/**
 * 项目名称：quickstart-jmeter 
 * 文件名：MathTest.java
 * 版本信息：
 * 日期：2018年7月24日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.jmeter;

/**
 * MathTest
 * 
 * @author：youngzil@163.com
 * @2018年7月24日 下午3:58:28
 * @since 1.0
 */
public class MathTest {
    public String sayHello() {
        return "Hello";
    }

    public String sayHelloToPerson(String s) {
        if (s == null || s.equals(""))
            s = "nobody";
        return (new StringBuilder()).append("Hello ").append(s).toString();
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public static void main(String args[]) {
        MathTest math = new MathTest();
        System.out.println(math.sum(1, 2));
    }
}
