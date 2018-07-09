/**
 * 项目名称：quickstart-mock 
 * 文件名：MainTstObject.java
 * 版本信息：
 * 日期：2017年11月22日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.jmock;

/**
 * MainTstObject
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月22日 下午8:55:33
 * @since 1.0
 */
public class MainTstObject {

    private MayMockObject mayMockObject; // 引用了外接接口

    public String create(String str1, String str2) {
        return str1 + this.mayMockObject.getString(str2);
    }

    public void setMayMockObject(MayMockObject mayMockObject) {
        this.mayMockObject = mayMockObject;
    }

}
