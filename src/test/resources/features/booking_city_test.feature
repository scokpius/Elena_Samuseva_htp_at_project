Feature: Testing city booking.com

  Scenario Outline: Testing booking.com with parameters by city
    Given I go to the Booking website
    When I create a list to search for the given parameters
    And I set the parameters for <search> by test data
    Then I select a test for <city> by <search>
    And I verify the fulfillment of the condition in <city>

    Examples:
      | search  | city     |
      | 0       | "Paris"  |
      | 1       | "Moscow" |
      | 2       | "Oslo"   |

