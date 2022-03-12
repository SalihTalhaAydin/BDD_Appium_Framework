Feature: Mobile chrome testing

  @validateTechGlobalTitle
  Scenario: Validate Title
    Given user navigates to "https://techglobalschool.com" on device
    And user validates title is "SDET Bootcamp | TechGlobal" on device

  @classTaskScenarioOutlineOnDevice
  Scenario Outline: Validate the "<title>" for given "<url>"
    Given user navigates to "<url>" on device
    When user types "keyholder" on search box and presses enter on device
    Then user validates title is "<title>" on device

    Examples:
      | url                     | title                            |
      | https://www.amazon.com/ | Amazon.com : keyholder           |
      | https://www.ebay.com/   | keyholder: Search Result \| eBay |