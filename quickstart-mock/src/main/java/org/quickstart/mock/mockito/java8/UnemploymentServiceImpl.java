/**
 * 项目名称：quickstart-mock 
 * 文件名：UnemploymentServiceImpl.java
 * 版本信息：
 * 日期：2017年11月24日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito.java8;

import java.util.Optional;

/**
 * UnemploymentServiceImpl
 * 
 * @author：youngzil@163.com
 * @2017年11月24日 下午12:03:16
 * @since 1.0
 */
public class UnemploymentServiceImpl implements UnemploymentService {

    private JobService jobService;

    public UnemploymentServiceImpl(JobService jobService) {
        this.jobService = jobService;
    }

    @Override
    public boolean personIsEntitledToUnemploymentSupport(Person person) {

        Optional<JobPosition> optional = jobService.findCurrentJobPosition(person);

        return !optional.isPresent();
    }

    @Override
    public Optional<JobPosition> searchJob(Person person, String searchString) {
        return jobService.listJobs(person).filter((j) -> j.getTitle().contains(searchString)).findFirst();
    }
}
