/**
 * 项目名称：quickstart-junit 
 * 文件名：CalculatorTest.java
 * 版本信息：
 * 日期：2018年3月28日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.junit.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.quickstart.junit.example.Calculator;
import static org.junit.jupiter.api.Assertions.*;
/**
 * CalculatorTest
 * 
 * @author：yangzl@asiainfo.com
 * @2018年3月28日 下午5:11:37
 * @since 1.0
 */
@DisplayName("Calculator")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public static void init() {
        System.out.println("Start testing");
    }

    @BeforeEach
    public void create() {
        this.calculator = new Calculator();
    }

    @AfterEach
    public void destroy() {
        this.calculator = null;
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("Finish testing");
    }

    @Test
    @DisplayName("Test 1 + 2 = 3")
    public void testAdd() {
        assertEquals(3, this.calculator.add(1, 2));
    }

    @Test
    @DisplayName("Test 3 - 2 = 1")
    public void testSubtract() {
        assertEquals(1, this.calculator.subtract(3, 2));
    }

    @Disabled
    @Test
    @DisplayName("disabled test")
    public void ignoredTest() {
        System.out.println("This test is disabled");
    }
}
