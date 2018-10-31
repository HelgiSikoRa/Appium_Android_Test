package com.epam.lab;

import com.epam.lab.pages.LoginPage;
import com.epam.lab.utils.ConfigFileReader;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GmailLoginTest {
    private AppiumDriver<WebElement> driver;
    private ConfigFileReader configFileReader = new ConfigFileReader();
    LoginPage loginPage;

    @Parameters({"login", "password"})
    @Test
    public void loginToGmail(String login, String password) {
        loginPage = new LoginPage(driver);
        driver.navigate().to(configFileReader.getWebSiteUrl());
        loginPage.enterUserName(login)
                .submit()
                .enterPassword(password)
                .submit()
                .checkLoginStatus();
        Assert.assertTrue(loginPage.checkLoginStatus());
    }
}