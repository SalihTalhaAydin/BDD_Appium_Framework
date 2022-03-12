Feature: Mobile chrome testing

  @openChrome
  Scenario: Validate Title
    Given user navigates to "https://techglobalschool.com" on device
    And user validates title is "SDET Bootcamp | TechGlobal" on device