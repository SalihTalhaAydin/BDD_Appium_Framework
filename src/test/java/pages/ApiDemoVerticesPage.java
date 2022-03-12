package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ApiDemoVerticesPage {
    public ApiDemoVerticesPage(AndroidDriver<AndroidElement> androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(className = "android.view.View")
    public AndroidElement image;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Graphics/Vertices\")")
    public AndroidElement title;
}
