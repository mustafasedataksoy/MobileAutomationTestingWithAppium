Feature:  Swipe Functionality
  Background:
    Given Open Application
    When Navigate to Swipe Page


    @Smoke
  Scenario: Scroll Down
    And Scroll Down
    Then Logo should be Visible

      @Smoke
    Scenario: Scroll Right
      And Scroll Right
      Then Last Element Should Be Visible
