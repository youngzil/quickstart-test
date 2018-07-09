package org.quickstart.selenium.example.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.quickstart.selenium.example.SeleniumExample;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SeleniumWithTestNGLiveTest {

    private SeleniumExample seleniumExample;
    private String expectedTitle = "Baeldung | Java, Spring and Web Development tutorials";

    @BeforeSuite
    public void setUp() {
        seleniumExample = new SeleniumExample();
    }

    @AfterSuite
    public void tearDown() {
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
