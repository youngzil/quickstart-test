[项目地址](https://github.com/youngzil/quickstart-test)


- [测试的分类](#测试的分类)
- [基准测试和压力测试](#基准测试和压力测试)
- [JMH微基准测试](quickstart-jmh/README.md)
- [测试桩介绍](docs/测试桩介绍.md)
    - [Mock框架](quickstart-mock/README.md)
- [性能测试压力测试总结](docs/性能测试压力测试总结.md)
    - [JMeter测试](docs/JMeter/JMeter测试.md)
    - [LoadRunner介绍](docs/LoadRunner介绍.md)
- [单元测试]()
    - [AssertJ学习](docs/JUnit/AssertJ学习.md)
    - [Hamcrest](docs/JUnit/Hamcrest.md)
    - [Junit4学习](docs/JUnit/Junit4学习.md)
    - [Junit5学习](docs/JUnit/Junit5学习.md)
    - [TestNG学习](quickstart-testng/README.md)
- [Arquillian学习](docs/Arquillian/Arquillian学习.md)
- [AB测试](docs/AB测试.md)
- [Sharness测试框架](docs/Sharness测试框架.md)


---------------------------------------------------------------------------------------------------------------------
## 测试的分类

测试分类
- （1）按测试方式分类：静态测试、动态测试
- （2）按测试方法分类：白盒测试、黑盒测试
- （3）按测试自动化程度分类：人工测试、自动化测试
- （4）按测试阶段分类：单元测试、集成测试、确认测试、系统测试、验收测试、
- （5）按测试类型分类：功能测试、界面测试、性能测试（负载测试、强度测试）、容量测试、压力测试、安全测试、兼容性测试、安装测试、文档测试、易用性测试、边界测试、健壮性测试、本地化测试、无障碍测试、回归测试、冒烟测试、Monkey测试、A/B测试
- （6）按测试模式分类：瀑布模型、敏捷测试、基于脚本的测试、基于风险的测试、探索式测试




参考  
[软件测试](https://blog.csdn.net/dreamchasering/category_6966670.html)  
[软件测试类型](https://blog.csdn.net/dreamchasering/article/details/71154875)


---------------------------------------------------------------------------------------------------------------------

## 基准测试和压力测试


BMT（Benchmark Test）：感觉一般是用来做对比测试用的
基准测试是指通过设计科学的测试方法、测试工具和测试系统，实现对一类测试对象的某项性能指标进行定量的和可对比的测试。



performance testing
性能测试是通过自动化的测试工具模拟多种正常、峰值以及异常负载条件来对系统的各项性能指标进行测试。负载测试和压力测试都属于性能测试，两者可以结合进行。通过负载测试，确定在各种工作负载下系统的性能，目标是测试当负载逐渐增加时，系统各项性能指标的变化情况。压力测试是通过确定一个系统的瓶颈或者不能接受的性能点，来获得系统能提供的最大服务级别的测试。

---------------------------------------------------------------------------------------------------------------------

[JaCoCo Github](https://github.com/jacoco/jacoco)  
[JaCoCo官网](https://www.jacoco.org/jacoco/)

Java Code Coverage Library  
Java代码覆盖率库

JaCoCo is a free code coverage library for Java  
JaCoCo是Java的免费代码覆盖库




开源自动化测试解决方案 AutoLine
https://www.oschina.net/p/autoline?from=20180520
https://gitee.com/lym51/AutoLine


Googletest - Google Testing and Mocking Framework
https://github.com/google/googletest


自动化测试平台 LuckyFrameWeb
官网：www.luckyframe.cn



敏捷测试管理软件 itest(爱测试)
https://www.oschina.net/p/itest-cn


单元测试
https://developer.aliyun.com/article/770589




