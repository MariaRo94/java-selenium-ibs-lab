Feature: Elements removing

  Scenario: Clear element list
    When I check elements before removing
    When I check elements after removing all
    Then Elements count are not equal