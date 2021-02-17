/**
 * 项目名称：quickstart-junit 
 * 文件名：Junit3TestCase.java
 * 版本信息：
 * 日期：2017年11月22日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.junit.junit3;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Junit3TestCase
 * 
 * @author：youngzil@163.com
 * @2017年11月22日 下午10:12:08
 * @since 1.0
 */
// 测试java.lang.Math
// 必须继承TestCase
public class Junit3TestCase extends TestCase {

    public Junit3TestCase() {
        super();
    }

    // 传入测试用例名称
    public Junit3TestCase(String name) {
        super(name);
    }

    // TestSuite是测试用例套件，能够运行过个测试方法。如果不指定TestSuite，会创建一个默认的TestSuite。默认TestSuite会扫描当前内中的所有测试方法，然后运行。
    // 如果不想采用默认的TestSuite，则可以自定义TestSuite。在TestCase中，可以通过静态方法suite()返回自定义的suite。
    public static Test suite() {
        System.out.println("create suite");
        TestSuite suite = new TestSuite();
        suite.addTest(new Junit3TestCase("testMathPow"));
        return suite;
    }

    // 在每个Test运行之前运行
    @Override
    protected void setUp() throws Exception {
        System.out.println("Set up");
    }

    // 测试方法。
    // 方法名称必须以test开头，没有参数，无返回值，是公开的，可以抛出异常
    // 也即类似public void testXXX() throws Exception {}
    public void testMathPow() {
        System.out.println("Test Math.pow");
        Assert.assertEquals(4.0, Math.pow(2.0, 2.0));
    }

    public void testMathMin() {
        System.out.println("Test Math.min");
        Assert.assertEquals(2.0, Math.min(2.0, 4.0));
    }

    // 在每个Test运行之后运行
    @Override
    protected void tearDown() throws Exception {
        System.out.println("Tear down");
    }
}
