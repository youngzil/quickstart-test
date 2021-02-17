[testable-mock Github](https://github.com/alibaba/testable-mock)  
[testable-mock文档](https://alibaba.github.io/testable-mock/#/)  


TestableMock是基于源码和字节码增强的Java单元测试辅助工具，包含以下功能：
- 快速Mock任意调用：使被测类的任意方法调用快速替换为Mock方法，实现"指哪换哪"，解决传统Mock工具使用繁琐的问题
- 访问被测类私有成员：使单元测试能直接调用和访问被测类的私有成员，解决私有成员初始化和私有方法测试的问题
- 辅助测试void方法：利用Mock校验器对方法的内部逻辑进行检查，解决无返回值方法难以实施单元测试的问题
- 快速构造参数对象：生成任意多层嵌套的对象实例，并简化其内部成员赋值方式，解决被测方法参数初始化代码冗长的问题
