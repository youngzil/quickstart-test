Arquillian简介
Arquillian是一个基于JUnit，由JBoss开发的新型测试框架，其主要目的是简化Java项目集成测试和功能测试的编写，让它们能像单元测试一样简单。Arquillian能真正在Web容器中运行测试，它主要通过三种方式与容器进行交互：
1. 嵌入式(embedded)。Arquillian和Web容器在同一个JVM中运行。
2. 受管理的(managed)。由Arquillian决定何时启动、关闭Web容器以便向容器中部署、运行测试。
3. 远程的(remote)。开发者事先启动Web容器，Arquillian连接该容器并将测试部署到容器中运行。


Arquillian 可让你在远程或者嵌入式的容器里测试业务逻辑，同时可作为一个压缩包发布到容器中，并通过客户端来进行交互测试。Arquillian 是一个可以方便的在现有类基础性扩展测试用例，基于 JUnit 。 [1] 



[Arquillian文档](http://arquillian.org/docs/)  
[Arquillian中文文档](http://arquillian.org/guides/getting_started_zh_cn/)  
[Arquillian高级使用文档](http://arquillian.org/guides/getting_started_rinse_and_repeat_zh_cn/)  
[Arquillian测试框架快速上手教程 （一） - 环境搭建、容器适配、单元测试](https://blog.csdn.net/neosmith/article/details/19754703)  



