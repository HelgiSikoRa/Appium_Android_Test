package com.epam.lab.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverUtil {
    private AppiumDriver<WebElement> driver;
    ConfigFileReader configFileReader;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        configFileReader = new ConfigFileReader();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.UDID, "192.168.148.101:5555");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, configFileReader.getImplicitlyWait());
        this.driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}