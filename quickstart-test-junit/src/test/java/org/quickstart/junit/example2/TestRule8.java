package org.quickstart.junit.example2;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({A.class, B.class, C.class})
public class TestRule8 {

    @ClassRule
    public static ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("connect the db");
        };

        @Override
        protected void after() {
            System.out.println("close the db");
        };
    };
}
