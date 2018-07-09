/**
 * 项目名称：quickstart-junit 
 * 文件名：SuiteTest.java
 * 版本信息：
 * 日期：2017年10月19日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * SuiteTest 
 *  http://www.cnblogs.com/qiyexue/p/6822791.html
 * @author：yangzl@asiainfo.com
 * @2017年10月19日 下午7:55:18 
 * @since 1.0
 */

/**
 * 测试套件类 测试套件是用来组织多个测试类一起运行的，使用 @RunWith注解 更改测试运行器为Suite.class，将要测试的类作为数组传入 到Suite.SuiteClasses({})中，测试套件类不能包含其他测试方法
 * 
 * 样例如下：
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TaskTest1.class, TaskTest2.class, TaskTest3.class})
public class SuiteTest {

    // 代码表示在SuiteTest执行之后，单元测试“TaskTest1”、“TaskTest2”和“TaskTest3”一起运行。 所有的声明都是在类内定义的。
}

// outPut：
// this is TaskTest1
// this is TaskTest2
// this is TaskTest3
