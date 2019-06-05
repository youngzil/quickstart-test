/**
 * 项目名称：quickstart-junit 
 * 文件名：CalculatorTest2.java
 * 版本信息：
 * 日期：2017年10月23日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.junit.junit3;

import org.quickstart.junit.example.Calculator;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * CalculatorTest2
 * 
 * @author：youngzil@163.com
 * @2017年10月23日 下午9:14:47
 * @since 1.0
 */
public class CalculatorTest2 extends TestCase {

    private Calculator calculator = null;

    @Override
    public void setUp() throws Exception {
        System.out.println("set up");
        // 生成成员变量的实例
        calculator = new Calculator();
        System.out.println(calculator);
    }

    @Override
    public void tearDown() throws Exception {
        System.out.println("tear down");
    }

    public void testAdd() {
        int result = calculator.add(1, 2);
        // 判断方法的返回结果
        Assert.assertEquals(3, result);// 第一个参数是期望值，第二个参数是要验证的值
    }

    public void testSubtract() {
        int result = calculator.subtract(1, 2);
        // 判断方法的返回结果
        Assert.assertEquals(-1, result);// 第一个参数是期望值，第二个参数是要验证的值

    }

    public void testMultiply() {
        int result = calculator.multiply(2, 3);
        // 判断方法的返回结果
        Assert.assertEquals(6, result);// 第一个参数是期望值，第二个参数是要验证的值

    }

    public void testDivide() {
        int result = calculator.divide(12, 3);
        // 判断方法的返回结果
        Assert.assertEquals(4, result);// 第一个参数是期望值，第二个参数是要验证的值

    }

}
