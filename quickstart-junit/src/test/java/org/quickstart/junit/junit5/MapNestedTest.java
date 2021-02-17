/**
 * 项目名称：quickstart-junit 
 * 文件名：MapNestedTest.java
 * 版本信息：
 * 日期：2018年3月28日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.junit.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * MapNestedTest 
 *  
 * @author：youngzil@163.com
 * @2018年3月28日 下午5:45:21 
 * @since 1.0
 */
@DisplayName("Nested tests for HashMap")
public class MapNestedTest {
 Map<String, Object> map;
 
 @Nested
 @DisplayName("when a new")
 class WhenNew {
    @BeforeEach
    void create() {
       map = new HashMap<>();
    }
 
    @Test
    @DisplayName("is empty")
    void isEmpty() {
       assertTrue(map.isEmpty());
    }
 
    @Nested
    @DisplayName("after adding a new entry")
    class AfterAdd {
       String key = "key";
       Object value = "value";
 
       @BeforeEach
       void add() {
          map.put(key, value);
       }
 
       @Test
       @DisplayName("is not empty")
       void isNotEmpty() {
          assertFalse(map.isEmpty());
       }
 
       @Test
       @DisplayName("returns value when getting by key")
       void returnValueWhenGettingByKey() {
          assertEquals(value, map.get(key));
       }
 
       @Nested
       @DisplayName("after removing the entry")
       class AfterRemove {
          @BeforeEach
          void remove() {
             map.remove(key);
          }
 
          @Test
          @DisplayName("is empty now")
          void isEmpty() {
             assertTrue(map.isEmpty());
          }
 
          @Test
          @DisplayName("returns null when getting by key")
          void returnNullForKey() {
             assertNull(map.get(key));
          }
       }
    }
 }
}
