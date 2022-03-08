Feature: Api Demo Application

  @ValidateAccessibilityText
  Scenario: Get text of the button
    Given user gets text of the Accessibility option
    Then user validates that is "Accessibility"
