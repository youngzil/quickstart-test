/**
 * 项目名称：quickstart-junit 
 * 文件名：SuiteTest1.java
 * 版本信息：
 * 日期：2017年10月19日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * SuiteTest1 http://www.cnblogs.com/qiyexue/p/6822791.html
 * 
 * @author：youngzil@163.com
 * @2017年10月19日 下午7:57:22
 * @since 1.0
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({SuiteTest.class, TaskTest4.class})
public class SuiteTest1 {
}

// outPut
// this is TaskTest1
// this is TaskTest2
// this is TaskTest3
// this is TaskTest4
