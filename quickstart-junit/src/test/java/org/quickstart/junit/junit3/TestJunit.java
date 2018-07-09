/**
 * 项目名称：quickstart-junit 
 * 文件名：TestJunit.java
 * 版本信息：
 * 日期：2017年11月22日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.junit.junit3;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * TestJunit
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月22日 下午10:07:56
 * @since 1.0
 */
public class TestJunit {

    public static void main(String[] args) {

        TestCase test = new Junit3TestCase("mathPow") {
            // 重载
            protected void runTest() throws Throwable {
                testMathPow();
            };
        };
        test.run();

        TestCase test2 = new Junit3TestCase("testMathPow");
        test2.run();

        System.out.println("--------TestSuite------------");
        // 先创建TestSuite，再添加测试方法
        TestSuite testSuite = new TestSuite();
        testSuite.addTest(new Junit3TestCase("testMathPow"));

        // 或者 传入Class，TestSuite会扫描其中的测试方法。
        // TestSuite testSuite = new TestSuite(Junit3TestCase.class,Junit3TestCase2.class,Junit3TestCase3.class);

        // 运行testSuite
        TestResult testResult = new TestResult();
        testSuite.run(testResult);

    }

}
