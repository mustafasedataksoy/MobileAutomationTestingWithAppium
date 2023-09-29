Feature: Forms Functionality
  Background:
  Given Open Application
    When Navigate to Forms Page

    @Smoke
    Scenario: Turn on Switch
      When User Turns On Switch
      Then  The Switch Should Be Turned On

      @Smoke
      Scenario: Select An Option From DropDown
        When User Opens DropDown Menu
        And  Selects Second Option
        Then Second Option Should Be Selected