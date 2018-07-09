package org.quickstart.selenium.example.junit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.quickstart.selenium.example.SeleniumExample;

public class SeleniumWithJUnitLiveTest {

    private static SeleniumExample seleniumExample;
    private String expectedTitle = "Baeldung | Java, Spring and Web Development tutorials";

    @BeforeClass
    public static void setUp() {
        seleniumExample = new SeleniumExample();
    }

    @AfterClass
    public static void tearDown() {
        seleniumExample.closeWindow();
    }

    @Test
    public void whenAboutBaeldungIsLoaded_thenAboutEugenIsMentionedOnPage() {
        seleniumExample.getAboutBaeldungPage();
        String actualTitle = seleniumExample.getTitle();
        assertNotNull(actualTitle);
        assertEquals(expectedTitle, actualTitle);
        assertTrue(seleniumExample.isAuthorInformationAvailable());
    }

}
