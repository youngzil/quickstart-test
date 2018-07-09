/**
 * 项目名称：quickstart-testng 
 * 文件名：RandomEmailGenerator.java
 * 版本信息：
 * 日期：2017年11月21日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.testng.spring;

import org.springframework.stereotype.Service;

/**
 * RandomEmailGenerator
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月21日 下午12:03:36
 * @since 1.0
 */
@Service
public class RandomEmailGenerator implements EmailGenerator {

    public String generate() {
        return "feedback@yiibai.com";
    }

}
