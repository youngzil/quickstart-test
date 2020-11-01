- [Jmeter测试命令行](#Jmeter测试命令行)
- [Jmeter组件](#Jmeter组件)
- [Jmeter测试界面配置步骤](#Jmeter测试界面配置步骤)



---------------------------------------------------------------------------------------------------------------------
## Jmeter测试命令行

在bin目录下启动jmeter，配置jmx文件
sh jmeter.sh

然后再主机上执行jmx生成jtl文件
sh jmeter -n -t testplan.jmx -l test.jtl


查看jtl文件
1、界面：在界面使用"聚合报告"中导入jtl文件
2、使用命令行：sh jmeter -g 6002.jtl -e -o testpath


HTTP：
HTTPsampler
    HeaderManager：HTTP信息头管理器
    CookieManager：HTTP Cookie管理器
    ResponseAssertion：响应断言
View Results Tree：查看结果树
Summary Report：汇总报告
Aggregate Report：聚合报告


---------------------------------------------------------------------------------------------------------------------

## Jmeter组件
https://jmeter.apache.org/usermanual/component_reference.html

Samplers取样器：HTTP Request、Java Request、JDBC Request、JSR223 Sampler、TCP Sampler
Listeners监听器：查看结果树（View Results Tree）、聚合报告（Aggregate Report）、汇总报告（Summary Report）
                       
Pre Processors前置处理器：JSR223 PreProcessor、JDBC PreProcessor
Post-Processors后置处理器：JSR223 PreProcessor、JDBC PreProcessor
Assertions断言

Logic Controllers逻辑控制器
Timers定时器
Miscellaneous Features其他功能测试片段
Configuration Elements配置元件



JSR223（规范）是用于Java虚拟机（JVM）语言的标准脚本API 。JVM语言为JSR223 API提供了不同级别的支持以及与Java运行时的互操作性。当前，已知以下语言可以很好地用于openHAB脚本： Jython（JVM上的Python）， Nashorn Javascript（JDK8至10中包括的ECMAScript实现，于11中弃用）和 Apache Groovy（JVM脚本语言）。

https://jcp.org/aboutJava/communityprocess/pr/jsr223/index.html



---------------------------------------------------------------------------------------------------------------------

## Jmeter测试界面配置步骤


1、在bin目录下sh jmeter.sh
2、启动之后会有两个窗口，一个命令行控制台窗口，一个JMeter的 GUI
    命令行控制台窗口意思就是：不要使用GUI运行压力测试，GUI仅用于压力测试的创建和调试；执行压力测试请不要使用GUI。使用下面的命令来执行测试：
    jmeter -n -t [jmx file] -l [results file] -e -o [Path to web report folder]
3、创建线程组：
    在“测试计划”上右键 【添加】-->【Threads(Users)】-->【线程组】
4、创建Http请求
  在“线程组”右键 【添加-】->【samlper】-->【HTTP 请求】
5、添加察看结果树和聚合报告
  在我们刚刚创建的线程组上右键 【添加】-->【监听器】-->【察看结果树】。添加聚合报告，右键 【添加】-->【监听器】-->【聚合报告】。

6、然后点击运行按钮就可以看到结果了。

7、使用命令行运行：
    查看命令行参数：sh jmeter.sh  -h
   
   To run Apache JMeter in NON_GUI mode and generate a report at end :
   jmeter.sh -n -t test-file [-p property-file] [-l results-file] [-j log-file] -e -o [Path to output folder]
   
   To generate a Report from existing CSV file:
   jmeter.sh -g [csv results file] -o [path to output folder (empty or not existing)]
   
   To tell Apache JMeter to use a proxy server:
   jmeter.sh -H [your.proxy.server] -P [your proxy server port]
   

示例： jmeter -n -t testplan.jmx -l test.jtl

在 Linux 下执行 JMeter 压力测试，生成 jtl 的 文件，导入 GUI 模式下的 JMeter 后，没有请求信息和响应信息。

为了察看和验证返回信息，需要做如下配置：
在 bin目录下的 user.properties 文件中追加以下内容：

jmeter.save.saveservice.output_format=xml
jmeter.save.saveservice.response_data=true
jmeter.save.saveservice.samplerData=true
jmeter.save.saveservice.requestHeaders=true
jmeter.save.saveservice.url=true
jmeter.save.saveservice.responseHeaders=true


建议
建议在调试或者基准测试时使用以上配置信息，但是真正的压测过程中，注释掉上述新增的内容。
因为 JMeter 在压测工程中，如果开启配置参数，它会边压测，边将请求和响应数据写入 jtl 文件，无形之中加重了 JMeter 的负担，影响压力源的性能，进而影响测试结果。



参考
https://my.oschina.net/u/2391658/blog/3013235
https://blog.51cto.com/xqtesting/2347422
https://blog.csdn.net/weiyi556/article/details/85039119



---------------------------------------------------------------------------------------------------------------------









