[JMeter官网](https://jmeter.apache.org/)  
[JMeter Github](https://github.com/apache/jmeter)  
[JMeter SVN地址](https://svn.apache.org/repos/asf/jmeter/trunk/)  
[JMeter构建](https://jmeter.apache.org/building.html)  

[JMeter插件](https://jmeter-plugins.org/?search=jpgc-json)  




public Arguments getDefaultParameters();设置可用参数及的默认值；
public void setupTest(JavaSamplerContext arg0)：每个线程测试前执行一次，做一些初始化工作；
public SampleResult runTest(JavaSamplerContext arg0)：开始测试，从arg0参数可以获得参数值；
public void teardownTest(JavaSamplerContext arg0)：测试结束时调用；


选中性能测试的project 右击，然后在下拉框中选择run as -》maven build ，然后在弹出的对话框的Goals 写上verify，最后点击run。 
进行打包生成jar了。拷贝到jmeter的lib/ext目录，打开jmeter，选择java请求后，在类名称处，就可以选择我们自己写的SleepTest了。


https://blog.csdn.net/luozhuwang/article/details/51882063
https://blog.csdn.net/wanglin_lin/article/details/77963931
https://blog.csdn.net/songer_xing/article/details/53747784?locationNum=2&fps=1
最近在做接口自动化测试，之前一直在postman、soupui、jmeter之间选型

