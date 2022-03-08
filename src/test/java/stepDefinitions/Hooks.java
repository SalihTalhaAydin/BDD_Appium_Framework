package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.*;
import utils.DesiredCapabilitiesUtils;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;


public class Hooks {
    public static AndroidDriver<AndroidElement> androidDriver;
    public static WebDriver webDriver;

    public static ApiDemoHomePage apiDemoHomePage;

    @Before
    public void setup() throws Exception{
        switch (ConfigReader.getProperty("testing")){
            case "app":
                androidDriver = DesiredCapabilitiesUtils.setupAndroidDesiredCapabilities();
                apiDemoHomePage = new ApiDemoHomePage(androidDriver);
                break;
            case "browser":
                webDriver = DesiredCapabilitiesUtils.setupWebDriverDesiredCapabilities();
                break;
            default:
                throw new Exception("Testing value does NOT come from configuration.properties!");
        }

    }

    @After
    public void tearDown(){
        DesiredCapabilitiesUtils.quitDriver();
    }
}
