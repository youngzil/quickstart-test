/**
 * 项目名称：quickstart-mock 
 * 文件名：MockitoWithAnnotationTest.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * MockitoWithAnnotationTest http://www.baeldung.com/mockito-annotations https://github.com/eugenp/tutorials/tree/master/testing-modules/mockito http://www.baeldung.com/category/mockito/
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月23日 下午3:33:55
 * @since 1.0
 */
public class MockitoNoAnnotationTest {

    // 注解请看MockitoWithAnnotationTest

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }

    // 使用真正的方法spiedList.add（）将元素添加到spiedList。
    // 存根方法spiedList.size（）返回100，而不是2使用Mockito.doReturn（） 。
    @Test
    public void whenNotUseSpyAnnotation_thenCorrect() {
        List<String> spyList = Mockito.spy(new ArrayList<String>());

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    @Test
    public void whenNotUseCaptorAnnotation_thenCorrect() {
        List mockList = Mockito.mock(List.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

        mockList.add("one");
        Mockito.verify(mockList).add(arg.capture());

        assertEquals("one", arg.getValue());
    }

    // @InjectMocks注解 - 将模拟域自动注入到被测对象中。
    // @InjectMocks将本test类中的mock（或@mock）注入到被标注的对象中去，也就是说被标注的对象中需要使用标注了mock（或@mock）的对象。
    // 把mock（或@mock）标注的对象注入到被@InjectMocks标注的对象中去

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Map<String, String> wordMap = Mockito.mock(HashMap.class);
        MyDictionary dic = new MyDictionary();
        dic.setMap(wordMap);

        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        assertEquals("aMeaning", dic.getMeaning("aWord"));
    }

}
