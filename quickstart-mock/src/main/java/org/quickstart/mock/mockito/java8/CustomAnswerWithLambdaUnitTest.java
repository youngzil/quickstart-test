/**
 * 项目名称：quickstart-mock 
 * 文件名：ArgumentMatcherWithLambdaUnitTest.java
 * 版本信息：
 * 日期：2017年11月24日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito.java8;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * ArgumentMatcherWithLambdaUnitTest
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月24日 下午1:07:17
 * @since 1.0
 */
public class CustomAnswerWithLambdaUnitTest {

    @Mock
    private JobService jobService;

    @InjectMocks
    private UnemploymentServiceImpl unemploymentService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        when(jobService.listJobs(any(Person.class))).then((i) -> Stream.of(new JobPosition("Teacher")).filter(p -> ((Person) i.getArgument(0)).getName().equals("Peter")));
    }
}
