/**
 * 项目名称：quickstart-junit 
 * 文件名：AssertJTest.java
 * 版本信息：
 * 日期：2018年3月28日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.junit.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * AssertJTest
 * 
 * @author：yangzl@asiainfo.com
 * @2018年3月28日 下午4:52:33
 * @since 1.0
 */
public class AssertJTest {

    /*
     One static import to rule them all ...
    import static org.assertj.core.api.Assertions.*;
    ... or many if you prefer
    import static org.assertj.core.api.Assertions.assertThat;  // main one
    import static org.assertj.core.api.Assertions.atIndex; // for List assertions
    import static org.assertj.core.api.Assertions.entry;  // for Map assertions
    import static org.assertj.core.api.Assertions.tuple; // when extracting several properties at once
    import static org.assertj.core.api.Assertions.fail; // use when writing exception tests
    import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown; // idem
    import static org.assertj.core.api.Assertions.filter; // for Iterable/Array assertions
    import static org.assertj.core.api.Assertions.offset; // for floating number assertions
    import static org.assertj.core.api.Assertions.anyOf; // use with Condition
    import static org.assertj.core.api.Assertions.contentOf; // use with File assertions
     */

    @Test
    public void testAssertJ() {

        A a1 = new A();
        A a2 = new A();

        a1.str = "hello";
        a2.str = "hello";

        a1.list.add("world");
        a2.list.add("world");

        B b1 = new B();
        B b2 = new B();

        b1.test = "b1";
        b2.test = "b1";

        b1.aB.list = a1.list;
        b1.aB.str = a1.str;

        b2.aB.list = a2.list;
        b2.aB.str = a2.str;

        // 不包含 对象类型
        assertThat(a1).isEqualToComparingFieldByField(a2);

        // 对象类型 只比较引用
        // assertThat(b1).isEqualToComparingFieldByField(b2);

        // 含有嵌式比较，含有对象类型的字段，再比较对象内的数据
        assertThat(b1).isEqualToComparingFieldByFieldRecursively(b2);

        // 添加错误提示信息： as
        assertThat("abc").as("校验abc").isEqualTo("abcd");

        // 链式校验.
        // isEqualTo 相等， contains包含
        assertThat("abc").as("校验abc").isEqualTo("abc").contains("d");

        // null判断
        Object object = null;
        assertThat(object).isNotNull();

        // 是否在某个范围内

        List list = new ArrayList();
        assertThat(list).isIn(new ArrayList(), new HashMap());
        assertThat(list).isNotIn(new ArrayList(), new HashMap());

        // 大小
        List list2 = new ArrayList();
        assertThat(list2).hasSize(1);

    }
}


/**
 * 
 * 两个类对象比较
 * 
 * @author hugang
 *
 */
class A {
    List<String> list = new ArrayList<String>();
    String str;

}


class B {
    A aB = new A();
    String test;
}
