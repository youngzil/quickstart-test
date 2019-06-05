/**
 * 项目名称：quickstart-mock 
 * 文件名：MockitoWithAnnotationTest.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * MockitoWithAnnotationTest http://www.baeldung.com/mockito-annotations https://github.com/eugenp/tutorials/tree/master/testing-modules/mockito http://www.baeldung.com/category/mockito/
 * 
 * @author：youngzil@163.com
 * @2017年11月23日 下午3:33:55
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoWithAnnotationTest {

    // 不使用注解请看MockitoNoAnnotationTest

    // @Mock, @Spy, @Captor, and @InjectMocks.

    // 使用@RunWith(MockitoJUnitRunner.class) 或者 MockitoAnnotations.initMocks(this);
    /*@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/

    // 开启注解另外一种方法，这个方法会调用validateMockitoUsage方法。这个方法有一些好处，具体什么好处还不太清楚。
    // @Rule
    // public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    List<String> mockedList;

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

    // 使用真正的方法spiedList.add（）将元素添加到spiedList。
    // 存根方法spiedList.size（）返回100，而不是2使用Mockito.doReturn（） 。

    @Spy
    List<String> spiedList = new ArrayList<String>();

    @Test
    public void whenUseSpyAnnotation_thenSpyIsInjected() {
        spiedList.add("one");
        spiedList.add("two");

        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");

        assertEquals(2, spiedList.size());

        Mockito.doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }

    @Mock
    List mockedArgCaptorList;

    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void whenUseCaptorAnnotation_thenTheSam() {
        mockedArgCaptorList.add("one");
        Mockito.verify(mockedArgCaptorList).add(argCaptor.capture());

        assertEquals("one", argCaptor.getValue());
    }

    // @InjectMocks注解 - 将模拟域自动注入到被测对象中。
    // @InjectMocks将本test类中的mock（或@mock）注入到被标注的对象中去，也就是说被标注的对象中需要使用标注了mock（或@mock）的对象。
    // 把mock（或@mock）标注的对象注入到被@InjectMocks标注的对象中去

    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    MyDictionary dic = new MyDictionary();

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        assertEquals("aMeaning", dic.getMeaning("aWord"));
    }

}
