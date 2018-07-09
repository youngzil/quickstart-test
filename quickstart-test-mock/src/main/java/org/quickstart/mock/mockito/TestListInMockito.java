/**
 * 项目名称：quickstart-mock 
 * 文件名：TestListInMockito.java
 * 版本信息：
 * 日期：2017年11月22日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;

/**
 * TestListInMockito
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月22日 下午10:35:16
 * @since 1.0
 */
public class TestListInMockito {

    // Mockito没有录制过程，只需要在“运行测试代码”之前对接口进行Stub，也即设置方法的返回值或抛出的异常，然后直接运行测试代码，运行期间调用Mock的方法，会返回预先设置的返回值或抛出异常，最后再对测试代码进行验证。
    // 验证调用行为
    @Test
    public void testVerify() {
        // 创建Mock
        List mockedList = mock(List.class);

        // 使用Mock对象
        mockedList.add("one");
        mockedList.clear();

        // 验证行为
        verify(mockedList).add("one");
        verify(mockedList).clear();

    }

    // 对Mock对象进行Stub
    @Test
    public void testStub() {

        // 也可以Mock具体的类，而不仅仅是接口
        LinkedList mockedList = mock(LinkedList.class);

        // Stub
        when(mockedList.get(0)).thenReturn("first"); // 设置返回值
        when(mockedList.get(1)).thenThrow(new RuntimeException()); // 抛出异常

        // 第一个会打印 "first"
        System.out.println(mockedList.get(0));

        // 接下来会抛出runtime异常
        // System.out.println(mockedList.get(1));

        // 接下来会打印"null",这是因为没有stub get(999)
        System.out.println(mockedList.get(999));

        // 可以选择性地验证行为，比如只关心是否调用过get(0)，而不关心是否调用过get(1)
        verify(mockedList).get(0);
        verify(mockedList).get(1);

        List mock = mock(List.class);
        when(mock.get(0)).thenReturn("one");
        when(mock.get(1)).thenReturn("two");

        // someCodeThatInteractsWithMock();
        mockedList.get(0);
        mockedList.get(1);

        verify(mock).clear();

    }

    @Test
    public void testVerificationInOrder() {

        List one = mock(List.class);
        List two = mock(List.class);

        // someCodeThatInteractsWithMocks();

        InOrder inOrder = inOrder(one, two);

        inOrder.verify(one).add("one");
        inOrder.verify(two).add("two");

    }

    @Test
    public void testStubbingVoidMethods() {
        List mock = mock(List.class);

        // doThrow(new RuntimeException()).when(mock).clear();
    }

    @Test
    public void testExactNumberOfTimesVerificationAndArgumentMatchers() {
        List mock = mock(List.class);

        // someCodeThatInteractsWithMock();

        // verify(mock, times(3)).clear();
        // verify(mock, atLeastOnce()).add(anyObject());
    }

}
