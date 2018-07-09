/**
 * 项目名称：quickstart-mock 
 * 文件名：TestListInEasyMock.java
 * 版本信息：
 * 日期：2017年11月22日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.easymock;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.createStrictControl;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Assert;
import org.junit.Test;

/**
 * TestListInEasyMock
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月22日 下午10:30:04
 * @since 1.0
 */
public class TestListInEasyMock {

    /*EasyMock把测试过程分为三步：录制、运行测试代码、验证期望。
    录制过程大概就是：期望method(params)执行times次（默认一次），返回result（可选），抛出exception异常（可选）。
    验证期望过程将会检查方法的调用次数。*/

    @Test
    public void testListInEasyMock() {
        List list = EasyMock.createMock(List.class);
        // 录制过程

        // 期望方法list.set(0,1)执行2次，返回null，不抛出异常
        expect1: EasyMock.expect(list.set(0, 1)).andReturn(null).times(2);
        // 期望方法list.set(0,1)执行1次，返回null，不抛出异常
        expect2: EasyMock.expect(list.set(0, 1)).andReturn(1);

        // 执行测试代码
        EasyMock.replay(list);
        // 执行list.set(0,1)，匹配expect1期望，会返回null
        Assert.assertNull(list.set(0, 1));
        // 执行list.set(0,1)，匹配expect1（因为expect1期望执行此方法2次），会返回null
        Assert.assertNull(list.set(0, 1));
        // 执行list.set(0,1)，匹配expect2，会返回1
        Assert.assertEquals(2, list.set(0, 1));

        // 验证期望
        EasyMock.verify(list);

    }

    @Test
    public void testListInEasyMock2() {

        List mock = createNiceMock(List.class);

        expect(mock.get(0)).andStubReturn("one");
        expect(mock.get(1)).andStubReturn("two");
        mock.clear();

        replay(mock);

        // someCodeThatInteractsWithMock();

        verify(mock);

    }

    @Test
    public void testVerificationInOrder() {

        IMocksControl control = createStrictControl();

        List one = control.createMock(List.class);
        List two = control.createMock(List.class);

        expect(one.add("one")).andReturn(true);
        expect(two.add("two")).andReturn(true);

        control.replay();

        // someCodeThatInteractsWithMocks();

        control.verify();

        // 测试2
        // 如果需要在相对复杂的测试用例中使用多个 Mock 对象，EasyMock 提供了另外一种生成和管理 Mock 对象的机制：
        IMocksControl control2 = EasyMock.createControl();
        java.sql.Connection mockConnection = control2.createMock(Connection.class);
        java.sql.Statement mockStatement = control2.createMock(Statement.class);
        java.sql.ResultSet mockResultSet = control2.createMock(ResultSet.class);

    }

    @Test
    public void testStubbingVoidMethods() {
        List mock = createNiceMock(List.class);

        mock.clear();
        // expectLastCall().andThrow(new RuntimeException());

        replay(mock);

    }

    @Test
    public void testExactNumberOfTimesVerificationAndArgumentMatchers() {

        List mock = createNiceMock(List.class);

        mock.clear();

        // expectLastCall().times(3);
        // expect(mock.add(anyObject())).andReturn(true).atLeastOnce();

        replay(mock);

        // someCodeThatInteractsWithMock();

        verify(mock);

    }

}
