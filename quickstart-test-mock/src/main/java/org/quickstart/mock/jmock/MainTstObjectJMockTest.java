/**
 * 项目名称：quickstart-mock 
 * 文件名：MainTstObjectJMockTest.java
 * 版本信息：
 * 日期：2017年11月22日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.jmock;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * MainTstObjectJMockTest
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月22日 下午9:00:32
 * @since 1.0
 */
public class MainTstObjectJMockTest {

    private Mockery context = new Mockery();

    private MayMockObject mayMockObject;
    private MainTstObject mainTstObject;

    @Before
    public void setUp() {
        this.mayMockObject = this.context.mock(MayMockObject.class); // Mock了外接接口

        this.mainTstObject = new MainTstObject();
        this.mainTstObject.setMayMockObject(this.mayMockObject);

        // 另外需要注意的是：JMock只能Mock接口，也就是上面的例子中【MayMockObject】只能为接口，不能为实体类；而Mockito就没有这个限制。
    }

    @Test
    public void process() {
        final String str1 = "Mockito返回字符串。";
        final String str2 = "Mockito返回字符串。";

        this.context.checking(new Expectations() {
            {
                oneOf(mayMockObject).getString(str2);
                will(returnValue("")); // Mock返回值

                // allowing(mayMockObject).getString(with(any(String.class)));
                // will(returnValue(""));
            }
        });

        String ret = this.mainTstObject.create(str1, str2);

        System.out.println("ret=" + ret);

        Assert.assertEquals(ret, str1);
    }

    @After
    public void tearDown() {}

}
