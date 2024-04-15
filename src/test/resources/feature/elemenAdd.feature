Feature: Element adding

  Scenario: Add element to list
    When I check elements before adding
    When I check elements after adding
    Then Elements are not equal
