
http://jmockit.org
https://github.com/jmockit/jmockit1
https://github.com/jmockit/jmockit2
https://github.com/jmockit/jmockit.github.io


JMockit 是一个轻量级的mock框架是用以帮助开发人员编写测试程序的一组工具和API，该项目完全基于 Java 5 SE 的 java.lang.instrument 包开发，内部使用 ASM 库来修改Java的Bytecode。

Jmockit功能和PowerMock类似，某些功能甚至更为强大，但个人感觉其代码的可读性并不强。

Jmockit可以在https://code.google.com/p/jmockit/上下载，使用maven的话添加如下依赖即可：

Jmockit也可以分类为非局部模拟与局部模拟，区分在于Expectations块是否有参数，有参数的是局部模拟，反之是非局部模拟。而Expectations块一般由Expectations类和NonStrictExpectations类定义。用Expectations类定义的，则mock对象在运行时只能按照 Expectations块中定义的顺序依次调用方法，不能多调用也不能少调用，所以可以省略掉Verifications块；而用NonStrictExpectations类定义的，则没有这些限制，所以如果需要验证，则要添加Verifications块。

