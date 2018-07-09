/**
 * 项目名称：quickstart-junit 
 * 文件名：ParameterTest.java
 * 版本信息：
 * 日期：2017年10月19日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.junit.example;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * ParameterTest http://www.cnblogs.com/qiyexue/p/6822791.html
 * 
 * @author：yangzl@asiainfo.com
 * @2017年10月19日 下午8:05:53
 * @since 1.0
 */
@RunWith(Parameterized.class)
public class ParameterTest {

    /**
     * 1、更改测试运行器为RunWith(Parameterized.class) 2、声明变量用来存放预期值与结果值 3、声明一个返回值为Collection的公共静态方法，并使用@Parameters进行修饰 4、位测试类声明一个带有参数的公共构造方法，并在其中为声明变量赋值
     */

    // “@RunWith”和“@Parameter”用于提供单元测试的参数值，@Parameters必须返回List []，参数将作为参数传入类构造函数。

    int except; // 用来存储预期结果
    int input1; // 用来存储第一个输入参数
    int input2; // 用来存储第二个输入参数

    @Parameters
    public static Collection<Object[]> initTestData() {
        return Arrays.asList(new Object[][] {{3, 1, 2}, {10, 5, 5}, {6, 4, 2}, {7, 3, 4}});
    }

    public ParameterTest(int except, int input1, int input2) {
        this.except = except;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void testAdd() {
        assertEquals(except, new Calculator().add(input1, input2));
    }

}
