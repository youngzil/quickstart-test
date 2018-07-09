/**
 * 项目名称：quickstart-mock 
 * 文件名：Class2MockedTest.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.powermock.mockito;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Class2MockedTest
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月23日 下午7:14:19
 * @since 1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Class2Mocked.class})
public class Class2MockedTest {

    @Test
    public void testMockStaticMethod() {
        mockStatic(Class2Mocked.class);
        when(Class2Mocked.getDouble(1)).thenReturn(3);

        int actual = Class2Mocked.getDouble(1);
        assertEquals(3, actual);

        verifyStatic();
        Class2Mocked.getDouble(1);
    }

    // PowerMockit的局域模拟使用方式和mockito类似(毕竟是扩展mockito),但强大之处在于可以模拟private方法，普通方法和final方法。模拟普通方法和final方法的方式与模拟private方法一模一样，现以模拟private方法为例。
    // 模拟私有方法(doCallRealMethod方式)
    @Test
    public void testMockPrivateMethod() throws Exception {
        Class2Mocked obj = mock(Class2Mocked.class);

        when(obj, "multiply3", 1).thenReturn(4);
        doCallRealMethod().when(obj).getTripleString(1);

        String actual = obj.getTripleString(1);
        assertEquals("4", actual);

        verifyPrivate(obj).invoke("multiply3", 1);
    }

    // 模拟私有方法(spy方式)

    @Test
    public void testMockPrivateMethod2() throws Exception {
        Class2Mocked obj = spy(new Class2Mocked());
        when(obj, "multiply3", 1).thenReturn(4);

        String actual = obj.getTripleString(1);
        assertEquals("4", actual);

        verifyPrivate(obj).invoke("multiply3", 1);
    }

    // 模拟构造方法
    @Test
    public void testStructureWhenPathDoesntExist() throws Exception {
        final String directoryPath = "mocked path";

        File directoryMock = mock(File.class);

        whenNew(File.class).withArguments(directoryPath).thenReturn(directoryMock);
        when(directoryMock.exists()).thenReturn(true);

        File file = new File(directoryPath);
        assertTrue(file.exists());

        verifyNew(File.class).withArguments(directoryPath);
        verifyPrivate(directoryMock).invoke("exists");
    }

}
