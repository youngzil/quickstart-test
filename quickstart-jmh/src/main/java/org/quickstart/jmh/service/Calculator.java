/**
 * 项目名称：quickstart-jmh 
 * 文件名：Calculator.java
 * 版本信息：
 * 日期：2018年9月14日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.jmh.service;

/**
 * Calculator 
 *  
 * @author：yangzl@asiainfo.com
 * @2018年9月14日 下午3:55:08 
 * @since 1.0
 */
public interface Calculator {
    /**
     * calculate sum of an integer array
     * @param numbers
     * @return
     */
    public long sum(int[] numbers);

    /**
     * shutdown pool or reclaim any related resources
     */
    public void shutdown();
}
