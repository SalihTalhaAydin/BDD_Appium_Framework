package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Dimension;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class MobileCommonUtils {

    public static void assertTextsOfOptions(DataTable expected, List<AndroidElement> actual){
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expected.asList().get(i), actual.get(i).getText());
        }
    }


    static int waitOptionsDuration = Integer.parseInt(ConfigReader.getProperty("waitOptionsDuration"));

    /**
     * Table items are data table from feature
     *
     * @param tableItems
     * @param elements
     */
    public static void assertTextForTwoLists(DataTable tableItems, List<AndroidElement> elements) {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(tableItems.asList().get(i), elements.get(i).getText());
        }
    }


    /**
     * @param driver
     * @param androidElement
     */
    public static void tapByElement(AndroidDriver<AndroidElement> driver, AndroidElement androidElement) {
        touchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(androidElement))).perform();
    }

    /**
     * driver is AndroidDriver
     * visibleText is the text you would like to scroll to and click
     *
     * @param driver
     * @param visibleText
     */
    public static void scroll(AndroidDriver<AndroidElement> driver, String visibleText) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" + ".scrollIntoView(text(\"" + visibleText + "\"))");
    }

    /**
     * driver is AndroidDriver
     * visibleText is the text you would like to scroll to and click
     *
     * @param driver
     * @param visibleText
     */
    public static void scrollAndClick(AndroidDriver<AndroidElement> driver, String visibleText) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" + ".scrollIntoView(text(\"" + visibleText + "\"))").click();
    }

    //Tap by coordinates
    public static void tapByCoordinates(AndroidDriver<AndroidElement> driver, int x, int y) {
        touchAction(driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofSeconds(waitOptionsDuration))).perform();
    }

    //Press by element
    public static void pressByElement(AndroidDriver<AndroidElement> driver, AndroidElement element, long seconds) {
        touchAction(driver)
                .press(element(element))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    public static AndroidElement elementByText(AndroidDriver<AndroidElement> driver, String visibleText) {
        return driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + visibleText + "\")");
    }

    //Press by coordinates
    public static void pressByCoordinates(AndroidDriver<AndroidElement> driver, int x, int y, long seconds) {
        new TouchAction(driver)
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    //Horizontal Swipe by percentages
    public static void horizontalSwipeByPercentage(AndroidDriver<AndroidElement> driver, double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize(); // gets size of screen
        int anchor = (int) (size.height * anchorPercentage); //
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        new TouchAction(driver)
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofSeconds(waitOptionsDuration)))
                .moveTo(point(endPoint, anchor))
                .release().perform();
    }

    public static void horizontalSwipeByCoordinates(AndroidDriver<AndroidElement> driver, int xStart, int xEnd, int y) {
        new TouchAction(driver)
                .press(point(xStart, y))
                .waitAction(waitOptions(ofSeconds(waitOptionsDuration)))
                .moveTo(point(xEnd, y))
                .release().perform();
    }

    //Vertical Swipe by percentages
    public static void verticalSwipeByPercentages(AndroidDriver<AndroidElement> driver, double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofSeconds(waitOptionsDuration)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }

    public static void verticalSwipeByCoordinates(AndroidDriver<AndroidElement> driver, int x, int yStart, int yEnd) {
        new TouchAction(driver)
                .press(point(x, yStart))
                .waitAction(waitOptions(ofSeconds(waitOptionsDuration)))
                .moveTo(point(x, yEnd))
                .release().perform();
    }

    public static TouchAction touchAction(AndroidDriver<AndroidElement> driver) {
        return new TouchAction(driver);
    }

}
