/**
 * 项目名称：quickstart-mock 
 * 文件名：JobServiceUnitTest.java
 * 版本信息：
 * 日期：2017年11月24日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito.java8;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * JobServiceUnitTest
 * 
 * @author：youngzil@163.com
 * @2017年11月24日 上午11:42:46
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class JobServiceUnitTest {

    @Mock
    private JobService jobService;

    @Test
    public void givenDefaultMethod_whenCallRealMethod_thenNoExceptionIsRaised() {
        Person person = new Person();

        when(jobService.findCurrentJobPosition(person)).thenReturn(Optional.of(new JobPosition()));

        doCallRealMethod().when(jobService).assignJobPosition(Mockito.any(Person.class), Mockito.any(JobPosition.class));

        assertFalse(jobService.assignJobPosition(person, new JobPosition()));
    }
}
