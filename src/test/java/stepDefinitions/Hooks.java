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

    //Native App Pages
    public static ApiDemoHomePage apiDemoHomePage;
    public static ApiDemoGraphicsPage apiDemoGraphicsPage;
    public static ApiDemoCustomEvaluator apiDemoCustomEvaluator;
    public static ApiDemoVerticesPage apiDemoVerticesPage;
    public static ApiDemoTextPage apiDemoTextPage;
    public static ApiDemoLogTextBoxPage apiDemoLogTextBoxPage;

    //Web App Pages
    public static MobileAmazonHomePage mobileAmazonHomePage;
    public static MobileEbayHomePage mobileEbayHomePage;

    @Before
    public void setup() throws Exception {
        switch (ConfigReader.getProperty("testing")) {
            case "app":
                androidDriver = DesiredCapabilitiesUtils.setupAndroidDesiredCapabilities();
                apiDemoHomePage = new ApiDemoHomePage(androidDriver);
                apiDemoGraphicsPage = new ApiDemoGraphicsPage(androidDriver);
                apiDemoCustomEvaluator = new ApiDemoCustomEvaluator(androidDriver);
                apiDemoVerticesPage = new ApiDemoVerticesPage(androidDriver);
                apiDemoTextPage = new ApiDemoTextPage(androidDriver);
                apiDemoLogTextBoxPage = new ApiDemoLogTextBoxPage(androidDriver);
                break;
            case "browser":
                webDriver = DesiredCapabilitiesUtils.setupWebDriverDesiredCapabilities();
                mobileAmazonHomePage = new MobileAmazonHomePage(webDriver);
                mobileEbayHomePage = new MobileEbayHomePage(webDriver);
                break;
            default:
                throw new Exception("Testing value does NOT come from configuration.properties!");
        }

    }

    @After
    public void tearDown() {
        DesiredCapabilitiesUtils.quitDriver();
    }
}
