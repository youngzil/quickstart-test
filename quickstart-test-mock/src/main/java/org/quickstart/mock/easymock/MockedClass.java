/**
 * 项目名称：quickstart-mock 
 * 文件名：MockedClass.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.easymock;

/**
 * MockedClass
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月23日 下午6:24:14
 * @since 1.0
 */
public class MockedClass {

    public String hello(String name) {
        System.out.println("hello " + name);
        return "hello " + name;
    }

    public void show() {
        System.out.println("Class1Mocked.show()");
    }

}
