/**
 * 项目名称：quickstart-testng 
 * 文件名：TestSpring.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TestSpring
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月21日 下午2:13:48
 * @since 1.0
 */
@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
public class TestSpring extends AbstractTestNGSpringContextTests {

    @Autowired
    EmailGenerator emailGenerator;

    @Test()
    void testEmailGenerator() {

        String email = emailGenerator.generate();
        System.out.println(email);

        Assert.assertNotNull(email);
        Assert.assertEquals(email, "feedback@yiibai.com");

    }

}
