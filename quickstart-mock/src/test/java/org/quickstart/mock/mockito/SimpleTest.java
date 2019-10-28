/**
 * 项目名称：quickstart-mock 
 * 文件名：SimpleTest.java
 * 版本信息：
 * 日期：2017年11月22日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * SimpleTest
 * 
 * @author：youngzil@163.com
 * @2017年11月22日 下午11:25:13
 * @since 1.0
 */
public class SimpleTest {

    @Test
    public void simpleTest() {

        // 创建mock对象，参数可以是类，也可以是接口
        List<String> list = mock(List.class);

        // 设置方法的预期返回值
        when(list.get(0)).thenReturn("helloworld");

        String result = list.get(0);

        // 验证方法调用(是否调用了get(0))
        verify(list).get(0);

        // junit测试
        Assert.assertEquals("helloworld", result);

        // 可对方法设定返回异常
        when(list.get(1)).thenThrow(new RuntimeException("test excpetion"));

        // stubbing另一种语法(设置预期值的方法)，可读性不如前者
        doReturn("secondhello").when(list).get(1);

        // 没有返回值的void方法与其设定(支持迭代风格，第一次调用donothing,第二次dothrow抛出runtime异常)
        doNothing().doThrow(new RuntimeException("void exception")).when(list).clear();
        list.clear();
        list.clear();
        verify(list, times(2)).clear();

    }

    // 参数匹配器(Argument Matcher) Matchers类内加你有很多参数匹配器 anyInt、anyString、anyMap.....Mockito类继承于Matchers,Stubbing时使用内建参数匹配器，下例
    // 需要注意的是：如果使用参数匹配器，那么所有的参数都要使用参数匹配器，不管是stubbing还是verify的时候都一样。
    @Test
    public void argumentMatcherTest() {

        List<String> list = mock(List.class);

        when(list.get(anyInt())).thenReturn("hello", "world");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        String result = list.get(0) + list.get(1);

        verify(list, times(2)).get(anyInt());

        Assert.assertEquals("helloworld", result);

    }

    @Test
    public void argumentMatcherTest2() {

        Map<Integer, String> map = mock(Map.class);
        when(map.put(anyInt(), anyString())).thenReturn("hello");// anyString()替换成"hello"就会报错
        map.put(1, "world");
        verify(map).put(eq(1), eq("world")); // eq("world")替换成"world"也会报错

    }

    // 方法调用的验证(具体的调用次数、至少一次，一次也没有)
    @Test
    public void verifyInvocate() {

        List<String> mockedList = mock(List.class);
        // using mock
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        /**
         * 基本的验证方法 verify方法验证mock对象是否有没有调用mockedList.add("once")方法 不关心其是否有返回值，如果没有调用测试失败。
         */
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");// 默认调用一次,times(1)可以省略

        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        // never()等同于time(0),一次也没有调用
        verify(mockedList, times(0)).add("never happened");

        // atLeastOnece/atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("twice");
        verify(mockedList, atMost(5)).add("three times");

    }

    // http://liuzhijun.iteye.com/blog/1512780

}
