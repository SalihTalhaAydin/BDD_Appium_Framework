package stepDefinitions;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.*;
import static org.junit.Assert.*;

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
        for (int i = 0; i < actualAllOptionTexts.size(); i++) {
            assertEquals(expectedAllOptionTexts.asList().get(i), actualAllOptionTexts.get(i));
        }
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
}
