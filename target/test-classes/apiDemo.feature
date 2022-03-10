Feature: Api Demo Application

  @ValidateAccessibilityText
  Scenario: Get text of the button
    Given user gets text of the Accessibility option
    Then user validates that it is "Accessibility"

  @ValidateAllTexts
  Scenario: Get texts of All options and validate them
    Given user gets texts of all options
    Then user validates options
      | Accessibility |
      | Animation     |
      | App           |
      | Content       |
      | Graphics      |
      | Media         |
      | NFC           |
      | OS            |
      | Preference    |
      | Text          |
      | Views         |

  @ValidateSizeOfElement
  Scenario: Get All Elements with ClassName
    Given user gets all elements with className
    Then user validates size of element is 12

  @ValidateTextWithXpath
  Scenario: Get text of button
    Given user gets text of Graphics option
    Then user validates that it is "Graphics"

  @ValidateTextWithUIAutomatorAndDesc
  Scenario: Get text of button with ui automator and content-desc
    Given user gets text of Media option
    Then user validates that it is "Media"

  @ValidateTextWithUIAutomatorAndIndex
  Scenario: Get text of button with ui automator and index
    Given user gets text of Views option
    Then user validates that it is "Views"

  @tapToElement1
  Scenario: Tap to Graphics and Validate Arcs is visible
    Given user taps on "Graphics"
    Then user validates that "Arcs" is visible

  @tapToElement2
  Scenario: Tap to Animation
    Given user taps on "Animation"
    When user taps on "Custom Evaluator"
    Then user should see Play Button