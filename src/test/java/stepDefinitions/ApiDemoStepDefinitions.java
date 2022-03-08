package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ApiDemoStepDefinitions {
    String actualOptionText;

    @Given("user gets text of the Accessibility option")
    public void userGetsTextOfTheAccessibilityOption() {
        actualOptionText = Hooks.apiDemoHomePage.accessibilityOption.getText();
    }

    @Then("user validates that is {string}")
    public void userValidatesThatIs(String expectedText) {
        Assert.assertEquals(expectedText, actualOptionText);
    }
}
