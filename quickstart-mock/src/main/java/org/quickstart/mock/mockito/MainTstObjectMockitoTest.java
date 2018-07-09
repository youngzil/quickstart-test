/**
 * 项目名称：quickstart-mock 
 * 文件名：MainTstObjectMockitoTest.java
 * 版本信息：
 * 日期：2017年11月22日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.quickstart.mock.jmock.MainTstObject;
import org.quickstart.mock.jmock.MayMockObject;

/**
 * MainTstObjectMockitoTest
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月22日 下午8:56:18
 * @since 1.0
 */
public class MainTstObjectMockitoTest {

    // 指定Mock的对象
    @Mock
    private MayMockObject mayMockObject;

    private MainTstObject mainTstObject;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // 声明测试用例类

        this.mainTstObject = new MainTstObject();
        this.mainTstObject.setMayMockObject(this.mayMockObject);

        // 另外需要注意的是：JMock只能Mock接口，也就是上面的例子中【MayMockObject】只能为接口，不能为实体类；而Mockito就没有这个限制。
    }

    @Test
    public void process() {
        String str1 = "Mockito返回字符串。";
        String str2 = "Mockito返回字符串。";

        Mockito.when(this.mayMockObject.getString(str2)).thenReturn(""); // Mock返回值

        String str3 = "hello";
        Mockito.when(this.mayMockObject.getString(str3)).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                String str4 = "world";
                return str4;
            }

        }); // Mock返回值

        String ret = this.mainTstObject.create(str1, str2);

        System.out.println(ret);

        Assert.assertEquals(ret, str1);
    }

    @After
    public void tearDown() {}

}
