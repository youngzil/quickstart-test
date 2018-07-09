/**
 * 项目名称：quickstart-junit 
 * 文件名：CalculatorTest.java
 * 版本信息：
 * 日期：2017年10月23日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.junit.junit3;

import org.quickstart.junit.example.Calculator;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * CalculatorTest
 * 
 * @author：yangzl@asiainfo.com
 * @2017年10月23日 下午9:10:16
 * @since 1.0
 */
public class CalculatorTest extends TestCase {
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        // 判断方法的返回结果
        Assert.assertEquals(3, result);// 第一个参数是期望值，第二个参数是要验证的值
    }

    public void testSubtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(1, 2);
        // 判断方法的返回结果
        Assert.assertEquals(-1, result);// 第一个参数是期望值，第二个参数是要验证的值

    }

    public void testMultiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(2, 3);
        // 判断方法的返回结果
        Assert.assertEquals(6, result);// 第一个参数是期望值，第二个参数是要验证的值

    }

    public void testDivide() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(12, 3);
        // 判断方法的返回结果
        Assert.assertEquals(4, result);// 第一个参数是期望值，第二个参数是要验证的值

    }

    @Override
    public void setUp() throws Exception {
        System.out.println("set up");
    }

    @Override
    public void tearDown() throws Exception {
        System.out.println("tear down");
    }

}
