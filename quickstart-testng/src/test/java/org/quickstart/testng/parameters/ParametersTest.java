package org.quickstart.testng.parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Georgy Gobozov on 12.01.2015.
 */
public class ParametersTest {

    @Test
    @Parameters({"param1", "param2"})
    public void createConnection(String param1, int param2) {
        System.out.println("param1 : " + param1);
        System.out.println("param2 : " + param2);

    }

}
