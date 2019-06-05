/**
 * 项目名称：quickstart-jmeter 
 * 文件名：SleepTest.java
 * 版本信息：
 * 日期：2018年7月24日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.jmeter;

import java.io.Serializable;
import java.util.Iterator;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * SleepTest
 * 
 * @author：youngzil@163.com
 * @2018年7月24日 下午3:23:34
 * @since 1.0
 */
public class SleepTest extends AbstractJavaSamplerClient implements Serializable {
    /**
     * The default value of the SleepTime parameter, in milliseconds.
     */
    public static final long DEFAULT_SLEEP_TIME = 1000;

    /**
     * The default value of the SleepMask parameter.
     */
    public static final long DEFAULT_SLEEP_MASK = 0x3ff;

    /**
     * The base number of milliseconds to sleep during each sample.
     */
    private long sleepTime;

    /**
     * A mask to be applied to the current time in order to add a random component to the sleep time.
     */
    private long sleepMask;

    /**
     * Default constructor for <code>SleepTest</code>.
     * <p/>
     * The Java Sampler uses the default constructor to instantiate an instance of the client class.
     */
    public SleepTest() {
        getLogger().debug(whoAmI() + "\tConstruct");
    }

    /**
     * Do any initialization required by this client. In this case, initialization consists of getting the values of the SleepTime and SleepMask parameters. It is generally recommended to do any
     * initialization such as getting parameter values in the setupTest method rather than the runTest method in order to add as little overhead as possible to the test.
     *
     * @param context the context to run with. This provides access to initialization parameters.
     */
    public void setupTest(JavaSamplerContext context) {
        getLogger().debug(whoAmI() + "\tsetupTest()");
        listParameters(context);

        sleepTime = context.getLongParameter("SleepTime", DEFAULT_SLEEP_TIME);
        sleepMask = context.getLongParameter("SleepMask", DEFAULT_SLEEP_MASK);
    }

    /**
     * Perform a single sample. In this case, this method will simply sleep for some amount of time. Perform a single sample for each iteration. This method returns a <code>SampleResult</code> object.
     * <code>SampleResult</code> has many fields which can be used. At a minimum, the test should use <code>SampleResult.sampleStart</code> and <code>SampleResult.sampleEnd</code>to set the time that
     * the test required to execute. It is also a good idea to set the sampleLabel and the successful flag.
     *
     * @param context the context to run with. This provides access to initialization parameters.
     * @return a SampleResult giving the results of this sample.
     * @see org.apache.jmeter.samplers.SampleResult#sampleStart()
     * @see org.apache.jmeter.samplers.SampleResult#sampleEnd()
     * @see org.apache.jmeter.samplers.SampleResult#setSuccessful(boolean)
     * @see org.apache.jmeter.samplers.SampleResult#setSampleLabel(String)
     */
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult results = new SampleResult();

        try {
            // Record sample start time.
            results.sampleStart();

            // Generate a random value using the current time.
            long start = System.currentTimeMillis();
            long sleep = getSleepTime() + (start % getSleepMask());

            results.setSampleLabel("Sleep T time = " + sleep);

            // Execute the sample. In this case sleep for the
            // specified time.
            Thread.sleep(sleep);

            results.setSuccessful(true);
        } catch (InterruptedException e) {
            getLogger().warn("SleepT interrupted.");
            results.setSuccessful(true);
        } catch (Exception e) {
            getLogger().error("SleepT error during sample", e);
            results.setSuccessful(false);
        } finally {
            results.sampleEnd();
        }

        if (getLogger().isDebugEnabled()) {
            getLogger().debug(whoAmI() + "\trunTest()" + "\tT\t" + results.getTime());
            listParameters(context);
        }

        return results;
    }

    /**
     * Do any clean-up required by this test. In this case no clean-up is necessary, but some messages are logged for debugging purposes.
     *
     * @param context the context to run with. This provides access to initialization parameters.
     */
    public void teardownTest(JavaSamplerContext context) {
        getLogger().debug(whoAmI() + "\tteardownTest()");
        listParameters(context);
    }

    /**
     * Provide a list of parameters which this test supports. Any parameter names and associated values returned by this method will appear in the GUI by default so the user doesn't have to remember
     * the exact names. The user can add other parameters which are not listed here. If this method returns null then no parameters will be listed. If the value for some parameter is null then that
     * parameter will be listed in the GUI with an empty value.
     *
     * @return a specification of the parameters used by this test which should be listed in the GUI, or null if no parameters should be listed.
     */
    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("SleepTime", String.valueOf(DEFAULT_SLEEP_TIME));
        params.addArgument("SleepMask", "0x" + (Long.toHexString(DEFAULT_SLEEP_MASK)).toUpperCase());
        return params;
    }

    /**
     * Dump a list of the parameters in this context to the debug log.
     *
     * @param context the context which contains the initialization parameters.
     */
    private void listParameters(JavaSamplerContext context) {
        if (getLogger().isDebugEnabled()) {
            Iterator argsIt = context.getParameterNamesIterator();
            while (argsIt.hasNext()) {
                String name = (String) argsIt.next();
                getLogger().debug(name + "=" + context.getParameter(name));
            }
        }
    }

    /**
     * Generate a String identifier of this test for debugging purposes.
     *
     * @return a String identifier for this test instance
     */
    private String whoAmI() {
        StringBuffer sb = new StringBuffer();
        sb.append(Thread.currentThread().toString());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        return sb.toString();
    }

    /**
     * Get the value of the sleepTime field.
     *
     * @return the base number of milliseconds to sleep during each sample.
     */
    private long getSleepTime() {
        return sleepTime;
    }

    /**
     * Get the value of the sleepMask field.
     *
     * @return a mask to be applied to the current time in order to add a random component to the sleep time.
     */
    private long getSleepMask() {
        return sleepMask;
    }
}
