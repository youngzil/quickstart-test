/**
 * 项目名称：quickstart-mock 
 * 文件名：UnemploymentService.java
 * 版本信息：
 * 日期：2017年11月24日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito.java8;

import java.util.Optional;

/**
 * UnemploymentService
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月24日 下午12:03:02
 * @since 1.0
 */
public interface UnemploymentService {

    public boolean personIsEntitledToUnemploymentSupport(Person person);

    public Optional<JobPosition> searchJob(Person person, String searchString);

}
