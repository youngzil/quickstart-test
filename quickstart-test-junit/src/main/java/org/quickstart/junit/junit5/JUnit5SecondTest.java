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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * FirstJUnit5Tests
 * 
 * @author：yangzl@asiainfo.com
 * @2018年3月28日 下午4:59:47
 * @since 1.0
 */
public class JUnit5SecondTest {
    
    @Test
    @DisplayName("simple assertion")
    public void simple() {
     assertEquals(3, 1 + 2, "simple math");
     assertNotEquals(3, 1 + 1);
     
     assertNotSame(new Object(), new Object());
     Object obj = new Object();
     assertSame(obj, obj);
     
     assertFalse(1 > 2);
     assertTrue(1 < 2);
     
     assertNull(null);
     assertNotNull(new Object());
    }
    
    @Test
    @DisplayName("array assertion")
    public void array() {
     assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }
    
    
    @Test
    @DisplayName("throws exception")
    public void exception() {
     assertThrows(ArithmeticException.class, () -> System.out.println(1 / 0));
    }
    
    
    @Test
    @DisplayName("fail")
    public void shouldFail() {
     fail("This should fail");
    }
    
    @Test
    @DisplayName("assert all")
    public void all() {
     assertAll("Math",
        () -> assertEquals(2, 1 + 1),
        () -> assertTrue(1 > 0)
     );
    }
    
    
    @Test
    public void emptyString() {
      // JUnit 5
      org.junit.jupiter.api.Assertions.assertTrue("".isEmpty());

      // AssertJ
      org.assertj.core.api.Assertions.assertThat("").isEmpty();

      // Hamcrest
      org.hamcrest.MatcherAssert.assertThat("", "".isEmpty());
    }

    @Test
    public void lambdaExpressions() {
        // lambda expression for condition
        assertTrue(() -> "".isEmpty(), "string should be empty");
        // lambda expression for assertion message
        assertEquals("foo", "foo", () -> "message is lazily evaluated");
    }

    @Test
    public void groupedAssertions() {
        Dimension dim = new Dimension(800, 600);
        assertAll("dimension", () -> assertTrue(dim.getWidth() == 800, "width"), () -> assertTrue(dim.getHeight() == 600, "height"));
    }

    @Test
    public void exceptions() {
        // assert exception type
        assertThrows(RuntimeException.class, () -> {
            throw new NullPointerException();
        });
        // assert on the expected exception
        /*Throwable exception = expectThrows(RuntimeException.class, () -> {
            throw new NullPointerException("should not be null");
        });
        assertEquals("should not be null", exception.getMessage());
        
        
        Exception exception2 = expectThrows(Exception.class, this::throwing);
        assertEquals("Because I can!", exception2.getMessage());*/
        
        
    }

}
