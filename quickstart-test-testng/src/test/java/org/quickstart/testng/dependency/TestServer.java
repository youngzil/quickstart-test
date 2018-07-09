package org.quickstart.testng.dependency;

import org.testng.annotations.Test;

/**
 * Created by Georgy Gobozov on 12.01.2015.
 */

// all methods of this class are belong to "deploy" group.
@Test(groups = "deploy")
public class TestServer {

    @Test
    public void deployServer() {
        System.out.println("Deploying Server...");
    }

    // Run this if deployServer() is passed.
    @Test(dependsOnMethods = "deployServer")
    public void deployBackUpServer() {
        System.out.println("Deploying Backup Server...");
    }

}
