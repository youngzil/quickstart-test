/**
 * 项目名称：quickstart-mock 
 * 文件名：JobService.java
 * 版本信息：
 * 日期：2017年11月24日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito.java8;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * JobService
 * 
 * @author：youngzil@163.com
 * @2017年11月24日 上午11:39:27
 * @since 1.0
 */
public interface JobService {

    Optional<JobPosition> findCurrentJobPosition(Person person);

    Stream<JobPosition> listJobs(Person person);

    default boolean assignJobPosition(Person person, JobPosition jobPosition) {
        if (!findCurrentJobPosition(person).isPresent()) {
            person.setCurrentJobPosition(jobPosition);

            return true;
        } else {
            return false;
        }
    }
}
