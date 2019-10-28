/**
 * 项目名称：quickstart-mock 
 * 文件名：MockitoTestExample.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * MockitoTestExample
 * 
 * @author：youngzil@163.com
 * @2017年11月23日 上午10:46:11
 * @since 1.0
 */
public class MockitoTestExample {

    /**
     * 1、 构造无参函数的返回 测试无参数函数mock
     */
    @Test(priority = 0)
    public void testReturnDirect() {
        String mocked = "mocked Return";
        Demo demo = Mockito.mock(Demo.class);
        Mockito.when(demo.methodNoParameters()).thenReturn(mocked);
        Assert.assertEquals(demo.methodNoParameters(), mocked);
    }

    /**
     * 2、构造有基本类型作为参数的返回 测试任意基本类型参数函数mock
     */
    @Test(priority = 1)
    public void testMethodWithParameter() {
        String word = "mocked Return";
        Demo demo = Mockito.mock(Demo.class);
        Mockito.when(demo.speak(Mockito.anyString())).thenReturn(word);
        Assert.assertEquals(demo.speak("你好"), word);
    }

    /**
     * 3、构造有基本类型作为参数，但是只针对特定参数输入才mock返回值 测试特定参数mock
     */
    @Test(priority = 2)
    public void testMethodWithSpecificParameter() {
        String word = "mocked Return";
        Demo demo = Mockito.mock(Demo.class);
        Mockito.when(demo.speak(Mockito.matches(".*大爷$"))).thenReturn(word);
        Assert.assertEquals(demo.speak("大爷"), word);
    }

    /**
     * 4、构造自定义类作为函数参数的返回，这种情况稍微复杂一些，需要实现一个matcher类 测试自定义类型参数的mock
     */
    @Test(priority = 3)
    public void testMethodWithCustomParameter() {
        String word = "mocked Return";
        Demo demo = Mockito.mock(Demo.class);
        Mockito.when(demo.methodCustomParameters(Mockito.argThat(new IsParameterClass()), Mockito.anyString())).thenReturn(word);
        Assert.assertEquals(demo.methodCustomParameters(new ParameterClass(), "你猜"), word);
    }

    // 自定义一个与之匹配的matcher类
    class IsParameterClass implements ArgumentMatcher<ParameterClass> {
        public boolean matches(ParameterClass para) {
            return para.getClass() == ParameterClass.class;
        }
    }

    /**
     * 5、构造null返回 测试mock的函数返回null
     */
    @Test(priority = 4)
    public void testMethodWithReturnNull() {
        String word = "mocked Return";
        Demo demo = Mockito.mock(Demo.class);
        Mockito.when(demo.speak(Mockito.anyString())).thenReturn(null);
        Assert.assertNotEquals(demo.speak("你猜"), word);
    }

    /**
     * 6、构造mock的函数抛出异常，当然我们可以在testng中设置expectedExceptions以显示声明会抛出指定类型的异常，这样该条case执行的时候就会成功 测试mock的函数抛出异常
     */
    @Test(expectedExceptions = org.mockito.exceptions.base.MockitoException.class, priority = 5)
    public void testMethodReturnException() {
        String word = "mocked Return";
        Demo demo = Mockito.mock(Demo.class);
        Mockito.when(demo.speak(Mockito.anyString())).thenThrow(new Exception());
        demo.speak("你猜");
    }

    /**
     * 7、某些反复调用，我们希望对于每次调用都返回不同的mock值 测试mock的不同次调用返回不同的值
     */
    @Test(priority = 6)
    public void testMethodMultiDiffReturn() {
        String word = "mocked Return 0";
        String word1 = "mocked Return 1";
        Demo demo = Mockito.mock(Demo.class);
        Mockito.when(demo.speak(Mockito.anyString())).thenReturn(word).thenReturn(word1);
        Assert.assertEquals(demo.speak("你猜"), word);
        Assert.assertEquals(demo.speak("你猜"), word1);
    }

    /**
     * 8、验证函数执行是否经过了mock 验证方法是否被mock且是否为所执行的参数调用
     */
    @Test(expectedExceptions = org.mockito.exceptions.misusing.NotAMockException.class, priority = 7)
    public void testMockedMethodRun() {
        String word = "mocked Return";
        Demo demo = Mockito.mock(Demo.class);
        Mockito.when(demo.speak(Mockito.anyString())).thenReturn(word);
        Assert.assertEquals(demo.speak("你猜"), word);
        Mockito.verify(demo.speak("你猜"));
        // 下面这个参数的方法调用并没有被执行过，所以会抛出NotAMockException的异常
        Mockito.verify(demo.speak("nicai"));
    }

}
