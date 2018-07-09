代码覆盖率
比较流行的工具是Emma和Jacoco,Ecliplse插件有eclemma。eclemma2.0之前采用的是Emma，之后采用的是Jacoco。这里主要介绍一下Jacoco。Eclmama由于是Eclipse插件，所以非常易用，就不多做介绍了。

Jacoco

Jacoco可以嵌入到Ant、Maven中，也可以使用Java Agent技术监控任意Java程序，也可以使用Java Api来定制功能。
Jacoco会监控JVM中的调用，生成监控结果（默认保存在jacoco.exec文件中），然后分析此结果，配合源代码生成覆盖率报告。需要注意的是：监控和分析这两步，必须使用相同的Class文件，否则由于Class不同，而无法定位到具体的方法，导致覆盖率均为0%。

Java Agent嵌入

首先，需要下载jacocoagent.jar文件，然后在Java程序启动参数后面加上 -javaagent:[yourpath/]jacocoagent.jar=[option1]=[value1],[option2]=[value2]，具体的options可以在此页面找到。默认会在JVM关闭时（注意不能是kill -9），输出监控结果到jacoco.exec文件中，也可以通过socket来实时地输出监控报告（可以在Example代码中找到简单实现）。

Java Report

可以使用Ant、Mvn或Eclipse来分析jacoco.exec文件，也可以通过API来分析。


https://www.cnblogs.com/AloneSword/p/4109407.html