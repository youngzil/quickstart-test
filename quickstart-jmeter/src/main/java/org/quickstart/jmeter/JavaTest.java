/**
 * 项目名称：quickstart-jmeter 
 * 文件名：JavaTest.java
 * 版本信息：
 * 日期：2018年7月24日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.jmeter;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * JavaTest
 * 
 * @author：youngzil@163.com
 * @2018年7月24日 下午3:58:57
 * @since 1.0
 */
public class JavaTest extends AbstractJavaSamplerClient {
    private MathTest test = null;
    private String a;
    private String b;
    private String resultData;
    private static long start = 0;
    private static long end = 0;

    // 这个方法是用来自定义java方法入参的。
    // params.addArgument("num1","");表示入参名字叫num1，默认值为空。
    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("num1", "");
        params.addArgument("num2", "");
        return params;
    }

    // 每个线程测试前执行一次，做一些初始化工作；
    public void setupTest(JavaSamplerContext arg0) {
        test = new MathTest();
        a = arg0.getParameter("num1");
        b = arg0.getParameter("num2");
        start = System.currentTimeMillis();
    }

    // 开始测试，从arg0参数可以获得参数值；
    public SampleResult runTest(JavaSamplerContext arg0) {
        SampleResult sr = new SampleResult();
        sr.setSamplerData("请求参数num1：" + a + "\n请求参数num2：" + b);

        try {
            sr.sampleStart();// jmeter 开始统计响应时间标记
            // 通过下面的操作就可以将被测方法的响应输出到Jmeter的察看结果树中的响应数据里面了。
            resultData = String.valueOf(test.sum(Integer.parseInt(a), Integer.parseInt(b)));
            if (resultData != null && resultData.length() > 0) {
                sr.setResponseData("结果是：" + resultData, null);
                sr.setDataType(SampleResult.TEXT);
            }
            System.out.println(resultData);
            sr.setSuccessful(true);
        } catch (Throwable e) {
            sr.setSuccessful(false);
            e.printStackTrace();
        } finally {
            sr.sampleEnd();// jmeter 结束统计响应时间标记
        }
        return sr;
    }

    // 测试结束时调用；
    public void teardownTest(JavaSamplerContext arg0) {
        end = System.currentTimeMillis();
        // 总体耗时
        System.err.println("cost time:" + (end - start) + "毫秒");
    }

    public static void main(String[] args) {
        Arguments params = new Arguments();
        params.addArgument("num1", "1");// 设置参数，并赋予默认值1
        params.addArgument("num2", "2");// 设置参数，并赋予默认值2
        JavaSamplerContext arg0 = new JavaSamplerContext(params);
        JavaTest test = new JavaTest();
        test.setupTest(arg0);
        test.runTest(arg0);
        test.teardownTest(arg0);
    }

}
