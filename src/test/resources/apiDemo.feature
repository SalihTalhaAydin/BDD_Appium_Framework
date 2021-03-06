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

  @TapAndScrollToElement
  Scenario: Tap to Graphics and Scroll to Vertices and Tap to Vertices
    Given user taps on "Graphics"
    When user scrolls and taps on "Vertices"
    Then user validates picture is displayed
    And user validates title is "Graphics/Vertices"

  @TapAndValidateMessage
  Scenario: Tap to Text option and validate details
    Given user taps on "Text"
    Then user validates options are displayed
      | Linkify | LogTextBox | Marquee |
    And user taps on "LogTextBox"
    And user taps on "ADD"
    And user validates the message is "This is a test"
    And user taps on "DO NOTHING"
    And user validates the message is "This is a test"

  @classTaskCoordinatesTap
  Scenario: Long Press element
    Given user taps by coordinates 88, 1550 on "Views"
    When user taps by coordinates 184, 1300 on "Expandable Lists"
    Then user taps by coordinates 224, 268 on "1. Custom Adapter"
    And user presses for 2 seconds by coordinates 211, 241 to "People Names"
    And user should see "Sample menu"

  @horizontalSwipe
  Scenario: Swipe horizontally
    Given user swipes on "App" xStart 81 xEnd 1000, y 542

  @verticalSwipeByCoordinates
  Scenario: Tap to Graphics and Swipe Down to Vertices By Coordinates
    Given user taps on "Graphics"
    When user swipe down by coordinates x 500 yStart 1500 and yEnd 500 and taps on "Vertices"
    Then user validates picture is displayed