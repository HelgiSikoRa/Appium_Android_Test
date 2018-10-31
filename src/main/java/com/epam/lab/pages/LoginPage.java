package com.epam.lab.pages;

import com.epam.lab.utils.WebElementsInitialization;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends WebElementsInitialization {
    private final static Logger LOG = LogManager.getLogger(LoginPage.class);
    private WebDriverWait wait = new WebDriverWait(driver, 30);
    private final String passwordXPath = "//*[@resource-id='password']//*[@class='android.widget.EditText']";
    private final String userNameID = "identifierId";

    @FindBy(id = userNameID)
    private WebElement userName;

    @FindBy(xpath = passwordXPath)
    private WebElement password;

    @FindBy(id = "identifierNext")
    private WebElement button;

    public LoginPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public LoginPage enterUserName(String userName) {
        LOG.info("UserName typed correctly");
        wait.until(ExpectedConditions.elementToBeClickable(By.id(userNameID)));
        this.userName.sendKeys(userName);
        return new LoginPage(driver);
    }

    public LoginPage enterPassword(String password) {
        LOG.info("Entered valid password");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(passwordXPath)));
        this.password.sendKeys(password);
        return new LoginPage(driver);
    }

    public LoginPage submit() {
        button.click();
        return new LoginPage(driver);
    }


    public boolean checkLoginStatus() {
        LOG.info("Checked login status");
        return driver.getCurrentUrl().contains("inbox");
    }
}