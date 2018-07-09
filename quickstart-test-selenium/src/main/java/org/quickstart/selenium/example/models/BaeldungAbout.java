package org.quickstart.selenium.example.models;

import org.openqa.selenium.support.PageFactory;
import org.quickstart.selenium.example.config.SeleniumConfig;
import org.quickstart.selenium.example.pages.BaeldungAboutPage;

public class BaeldungAbout {

    private SeleniumConfig config;

    public BaeldungAbout(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(config.getDriver(), BaeldungAboutPage.class);
    }

    public void navigateTo() {
        config.navigateTo("http://www.baeldung.com/about/");
    }

    public String getPageTitle() {
        return BaeldungAboutPage.title.getText();
    }
}
