package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;

import static stepDefinitions.Hooks.*;
import static org.junit.Assert.*;
import static utils.WaitUtils.*;

public class ChromeStepDefinitons {
    @Given("user navigates to {string} on device")
    public void userNavigatesToOnDevice(String url) {
        webDriver.get(url);
    }

    @And("user validates title is {string} on device")
    public void userValidatesTitleIsOnDevice(String expectedTitle) {
        waitForPageTitle(webDriver, expectedTitle);
        assertEquals(expectedTitle, webDriver.getTitle());
    }

    @When("user types {string} on search box and presses enter on device")
    public void userTypesOnSearchBoxAndPressesEnterOnDevice(String text) {

       if (webDriver.getCurrentUrl().contains("amazon")){
           mobileAmazonHomePage.searchBox.sendKeys(text + Keys.ENTER);
       }else if(webDriver.getCurrentUrl().contains("ebay")){
            mobileEbayHomePage.searchBox.sendKeys(text + Keys.ENTER);
       }else throw new NotFoundException("The search box locator for website doesn't exist!");
    }
}
