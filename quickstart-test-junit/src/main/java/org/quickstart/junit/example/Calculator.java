/**
 * 项目名称：quickstart-junit 
 * 文件名：Claculate.java
 * 版本信息：
 * 日期：2017年10月19日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.junit.example;

/**
 * Claculate 被测试类，通过Junit对此类的方法进行单元测试
 * 
 * @author：yangzl@asiainfo.com
 * @2017年10月19日 下午7:46:40
 * @since 1.0
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

}
