/**
 * 项目名称：quickstart-mock 
 * 文件名：ArgumentMatcherWithLambdaUnitTest.java
 * 版本信息：
 * 日期：2017年11月24日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito.java8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * ArgumentMatcherWithLambdaUnitTest
 * 
 * @author：youngzil@163.com
 * @2017年11月24日 下午1:07:17
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class ArgumentMatcherWithLambdaUnitTest {

    @Mock
    private JobService jobService;

    @InjectMocks
    private UnemploymentServiceImpl unemploymentService;

    @Test
    public void whenPersonWithJob_thenIsNotEntitled() {
        Person peter = new Person("Peter");
        Person linda = new Person("Linda");

        JobPosition teacher = new JobPosition("Teacher");

        when(jobService.findCurrentJobPosition(ArgumentMatchers.argThat(p -> p.getName().equals("Peter")))).thenReturn(Optional.of(teacher));

        assertTrue(unemploymentService.personIsEntitledToUnemploymentSupport(linda));
        assertFalse(unemploymentService.personIsEntitledToUnemploymentSupport(peter));
    }
}
