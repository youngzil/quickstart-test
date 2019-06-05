/**
 * 项目名称：quickstart-mock 
 * 文件名：Demo.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

/**
 * Demo
 * 
 * @author：youngzil@163.com
 * @2017年11月23日 上午10:44:48
 * @since 1.0
 */
public class Demo {

    private String name = "laowang";
    private int age;

    public Demo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String speak(String str) {
        return str;
    }

    public String talk(String str) {
        return str;
    }

    public String methodNoParameters() {
        return name;
    }

    public String methodCustomParameters(ParameterClass parameter, String str) {
        return str;
    }

    public String methodHaveChildObj(ParameterClass parameter, String str) {
        parameter.childTalk(str);
        return str;

    }
}
