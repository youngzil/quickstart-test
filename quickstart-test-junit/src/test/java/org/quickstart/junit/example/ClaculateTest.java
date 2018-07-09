/**
 * 项目名称：quickstart-junit 
 * 文件名：ClaculateTest.java
 * 版本信息：
 * 日期：2017年10月19日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.junit.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.quickstart.junit.example.Calculator;

/**
 * http://www.cnblogs.com/qiyexue/p/6822791.html ClaculateTest junit的测试方法必须使用@Test注解 测试方法必须以public void修饰，并且不包含参数
 * 
 * @author：yangzl@asiainfo.com
 * @2017年10月19日 下午7:47:20
 * @since 1.0
 */
public class ClaculateTest {

    @Test
    public void testAdd() {
        /**
         * assertEquals这个方法是一个断言方法 第一个参数表示预期的结果 第二个参数表示程序的执行结果 当预期结果与执行结果是一致的时候，则表示单元测试成功
         */
        assertEquals(4, new Calculator().add(1, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(4, new Calculator().subtract(9, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, new Calculator().multiply(2, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide() {
        assertEquals(3, new Calculator().divide(9, 0));
    }
}
