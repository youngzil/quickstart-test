JUnit4通过注解
@BeforeClass 全局只会执行一次，而且是第一个运行
@Before 在测试方法运行之前运行
@Test 测试方法
@After 在测试方法运行之后允许
@AfterClass 全局只会执行一次，而且是最后一个运行
@Ignore 忽略此方法

执行次序是@BeforeClass -> @Before -> @Test -> @After -> @Before -> @Test -> @After -> @AfterClass。@Ignore会被忽略。

