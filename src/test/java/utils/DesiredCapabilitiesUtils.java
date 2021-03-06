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

            // server url comes in here
            androidDriver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
            androidDriver.manage().timeouts().implicitlyWait(
                    Long.parseLong(ConfigReader.getProperty("implicitlyWaitTime")),
                    TimeUnit.SECONDS
            );
        }
        return androidDriver;
    }

    public static WebDriver setupWebDriverDesiredCapabilities() throws MalformedURLException {
        if (webDriver == null) {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // setting up the mobile device with below values

            desiredCapabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, ConfigReader.getProperty("browser")); // type of the browser
            desiredCapabilities.setCapability("chromedriverExecutableDir",
                    new File(ConfigReader.getProperty("chromeDriverPath")).getAbsolutePath()); //stores the app path

            // server url comes in here
            webDriver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
