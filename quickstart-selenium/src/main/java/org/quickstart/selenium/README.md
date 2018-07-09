Selenium （浏览器自动化测试框架） 
Selenium[1]  是一个用于Web应用程序测试的工具。Selenium测试直接运行在浏览器中，就像真正的用户在操作一样。支持的浏览器包括IE（7, 8, 9, 10, 11），Mozilla Firefox，Safari，Google Chrome，Opera等。这个工具的主要功能包括：测试与浏览器的兼容性——测试你的应用程序看是否能够很好得工作在不同浏览器和操作系统之上。测试系统功能——创建回归测试检验软件功能和用户需求。支持自动录制动作和自动生成 .Net、Java、Perl等不同语言的测试脚本。


https://github.com/SeleniumHQ/selenium
https://github.com/SeleniumHQ/htmlunit-driver
https://github.com/SeleniumHQ/www.seleniumhq.org
https://github.com/SeleniumHQ/docker-selenium

Selenium支持的浏览器包括：firefox、chrome、edge、ie、opera、safari

1、mozilla firefox火狐:
什么是Gecko和Gecko Driver
Gecko是由Mocilla开发的许多应用程序中的Web浏览器引擎。
Gecko则是一种介于你的Selenium的测试代码与Firfox浏览器之间的链接，是使用W3C 
WebDriver兼容客户端的一种代理与Gecko核心浏览器交互。
火狐浏览器用可执行程序GeckoDriver.exe的方式执行WebDriver协议。所有的测试脚本都通过GeckoDriver来执行。

https://github.com/mozilla/geckodriver
https://github.com/mozilla/geckodriver/releases

代码：
System.setProperty("webdriver.gecko.driver", "/Users/yangzl/mysoft/selenium/geckodriver");
// 定义驱动对象为 FirefoxDriver 对象
WebDriver driver2 = new FirefoxDriver();


2、Chrome浏览器:
要下载一个ChromeDriver,下载地址：https://sites.google.com/a/chromium.org/chromedriver/
https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver
http://chromedriver.storage.googleapis.com/index.html

代码：
System.setProperty("webdriver.chrome.driver", "/Users/yangzl/mysoft/selenium/chromedriver");
WebDriver driver = new ChromeDriver();

3、safari浏览器：

代码：
//本机测试，不设置驱动参数也可以
//System.setProperty("webdriver.safari.driver", "/Users/extrabux/library/safari/extensions");
SafariDriver driver = new SafariDriver();

4、edge浏览器：

https://github.com/SeleniumHQ/selenium/wiki/MicrosoftWebDriver
http://go.microsoft.com/fwlink/?LinkId=619687

代码：
System.setProperty("webdriver.edge.driver", "/Users/yangzl/mysoft/selenium/MicrosoftWebDriver.exe");
EdgeDriver driver = new EdgeDriver();


5、ie浏览器：

https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver
http://selenium-release.storage.googleapis.com/index.html

代码：
System.setProperty("webdriver.ie.driver", "/Users/yangzl/mysoft/selenium/IEDriverServer.exe");
InternetExplorerDriver driver = new InternetExplorerDriver();

6、opera浏览器：

https://github.com/operasoftware/operachromiumdriver
https://github.com/operasoftware/operachromiumdriver/releases

代码：















