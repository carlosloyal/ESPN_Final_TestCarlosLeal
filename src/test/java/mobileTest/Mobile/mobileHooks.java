package mobileTest.Mobile;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileHooks {

    private static CustomMobileDriverManager driver;


    @Before
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Object ConfigCapabilities = new Object();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new CustomMobileDriverManager(new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }


    @After
    public void tearDown() {
        driver.getDriver().quit();
    }


    public static AndroidDriver<AndroidElement> getDriver() {
        return driver.getDriver();
    }
}
