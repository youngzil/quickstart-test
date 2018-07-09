/**
 * 项目名称：quickstart-junit 
 * 文件名：FirstJUnit5Tests.java
 * 版本信息：
 * 日期：2018年3月28日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.junit.junit5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

/**
 * FirstJUnit5Tests
 * 
 * @author：yangzl@asiainfo.com
 * @2018年3月28日 下午4:59:47
 * @since 1.0
 */
public class FirstJUnit5Tests {

    @BeforeEach
    @DisplayName("每条用例开始时执行")
    void start() {

    }

    @AfterEach
    @DisplayName("每条用例结束时执行")
    void end() {

    }

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
        Assertions.assertEquals(3 * 6, 18);
        Assertions.assertTrue(5 > 4);
    }

    @Test
    @DisplayName("描述测试用例╯°□°）╯")
    void testWithDisplayName() {

    }

    @Test
    @Disabled("这条用例暂时跑不过，忽略!")
    void myFailTest() {
        assertEquals(1, 2);
    }

    @Test
    @DisplayName("运行一组断言")
    public void assertAllCase() {
        assertAll("groupAssert", () -> assertEquals(2, 1 + 1), () -> assertTrue(1 > 0));
    }

    @Test
    @DisplayName("依赖注入1")
    public void testInfo(final TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @Test
    @DisplayName("依赖注入2")
    public void testReporter(final TestReporter testReporter) {
        testReporter.publishEntry("name", "Alex");
    }

}
