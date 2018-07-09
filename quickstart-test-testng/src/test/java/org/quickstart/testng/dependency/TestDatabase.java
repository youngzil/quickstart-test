package org.quickstart.testng.dependency;

import org.testng.annotations.Test;

/**
 * Created by Georgy Gobozov on 12.01.2015.
 */
public class TestDatabase {

    // belong to "db" group,
    // Run if all methods from "deploy" group are passed.
    @Test(groups = "db", dependsOnGroups = "deploy")
    public void initDB() {
        System.out.println("This is initDB()");
    }

    // belong to "db" group,
    // Run if "initDB" method is passed.
    @Test(dependsOnMethods = {"initDB"}, groups = "db")
    public void testConnection() {
        System.out.println("This is testConnection()");
    }

}
