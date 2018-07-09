/**
 * 项目名称：quickstart-mock 
 * 文件名：DobaOrderRPC.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.powermock.mockito;

import org.apache.commons.lang3.StringUtils;

/**
 * DobaOrderRPC
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月23日 下午6:02:26
 * @since 1.0
 */
public class DobaOrderRPC {

    private static String ADD_TRACKING_URL = StringUtils.join(new String[] {System.getProperty("doba.api.url"), "orders/%s/add-tracking"});
    private static String TOKEN = System.getProperty("doba.api.token");

    public String getTrackingUrl() {

        return ADD_TRACKING_URL;

    }

    public String getToken() {

        return TOKEN;

    }

}
