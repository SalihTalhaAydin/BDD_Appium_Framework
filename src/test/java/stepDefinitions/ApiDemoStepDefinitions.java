package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.*;
import static org.junit.Assert.*;
import static utils.MobileCommonUtils.*;

public class ApiDemoStepDefinitions {
    String actualAccessibilityText;
    String actualGraphicsText;
    String actualMediaText;
    String actualViewText;
    List<String> actualAllOptionTexts;
    int actualSize;

    @Given("user gets text of the Accessibility option")
    public void userGetsTextOfTheAccessibilityOption() {
        actualAccessibilityText = apiDemoHomePage.accessibilityOption.getText();
    }

    @Given("user gets texts of all options")
    public void userGetsTextsOfAllOptions() {
        actualAllOptionTexts = new ArrayList<>();
        for (AndroidElement option: apiDemoHomePage.allOptions) {
            actualAllOptionTexts.add(option.getText());
        }
    }

    @Then("user validates options")
    public void userValidatesOptions(DataTable expectedAllOptionTexts) {
        assertTextsOfOptions(expectedAllOptionTexts, apiDemoHomePage.allOptions);
    }

    @Given("user gets all elements with className")
    public void userGetsAllElementsWithClassName() {
        actualSize = apiDemoHomePage.allElements.size();
    }

    @Then("user validates size of element is {int}")
    public void userValidatesSizeOfElementIs(int expectedSize) {
        assertEquals(expectedSize, actualSize);
    }

    @Given("user gets text of Graphics option")
    public void userGetsTextOfGraphicsOption() {
        actualGraphicsText = apiDemoHomePage.graphicsOption.getText();
    }

    @Then("user validates that it is {string}")
    public void userValidatesThatItIs(String expectedOptionText) throws Exception {
        switch (expectedOptionText){
            case "Accessibility":
                assertEquals(expectedOptionText, actualAccessibilityText);
                break;
            case "Graphics":
                assertEquals(expectedOptionText, actualGraphicsText);
                break;
            case "Media":
                assertEquals(expectedOptionText, actualMediaText);
                break;
            case "Views":
                assertEquals(expectedOptionText, actualViewText);
                break;
            default:
                throw new Exception("Element does not exist!!!");
        }

    }

    @Given("user gets text of Media option")
    public void userGetsTextOfMediaOption() {
        actualMediaText = apiDemoHomePage.mediaOption.getText();
    }

    @Then("user validates that it is equal to {string}")
    public void userValidatesThatItIsEqualTo(String expectedMediaText) {
        assertEquals(expectedMediaText, actualMediaText);
    }

    @Given("user gets text of Views option")
    public void userGetsTextOfViewsOption() {
        actualViewText = apiDemoHomePage.viewOption.getText();
    }

    @Given("user taps on {string}")
    public void userTapsOn(String optionText) {
        tapByElement(androidDriver, elementByText(androidDriver, optionText));
    }

    @Then("user validates that {string} is visible")
    public void userValidatesThatIsVisible(String expectedArcsText) {
        assertEquals(expectedArcsText, apiDemoGraphicsPage.arcsOption.getText());
    }

    @Then("user should see Play Button")
    public void userShouldSeePlayButton() {
        assertTrue(apiDemoCustomEvaluator.playButton.isDisplayed());
    }

    @When("user scrolls and taps on {string}")
    public void userScrollsAndTapsOn(String optionText) {
        scrollAndClick(androidDriver, optionText);
    }

    @Then("user validates picture is displayed")
    public void userValidatesPictureIsDisplayed() {
        assertTrue(apiDemoVerticesPage.image.isDisplayed());
    }

    @And("user validates title is {string}")
    public void userValidatesTitleIs(String expectedTitle) {
        assertEquals(expectedTitle, apiDemoVerticesPage.title.getText());
    }

    @Then("user validates options are displayed")
    public void userValidatesOptionsAreDisplayed(DataTable expectedOptionTexts) {
        assertTextsOfOptions(expectedOptionTexts, apiDemoTextPage.textOptions);
    }

    @And("user validates the message is {string}")
    public void userValidatesTheMessageIs(String expectedMessage) {
        assertEquals(expectedMessage, apiDemoLogTextBoxPage.logTexts.getText().trim());
    }

    @Given("user taps by coordinates {int}, {int} on {string}")
    public void userTapsByCoordinatesOn(int x, int y, String optionText) {
        tapByCoordinates(androidDriver, x, y);
    }

    @And("user presses for {int} seconds by coordinates {int}, {int} to {string}")
    public void userPressesForSecondsByCoordinatesTo(int seconds, int x, int y, String optionText) {
        pressByCoordinates(androidDriver, x, y, seconds);
    }

    @And("user should see {string}")
    public void userShouldSee(String expectedTitle) {
        assertTrue(elementByText(androidDriver, expectedTitle).isDisplayed());
    }

}
