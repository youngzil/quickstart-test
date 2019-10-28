/**
 * 项目名称：quickstart-mock 
 * 文件名：MockitoAnnotationTest.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * MockitoAnnotationTest
 * 
 * @author：youngzil@163.com
 * @2017年11月23日 上午11:29:36
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoAnnotationTest {

    // 1、@Mock注解，@Mock注解，我们用来初始化Mock对象。代替我们在不使用注解的场景中使用的Mockito.mock(xxx.class)方法。

    @Mock(name = "listMock", answer = Answers.RETURNS_DEFAULTS)
    List<Integer> list;

    @Mock
    List<?> listTwo;

    @Mock
    final Map<Integer, String> map = new HashMap<Integer, String>();

    // 一定要有initMocks操作，否则mock的都是null，MockitoAnnotations.initMocks，初始化我们的Mock注解。
    // 除了上述的初始化的方法外，还可以使用Mockito提供的Junit Runner：MockitoJUnitRunner这样就省略了上面的步骤。
    // @RunWith(MockitoJUnitRunner.class)
    // public class ExampleTest {
    // ...
    // }
    // @Before
    // public void setup() {
    // MockitoAnnotations.initMocks(this);
    // }

    // 开启注解另外一种方法，这个方法会调用validateMockitoUsage方法。这个方法有一些好处，具体什么好处还不太清楚。
    // @Rule
    // public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void testMock() {

        // 使用mock的对象
        list.add(1);
        list.clear();
        map.clear();
        listTwo.clear();

        // 验证add(1)和clear()行为是否发生
        verify(list).add(1);
        verify(list).clear();
        verify(map).clear();
        verify(listTwo).clear();
    }

    // 2、@Spy注解，@Spy（监视真实的对象）
    // 监视一个对象需要调用spy(T object)方法，如：List spy = spy(new LinkedList());那么spy变量就在监视LinkedList实例。

    // 类的部分mock（partial mock）？
    // A：部分mock是说一个类的方法有些是实际调用，有些是使用mockito的stubbing（桩实现）。

    @Spy
    final List<String> spiedList = new ArrayList<String>();

    @Spy
    List spy = new LinkedList();

    @Test
    public void testSpy() {

        // doReturn("foo").when(spiedList).get(10);
        // assertEquals("foo", spiedList.get(10));
        // assertTrue(spiedList.isEmpty());

        /*List list = new LinkedList();
        List spy = spy(list);*/

        // optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

        // using the spy calls real methods
        spy.add("one");
        spy.add("two");

        // prints "one" - the first element of a list
        System.out.println(spy.get(0));

        // size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        // optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");

        /* // Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
         // 用thenReturn 会走go()方法体，然后将返回值Mock掉  
        when(spy.get(0)).thenReturn("foo");
        // You have to use doReturn() for stubbing
         // 用doReturn 不走go()方法体  
        doReturn("foo").when(spy).get(0);*/

    }

    // 3、@InjectMocks（mock对象自动注入），Mockito通过此注解会自动注入mocks 对象到我们注解的变量中。如果注入失败，不会通知我们，所以我们需要自己对失败的对象做处理。
    // @InjectMocks该注解标注的对象会自动注入@Mock标注创建的Mock，省去了手工set依赖的过程，非常好用。
    // @InjectMocks注解 - 将模拟域自动注入到被测对象中。
    /*不使用注解：
    public class NotifyServiceTest {    
        private NotifyService notifyService;    
        private UserCenter uc;    
        private MessageCenter mc;    
        
        @Before    
        public void setUp() {    
            notifyService = new NotifyService();    
            uc = mock(UserCenter.class);    
            mc = mock(MessageCenter.class);    
            notifyService.setUc(uc);    
            notifyService.setMc(mc);    
        }    
        
        @Test    
        public void testSendMessage() {    
            long userId = 1L;    
            String email = "foo@bar";    
            when(uc.getUser(userId)).thenReturn(createUserWithEmail(email));    
            notifyService.sendMessage(userId, "hello");    
            verify(mc).sendEmail(eq(email), eq("hello"));    
        }    
        
        private User createUserWithEmail(String email) {    
            User user = new User();    
            user.setEmail(email);    
            return user;    
        }    
        
    }    */

    /*使用注解：
    @RunWith(MockitoJUnitRunner.class)  
    public class NotifyServiceTest {    
        @InjectMocks  
        private NotifyService notifyService = new NotifyService();  
        @Mock  
        private UserCenter uc;    
        @Mock  
        private MessageCenter mc;    
        
        @Test    
        public void testSendMessage() {    
            long userId = 1L;    
            String email = "foo@bar";    
            when(uc.getUser(userId)).thenReturn(createUserWithEmail(email));    
            notifyService.sendMessage(userId, "hello");    
            verify(mc).sendEmail(eq(email), eq("hello"));    
        }    
        
        private User createUserWithEmail(String email) {    
            User user = new User();    
            user.setEmail(email);    
            return user;    
        }    
        
    }    */

    // 4、@Captor（参数捕获器，@Captor是参数捕获器的注解，有关用法见前章，通过注解的方式也可以更便捷的对它进行定义。

    @Mock
    List mockedList;

    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void testCaptor() {

        mockedList.add("one");
        Mockito.verify(mockedList).add(argCaptor.capture());

        assertEquals("one", argCaptor.getValue());

    }

}
