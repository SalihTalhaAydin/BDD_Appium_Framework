package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DesiredCapabilitiesUtils {

    private static AndroidDriver<AndroidElement> androidDriver;
    private static WebDriver webDriver;

    /**
     * This method sets up DesiredCapabilities
     * for Android Emulator, Appium Server and mobile application
     *
     * @return
     * @throws MalformedURLException
     */

    public static AndroidDriver<AndroidElement> setupAndroidDesiredCapabilities() throws MalformedURLException {
        if (androidDriver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // setting up the mobile device with below values

            desiredCapabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability("app", new File(ConfigReader.getProperty("apkAppPath")).getAbsolutePath()); // absolute path not content root

            URL appiumServerUrl = new URL("http://0.0.0.0:4723/wd/hub"); // server url comes in here

            androidDriver = new AndroidDriver<>(appiumServerUrl, desiredCapabilities);
            androidDriver.manage().timeouts().implicitlyWait(
                    Long.parseLong(ConfigReader.getProperty("implicitlyWaitTime")),
                    TimeUnit.SECONDS
            );
        }
        return androidDriver;
    }

    public static WebDriver setupWebDriverDesiredCapabilities() throws MalformedURLException {
        if (webDriver == null) {
            File appFile = new File(ConfigReader.getProperty("chromeDriverPath")); //stores the app path
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // setting up the mobile device with below values
            desiredCapabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, ConfigReader.getProperty("browser"));
            desiredCapabilities.setCapability("chromedriverExecutableDir", appFile.getAbsolutePath());/**/
            // System.out.println(appFile.getAbsolutePath());
            // desiredCapabilities.setCapability("appPackage", "com.android.chrome");
            // desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
            URL appiumServerUrl = new URL("http://0.0.0.0:4723/wd/hub"); // server url comes in here
            webDriver = new RemoteWebDriver(appiumServerUrl, desiredCapabilities);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ///Users/techglobal/IdeaProjects/AutomationFramework/src/test/java/mobile/apps
        }
        return webDriver;
    }

    public static void quitDriver() {
        if (androidDriver != null) {
            androidDriver.quit();
            androidDriver = null;
        } else if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
