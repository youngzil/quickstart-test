package org.quickstart.selenium.example.junit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.quickstart.selenium.example.config.SeleniumConfig;
import org.quickstart.selenium.example.models.BaeldungAbout;
import org.quickstart.selenium.example.pages.BaeldungHomePage;
import org.quickstart.selenium.example.pages.StartHerePage;

public class SeleniumPageObjectLiveTest {

    private SeleniumConfig config;
    private BaeldungHomePage homePage;
    private BaeldungAbout about;

    @Before
    public void setUp() {
        config = new SeleniumConfig();
        homePage = new BaeldungHomePage(config);
        about = new BaeldungAbout(config);
    }

    @After
    public void teardown() {
        config.close();
    }

    @Test
    @Ignore
    public void givenHomePage_whenNavigate_thenTitleMatch() {
        homePage.navigate();
        assertThat(homePage.getPageTitle(), is("Baeldung"));
    }

    @Test
    @Ignore
    public void givenHomePage_whenNavigate_thenShouldBeInStartHere() {
        homePage.navigate();
        StartHerePage startHerePage = homePage.clickOnStartHere();
        assertThat(startHerePage.getPageTitle(), is("Start Here"));
    }

    @Test

    public void givenAboutPage_whenNavigate_thenTitleMatch() {
        about.navigateTo();
        assertThat(about.getPageTitle(), is("About Baeldung"));
    }
}
