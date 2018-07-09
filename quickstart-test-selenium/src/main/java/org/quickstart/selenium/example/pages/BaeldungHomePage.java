package org.quickstart.selenium.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.quickstart.selenium.example.config.SeleniumConfig;

public class BaeldungHomePage {

    private SeleniumConfig config;
    @FindBy(css = ".header--menu > a")
    private WebElement title;
    @FindBy(css = ".menu-start-here > a")
    private WebElement startHere;

    public BaeldungHomePage(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(this.config.getDriver(), this);
    }

    public void navigate() {
        this.config.navigateTo("http://www.baeldung.com/");
    }

    public String getPageTitle() {
        return title.getAttribute("title");
    }

    public StartHerePage clickOnStartHere() {
        config.clickElement(startHere);

        StartHerePage startHerePage = new StartHerePage(config);
        PageFactory.initElements(config.getDriver(), startHerePage);

        return startHerePage;
    }
}
