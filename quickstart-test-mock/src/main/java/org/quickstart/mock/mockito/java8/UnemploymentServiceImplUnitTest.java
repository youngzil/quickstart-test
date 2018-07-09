/**
 * 项目名称：quickstart-mock 
 * 文件名：UnemploymentServiceImplUnitTest.java
 * 版本信息：
 * 日期：2017年11月24日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito.java8;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * UnemploymentServiceImplUnitTest
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月24日 下午12:58:47
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class UnemploymentServiceImplUnitTest {

    @Mock
    private JobService jobService;

    @InjectMocks
    private UnemploymentServiceImpl unemploymentService;

    @Test
    public void givenReturnIsOfTypeOptional_whenMocked_thenValueIsEmpty() {
        Person person = new Person();

        when(jobService.findCurrentJobPosition(any(Person.class))).thenReturn(Optional.empty());

        assertTrue(unemploymentService.personIsEntitledToUnemploymentSupport(person));
    }

    // 所以Mockito现在默认返回一个空的Optional。这与调用Optional.empty（）的返回值完全相同。
    // 所以，当使用Mockito版本2时，我们可以摆脱13行，我们的测试仍然会成功：
    @Test
    public void givenReturnIsOptional_whenDefaultValueIsReturned_thenValueIsEmpty() {
        Person person = new Person();

        assertTrue(unemploymentService.personIsEntitledToUnemploymentSupport(person));
    }

    @Test
    public void givenReturnIsOfTypeStream_whenMocked_thenValueIsEmpty() {
        Person person = new Person();
        when(jobService.listJobs(any(Person.class))).thenReturn(Stream.empty());

        assertFalse(unemploymentService.searchJob(person, "").isPresent());
    }

    // 当使用Mockito版本2时
    @Test
    public void givenReturnIsStream_whenDefaultValueIsReturned_thenValueIsEmpty() {
        Person person = new Person();

        assertFalse(unemploymentService.searchJob(person, "").isPresent());
    }

}
