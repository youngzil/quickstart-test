/**
 * 项目名称：JavaForJMeter 
 * 文件名：Hello.java
 * 版本信息：
 * 日期：2017年5月22日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.jmeter;

/**
 * Hello
 * 
 * @author：youngzil@163.com
 * @2017年5月22日 下午10:32:35
 * @version 1.0
 */
public class Hello {
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
}
