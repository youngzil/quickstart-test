package org.quickstart.selenium.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.quickstart.selenium.example.config.SeleniumConfig;

public class StartHerePage {

    private SeleniumConfig config;

    @FindBy(css = ".page-title")
    private WebElement title;

    public StartHerePage(SeleniumConfig config) {
        this.config = config;
    }

    public String getPageTitle() {
        return title.getText();
    }
}
