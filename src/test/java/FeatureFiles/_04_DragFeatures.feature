Feature: Drag Functionality

  Background:
    Given Open Application
    When Navigate to Drage Page

    @Smoke
    Scenario: Drag And Drop
      When User Completes Drag And Drop
      Then Success Message Should Display
