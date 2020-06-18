Feature: Checking Search Engine Web Service Test

  Scenario Outline: Check Web Service
    Given I get a list of searches for the web service
    When I get a response from web service <order> with test data order
    And I get a list of expected results
    Then I verify expected result equals actual <result> for <testType> test

    Examples:
      | order  | result | testType                 |
      | 0      | 0      | "Full Short UserName"    |
      | 1      | 1      | "Full  Long UserName"    |
      | 2      | -1     | "Partial Short UserName" |
      | 3      | 5      | "Partial Long UserName"  |
      | 4      | -1     | "All Users"              |