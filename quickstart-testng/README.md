直接在xml文件上右键并且运行xml

http://testng.org
https://github.com/cbeust/testng

文档：http://testng.org/doc/documentation-main.html

eclipse插件：https://github.com/cbeust/testng-eclipse

教程：http://www.yiibai.com/testng/

忽略测试	@Test(enbale=false)
预期的异常 @Test(expectedExceptions = ArithmeticException.class)
超时测试	@Test(timeout = 1000)


@BeforeSuite: The annotated method will be run before all tests in this suite have run. 
@AfterSuite: The annotated method will be run after all tests in this suite have run. 
@BeforeTest: The annotated method will be run before any test method belonging to the classes inside the <test> tag is run. 
@AfterTest: The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run. 
@BeforeGroups: The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked. 
@AfterGroups: The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked. 
@BeforeClass: The annotated method will be run before the first test method in the current class is invoked. 
@AfterClass: The annotated method will be run after all the test methods in the current class have been run. 
@BeforeMethod: The annotated method will be run before each test method. 
@AfterMethod: The annotated method will be run after each test method.

注解	描述
@BeforeSuite	在该套件的所有测试都运行在注释的方法之前，仅运行一次。
@AfterSuite	在该套件的所有测试都运行在注释方法之后，仅运行一次。
@BeforeClass	在调用当前类的第一个测试方法之前运行，注释方法仅运行一次。
@AfterClass	在调用当前类的第一个测试方法之后运行，注释方法仅运行一次
@BeforeTest	注释的方法将在属于<test>标签内的类的所有测试方法运行之前运行。
@AfterTest	注释的方法将在属于<test>标签内的类的所有测试方法运行之后运行。
@BeforeGroups	配置方法将在之前运行组列表。 此方法保证在调用属于这些组中的任何一个的第一个测试方法之前不久运行。
@AfterGroups	此配置方法将在之后运行组列表。该方法保证在调用属于任何这些组的最后一个测试方法之后不久运行。
@BeforeMethod	注释方法将在每个测试方法之前运行。
@AfterMethod	注释方法将在每个测试方法之后运行。
@DataProvider	标记一种方法来提供测试方法的数据。 注释方法必须返回一个Object 【】【】，其中每个Object []可以被分配给测试方法的参数列表。 要从该DataProvider接收数据的@Test方法需要使用与此注释名称相等的dataProvider名称。
@Factory	将一个方法标记为工厂，返回TestNG将被用作测试类的对象。 该方法必须返回Object []。
@Listeners	定义测试类上的侦听器。
@Parameters	描述如何将参数传递给@Test方法。
@Test	将类或方法标记为测试的一部分。


在考虑所有功能比较之后，建议使用TestNG作为Java项目的核心单元测试框架，因为TestNG在参数化测试，依赖测试和套件测试(分组概念)方面更加突出。 TestNG用于高级测试和复杂集成测试。 它的灵活性对于大型测试套件尤其有用。 此外，TestNG还涵盖了整个核心的JUnit4功能。这样说来，好像也没有理由使用JUnit了。






