/**
 * 项目名称：quickstart-mock 
 * 文件名：Person.java
 * 版本信息：
 * 日期：2017年11月24日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito.java8;

/**
 * Person
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月24日 上午11:40:32
 * @since 1.0
 */
public class Person {

    private String name;

    private JobPosition jobPosition;

    Person() {}

    Person(String name) {

        this.name = name;

    }

    public void setCurrentJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getName() {
        return this.name;
    }

}
