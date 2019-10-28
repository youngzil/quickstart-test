https://github.com/powermock/powermock
https://github.com/powermock/powermock-examples-maven
https://github.com/powermock/powermock.github.io

PowerMock
这个工具是在EasyMock和Mockito上扩展出来的，目的是为了解决EasyMock和Mockito不能解决的问题，比如对static, final, private方法均不能mock。其实测试架构设计良好的代码，一般并不需要这些功能，但如果是在已有项目上增加单元测试，老代码有问题且不能改时，就不得不使用这些功能了。

PowerMock 在扩展功能时完全采用和被扩展的框架相同的 API, 熟悉 PowerMock 所支持的模拟框架的开发者会发现 PowerMock 非常容易上手。PowerMock 的目的就是在当前已经被大家所熟悉的接口上通过添加极少的方法和注释来实现额外的功能。目前PowerMock 仅扩展了 EasyMock 和 mockito，需要和EasyMock或Mockito配合一起使用。

PowerMock可以在https://code.google.com/p/powermock/上下载，本文以PowerMock+mockito为例,使用maven的话，添加如下依赖即可，maven会自动引入mockito的包。



与Spring整合进行单元测试
    我们的项目大多整合了Spring框架，那么如何在Spring环境下进行单元测试呢？

    当我们单元测试Dao层，进行数据库层面的单元测试，如何进行事务控制，让单元测试结束自动回滚测试数据？

    下面用一个Spring-test示例来解答：

@DirtiesContext  
@ContextConfiguration(locations = {"/applicationContext-dal-cb-test.xml"})  
public class ComBuyerMapperTest extends AbstractTransactionalJUnit4SpringContextTests {  
  
    @Autowired  
    private ComBuyerMapper comBuyerMapper;  
  
    @Before  
    public void setUP() {  
        MockitoAnnotations.initMocks(this);  
    }  
  
    @Test  
    public void findComUserById(){  
        Long comId = CbAppContextHolder.getAppContext().getCurrentLogonCbCompany().getCbComId();  
        ComBuyer comBuyer = insertComUser();  
        Long comBuyerId = comBuyer.getComBuyerId();  
          
        comBuyer = comBuyerMapper.findComUserById(comId, comBuyerId);  
        Assertions.assertThat(comBuyer).isNotNull();  
    }  
  
    private ComBuyer insertComUser(){  
        Long comId = CbAppContextHolder.getAppContext().getCurrentLogonCbCompany().getCbComId();  
  
        ComBuyer comBuyer = new ComBuyer();  
        comBuyer.setComId(comId);  
        comBuyer.setBuyerId(0L);  
        comBuyer.setBuyerNameEn("buyer name");  
        comBuyer.setStatus(Integer.valueOf(BuyerCreditStatus.VALID.getKey()));  
        comBuyer.setDeleteFlag(Short.valueOf(DeleteFlagConstants.NOT_DELETE.getKey()));  
        comBuyer.setCountry("China");  
        comBuyer.setAddress("beijing");  
        comBuyer.setContactName("laoli");  
        comBuyer.setAddInfo();  
        comBuyer.setUpdateInfo();  
        comBuyerMapper.insertComUser(comBuyer);  
  
        return comBuyer;  
    }  
}  
1、@ContextConfiguration(locations = {"/applicationContext-dal-cb-test.xml"})

     构建Spring环境，比如数据源、持久层框架等配置。

2、@DirtiesContext

     声明该注解后，在每次单元测试结束清理Spring环境，防止单元测试环境有缓存数据。

3、AbstractTransactionalJUnit4SpringContextTests

     JUnit Case继承该父类，单元测试用例将运行在事务中。出现异常或运行结束，用例中的写操作都将回滚，不会对数据库中数据产生影响。


