/**
 * 项目名称：quickstart-mock 
 * 文件名：DobaOrderRPCTest.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.powermock.mockito;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

/**
 * DobaOrderRPCTest
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月23日 下午6:05:03
 * @since 1.0
 */
public class DobaOrderRPCTest {

    /*如何模拟static、final、private？
    Mockito可以帮助模拟对象依赖，但是有些特殊场景无法模拟，比如静态变量、静态方法、私有方法。PowerMock是对Mockito的扩展，可以帮助我们解决这些问题。
    例如下面这个对象中有2个私有静态变量ADD_TRACKING_URL、TOKEN，在进行单元测试时，我们需要模拟这2个值：*/

    @InjectMocks
    private DobaOrderRPC dobaOrderRPC;

    // 开启注解，这个方法会调用validateMockitoUsage方法。这个方法有一些好处，具体什么好处还不太清楚。
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUP() throws IllegalArgumentException, IllegalAccessException {
        // MockitoAnnotations.initMocks(this);

        Whitebox.setInternalState(DobaOrderRPC.class, "ADD_TRACKING_URL", "https://sandbox-api.doba.com/v1/orders/%s/add-tracking");
        Whitebox.setInternalState(DobaOrderRPC.class, "TOKEN", "1234567890");

        // 如上使用Whitebox.setInternalState()方法模拟私有静态变量的值。除此，还可以使用MemberModifier.field()方法进行模拟：
        MemberModifier.field(DobaOrderRPC.class, "ADD_TRACKING_URL").set(dobaOrderRPC, "www.baidu.com");

    }

    @Test
    public void testStaticParam() {

        System.out.println(dobaOrderRPC.getTrackingUrl());
        System.out.println(dobaOrderRPC.getToken());

    }

}
