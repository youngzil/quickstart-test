/**
 * 项目名称：quickstart-mock 
 * 文件名：Jerry.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

/**
 * Jerry
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月23日 下午5:16:24
 * @since 1.0
 */
public class Jerry {

    public void goHome() {
        doSomeThingA();
        doSomeThingB();
    }

    // real invoke it.
    public void doSomeThingB() {
        System.out.println("good day");
    }

    // auto mock method by mockito
    public void doSomeThingA() {
        System.out.println("you should not see this message.");
        doSomeThingB();
    }

    public boolean go() {
        System.out.println("I say go go go!!");
        return true;
    }

}
