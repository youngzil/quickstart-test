/**
 * 项目名称：quickstart-mock 
 * 文件名：PartialMockTest.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * PartialMockTest
 * 
 * @author：youngzil@163.com
 * @2017年11月23日 下午5:13:15
 * @since 1.0
 */
public class PartialMockTest {

    /* mockito中实现部分mock两种方式：spy与callRealMethod()
    什么是类的部分mock（partial mock）？
    A：部分mock是说一个类的方法有些是实际调用，有些是使用mockito的stubbing（桩实现）。
    为什么需要部分mock？
    A：当需要测试一个组合方法（一个方法需要其它多个方法协作）的时候，某个叶子方法（只供别人调用，自己不依赖其它反复）已经被测试过，我们其实不需要再次测试这个叶子方法，so，让叶子打桩实现返回结果，上层方法实际调用并测试。
    mockito实现部分mock的两种方式：spy和callRealMethod()
     spy和callrealmethod都可以实现部分mock，唯一不同的是通过spy做的桩实现仍然会调用实际方法，但返回的是你mock要求的返回。
       ★ 批注：spy方法需要使用doReturn方法才不会调用实际方法。*/

    // 当需要整体Mock，只有少部分方法执行真正部分时，选用这种方式

    @Test
    public void callRealMethodTest() {

        Jerry jerry = Mockito.mock(Jerry.class);

        Mockito.doCallRealMethod().when(jerry).goHome();
        Mockito.doCallRealMethod().when(jerry).doSomeThingB();

        jerry.goHome();

        Mockito.verify(jerry, Mockito.times(1)).doSomeThingA();
        Mockito.verify(jerry, Mockito.times(1)).doSomeThingB();
    }

    // 当需要整体执行真正部分，只有少部分方法执行mock，选用这种方式
    @Test
    public void spyTest() {
        Jerry spyJack = Mockito.spy(new Jerry());
        // 用thenReturn 会走go()方法体，然后将返回值Mock掉
        Mockito.when(spyJack.go()).thenReturn(false);
        Assert.assertFalse(spyJack.go());
        // 用doReturn 不走go()方法体
        Mockito.doReturn(false).when(spyJack).go();
        Assert.assertFalse(spyJack.go());
    }

}
