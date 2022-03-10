package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ApiDemoHomePage;

import java.util.List;

import static stepDefinitions.Hooks.*;

public class ApiDemoStepDefinitions {
    String actualOptionText;
    List<AndroidElement> allOptions;

    @Given("user gets text of the Accessibility option")
    public void userGetsTextOfTheAccessibilityOption() {
        actualOptionText = apiDemoHomePage.accessibilityOption.getText();
    }

    @Then("user validates that is {string}")
    public void userValidatesThatIs(String expectedText) {
        Assert.assertEquals(expectedText, actualOptionText);
    }

    @Given("user gets texts of all options")
    public void userGetsTextsOfAllOptions() {
        allOptions = apiDemoHomePage.allOptions;
    }

    @Then("user validates options")
    public void userValidatesOptions(DataTable expectedAllOptionTexts) {
        for (int i = 0; i < allOptions.size(); i++) {
            Assert.assertEquals(expectedAllOptionTexts.asList().get(i), allOptions.get(i).getText());
        }
    }
}
