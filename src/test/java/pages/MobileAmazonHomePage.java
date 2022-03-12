package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileAmazonHomePage {
    public MobileAmazonHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-search-keywords")
    public WebElement searchBox;
}
