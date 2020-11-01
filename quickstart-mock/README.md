Stub是完全模拟一个外部依赖， 而Mock用来判断测试通过还是失败

用mock编写的测试通常遵循一个initialize -> set expectations -> exercise -> verify模式来测试。而Stub将遵循initialize -> exercise -> verify。

什么是stub呢,CodeSchool给出这样的定义:
Stub: For replacing a method with code that returns a specified result
简单说就是你可以用stub去伪造(fake)一个方法,阻断对原来方法的调用

mock, CodeSchool上给的定义是这样的:
Mock:	A stub with an expectations that the method gets called.
简单来说mock就是stub + expectation, 说它是stub是因为它也可以像stub一样伪造方法,阻断对原来方法的调用, expectation是说它不仅伪造了这个方法,它还期望你(必须)调用这个方法,如果没有被调用到,这个test就fail了

这里注意一下顺序,一般的测试先是执行一个动作,然后再去判断状态或其它东西,像前面stub的例子,先调用decapitate方法,再去判断status的变化,就好像我踢你一脚,看你会不会喊疼,而这里是先有期望再有动作,这就好比老板对你说这个下周前完成,不然就滚蛋一样

在mock社区看来，最本质的区别就在于mock所具有的expectation setting机制，利用此机制可以测试mock上哪些方法被调用了。Mockists通常把一个刚刚返回值的mock object叫做’just a stub’。所以，一种观察mocks和stubs的区别的方法就是在使用mock的时候人们是把建立并且测试expectations当作测试的一部分的。似乎太简单了点 - 我也曾经编写过做一些简单形式expectation检查的stub（这些检查可能是设置一个布尔值来代表某个method是否被调用）。但是我想我们有理由认为expectations对于stubs来说是一种稀有的特性，而对于mocks来说是主要的特性。

1. Mocks
(1) mock 是藉由提供一連串想要的函式呼叫和對應的傳回值, 來建立所想要測試的流程.
(2) 所以你可以把mock 想像成是戲劇中的演員, 他必須要依據劇本來演出. 劇本內會描述一些預期所要演出的劇情是什麼, 也就是演員必須說出劇本內所描述的句子

2. Stubs
(1) 和mock不同, 沒有"test script"的概念.
(2) 你只需要設定固定的答案給被呼叫的函式
(3) 不需要設定任何的預期行為

对Stub和Mock的认识
Stub和Mock都是属于测试替身，对类型细分的话可以分为：
Dummy Object
Fake Object
Test Stub
Test Spy
Mock Object
前四项属于Stub，最后的Mock Object属于Mock。
类型分析
Dummy Object（哑对象）
测试代码仅仅是需要使用它来通过编译，实际上用不到它。如测试A类的run方法，需要在创建A类的实例时需要传入B类实例，但run方法并没有用到B类实例。在测试时需要传入B类的哑对象new NullB()（如“new A(new NullB())”），让其通过编译。这里的NullB是一个空类，没有具体实现。

Fake Object（假对象）
假对象相对于哑对象来说，要对耦合的组件有一些简单的实现，实现我们在测试中要用到的方法，指定期望的行为（如返回期望的值）。假对象适用于替换产品代码中使用的全局对象，或者创建的类。这里注意的是要先对被替换的全局对象或类进行备份，然后在测试完成后进行恢复。

Test Stub（测试桩）
测试桩与假对象有点类似，也要实现与产品代码耦合的组件，指定期望的行为。这里最大的不同是测试桩需要注入到产品代码中，从而在测试产品代码时替换组件，执行桩的行为。使用测试桩不需要进行备份和还原。

Test Spy（嗅探桩）
与测试桩类似，但是可以记录桩使用的记录，并进行验证。

Mock Object（模拟对象）
设定产品代码中耦合的类的期望的行为，然后验证期望的行为是否发生，从而达到测试产品代码行为的目的。适用于验证一些void的行为。例如：在某个条件发生时，要记录Log。这种情景，用stub就很难验证，因为对目标物件来说，沒有回传值，也沒有状态变化，就只能通过mock object來验证目标物件是否正确的与Log介面进行互动。

Mock（Mock Object）与Spy（Test Spy）的比较
相同点
都要注入到产品代码中。
不同的
Mock是替换整个被Mock的类，这个类可以存在也可以不存在。而Spy是使用一个已经存在的类，嗅探其中的部分方法。
从流程中来说，Mock是先设定被Mock的类的期望行为，然后验证期望的行为是否发生。Spy是记录下桩的方法的使用记录（如传入的参数，调用的次数等），然后再对记录进行验证。

Mock退化为Stub
在现实使用中，我们经常将mock做不同程度的退化，从而使得mock对象在某些程度上如stub一样工作。

总结
在比较简单的情况下（如需要哑对象来通过编译，或是需要测试桩来替换耦合的组件），使用Stub。
如果需要验证耦合组件的行为，可以使用Spy或Mock。





