package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApiDemoHomePage {

    public ApiDemoHomePage(AndroidDriver<AndroidElement> androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy (accessibility = "Accessibility") // accessibility id
    public AndroidElement accessibilityOption;

    @AndroidFindBy (id = "android:id/text1") // resource id
    public List<AndroidElement> allOptions;

    @AndroidFindBy(className = "android.widget.TextView")
    public List<AndroidElement> allElements;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Graphics\"]")
    public AndroidElement graphicsOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Media\")")
    public AndroidElement mediaOption;

}
