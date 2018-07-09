http://junit.org/


 Junit3的package是junit.framework
 Junit4是org.junit
 Junit5是org.junit.jupite
 
 Junit就是基于Hamcrest来实现


1、总结及补充：http://www.cnblogs.com/qiyexue/p/6822791.html
JUnit的一些注意事项：
	测试方法必须使用@Test修饰
	测试方法必须使用public void进行修饰，不能带参数
	一般使用单元测试会新建一个test目录存放测试代码，在生产部署的时候只需要将test目录下代码删除即可
	测试代码的包应该和被测试代码包结构保持一致
	测试单元中的每个方法必须可以独立测试，方法间不能有任何依赖
	测试类一般使用Test作为类名的后缀
	测试方法使一般用test作为方法名的前缀
测试失败说明：
	Failure：一般是由于测试结果和预期结果不一致引发的，表示测试的这个点发现了问题
	error：是由代码异常引起的，它可以产生于测试代码本身的错误，也可以是被测试代码中隐藏的bug
一些常用注解：
	@Test:将一个普通方法修饰成一个测试方法
	@Test(excepted=xx.class): xx.class表示异常类，表示测试的方法抛出此异常时，认为是正常的测试通过的
	@Test(timeout=毫秒数) :测试方法执行时间是否符合预期
	@BeforeClass： 会在所有的方法执行前被执行，static方法
	@AfterClass：会在所有的方法执行之后进行执行，static方法
	@Before：会在每一个测试方法被运行前执行一次
	@After：会在每一个测试方法运行后被执行一次
	@Ignore：所修饰的测试方法会被测试运行器忽略
	@RunWith：可以更改测试运行器org.junit.runner.Runner
	Parameters：参数化注解
	
	
	@BeforeSuite：用来设置Header      @AfterSuite发送邮件，使用公司内部的发送邮件的接口
@BeforeClass: 运行整个类之前先清除删除账号信息（有的时候创建公司前先删除公司相关内容），然后用户登录（创建符合身份的用户），审核用户登录，
@AfterClass:  清除删除账号信息，用户和审核用户关闭httpclient。
@BeforeMethod:准备用例
@AfterMethod:清除用例

忽略测试	@ignore
预期的异常	@Test(expected = ArithmeticException.class)
超时测试	@Test(timeout = 1000)

JUnit:
1、使用JUnit的最佳实践，不是强制：
 新建一个名为test的source folder，用于存放测试类源代码，目标类与测试类位于同一个包名下面，这样测试类就不必导入源代码所在的包，因为他们在同一个包下面，
2、测试类命名规则：源代码类名+Test或者Test+源代码类名
3、JUnit的口号：keep the bar green to keep the code clean
4、JUnit：单元测试不是为了证明您是对的，而是为了证明您没有错误
5、Test Case：测试用例，
单元测试主要是用来判断程序的执行结果与自己期望的结果是否一致

2、http://blog.csdn.net/u014294166/article/details/52454392
3、http://blog.csdn.net/zen99t/article/details/50561136
4、http://www.cnblogs.com/mengdd/archive/2013/03/26/2983565.html

