package com.epam.lab.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebElementsInitialization {
    protected AppiumDriver<WebElement> driver;

    protected WebElementsInitialization(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}