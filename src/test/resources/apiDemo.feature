Feature: Api Demo Application

  @ValidateAccessibilityText
  Scenario: Get text of the button
    Given user gets text of the Accessibility option
    Then user validates that is "Accessibility"

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
