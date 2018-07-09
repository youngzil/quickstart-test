/**
 * 项目名称：quickstart-mock 
 * 文件名：Class2Mocked.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.powermock.mockito;

/**
 * Class2Mocked
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月23日 下午7:12:36
 * @since 1.0
 */
public class Class2Mocked {

    public static int getDouble(int i) {
        return i * 2;
    }

    public String getTripleString(int i) {
        return multiply3(i) + "";
    }

    private int multiply3(int i) {
        return i * 3;
    }

}
