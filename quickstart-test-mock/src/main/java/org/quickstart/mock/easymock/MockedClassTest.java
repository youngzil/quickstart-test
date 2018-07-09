/**
 * 项目名称：quickstart-mock 
 * 文件名：MockedClassTest.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.easymock;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.easymock.EasyMock.*;

/**
 * MockedClassTest
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月23日 下午6:25:50
 * @since 1.0
 */
public class MockedClassTest {

    @Test
    public void testMockMethod() {
        MockedClass obj = createMock(MockedClass.class);

        expect(obj.hello("z3")).andReturn("hello l4");
        replay(obj);

        String actual = obj.hello("z3");
        assertEquals("hello l4", actual);

        verify(obj);
    }

}
