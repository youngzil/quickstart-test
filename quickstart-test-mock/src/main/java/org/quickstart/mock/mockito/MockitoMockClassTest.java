/**
 * 项目名称：quickstart-mock 
 * 文件名：MockitoMockClassTest.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;
import org.quickstart.mock.easymock.MockedClass;

/**
 * MockitoMockClassTest
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月23日 下午6:28:07
 * @since 1.0
 */
public class MockitoMockClassTest {

    @Test
    public void testMockMethod() {
        MockedClass obj = mock(MockedClass.class);

        when(obj.hello("z3")).thenReturn("hello l4");

        String actual = obj.hello("z3");
        assertEquals("hello l4", actual);

        verify(obj).hello("z3");
        // verify(obj,times(1)).hello("z3");//可以加参数验证次数
        // 在验证阶段可以通过增加参数(time(int)、atLeastOnce()、atLeast(int)、never()等)来精确验证调用次数。
    }

    // 验证调用顺序
    @Test
    public void testMockMethodInOrder() {
        MockedClass objOther = mock(MockedClass.class);
        MockedClass objCn = mock(MockedClass.class);

        when(objOther.hello("z3")).thenReturn("hello l4");
        when(objCn.hello("z3")).thenReturn("hello 张三");

        String other = objOther.hello("z3");
        assertEquals("hello l4", other);
        String cn = objCn.hello("z3");
        assertEquals("hello 张三", cn);

        InOrder inOrder = inOrder(objOther, objCn);// 此行并不决定顺序，下面的两行才开始验证顺序inOrder.verify(objOther).hello("z3");
        inOrder.verify(objCn).hello("z3");
    }

    /*模拟一整个类或者对象，对于没有使用 When().thenReturn()方法指定的函数，系统会返回各种类型的默认值（具体值可参考官方文档）。
    而局部模拟创建出来的模拟对象依然是原系统对象，虽然可以使用方法When().thenReturn()来指定某些具体方法的返回值，但是没有被用此函数修改过的函数依然按照系统原始类的方式来执行，*/

    // 非局部模拟,代码省略了expectations部分(即定义代码行为和输出)，运行该测试可以看到hello方法默认返回null(show方法本来就是无返回值的)，而且在控制台中两个方法都没有输出任何语句。
    @Test
    public void testSkipExpect() {
        MockedClass obj = mock(MockedClass.class);

        assertEquals(null, obj.hello("z3"));
        obj.show();

        verify(obj).hello("z3");
        verify(obj).show();
    }

    // mockito的局部模拟有两种方式，一种是doCallRealMethod()方式，另一种是spy()方式。

    // 局部模拟doCallRealMethod ()方式,运行这个测试会发现在执行hello("z3")时会执行原有的代码，而执行hello("l4")时则是返回默认值null且没有输出打印，执行show()同样没有输出打印。

    @Test
    public void testCallRealMethod() {
        MockedClass obj = mock(MockedClass.class);

        doCallRealMethod().when(obj).hello("z3");

        assertEquals("hello z3", obj.hello("z3"));
        assertEquals(null, obj.hello("l4"));
        obj.show();

        verify(obj).hello("z3");
        verify(obj).hello("l4");
        verify(obj).show();
    }

    // 局部模拟spy()方式,运行这个测试会发现在执行hello("z3")时会执行原有的代码，但是执行show()时在控制台中没有打印语句。
    @Test
    public void testSpy() {
        MockedClass obj = spy(new MockedClass());

        doNothing().when(obj).show();

        assertEquals("hello z3", obj.hello("z3"));
        obj.show();

        verify(obj).hello("z3");
        verify(obj).show();
    }

    // 值得注意的是在mockito的psy()方式模拟中expectations部分使用的语法不同，执行起来存在微妙的不同，
    // 代码虽然能顺利运行，但在控制台中输出了hello z3，说明实际的代码仍然执行了，只是mockito在最后替换了返回值。
    @Test
    public void testSpy2() {
        MockedClass obj = spy(new MockedClass());

        when(obj.hello("z3")).thenReturn("hello l4");

        assertEquals("hello l4", obj.hello("z3"));

        verify(obj).hello("z3");
    }

    // 下面的代码就不会执行实际的代码：
    @Test
    public void testSpy3() {
        MockedClass obj = spy(new MockedClass());

        doReturn("hello l4").when(obj).hello("z3");

        assertEquals("hello l4", obj.hello("z3"));

        verify(obj).hello("z3");
    }

}
