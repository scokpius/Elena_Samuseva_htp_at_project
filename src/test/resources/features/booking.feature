@booking
Feature: Testing booking.com

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

 Scenario: New user registration on booking.com
   Given I get a temporary mail and go to booking.com
   And I fill in the login and password fields
   When I confirm registration on booking.com
   And I return to booking.com to check in the registration
   And I write the login and password of my booking.com account to a file
   Then Checking registration on booking.com
   And I log out of my booking.com account

 Scenario: Choosing your favorite hotel
       Given I go to the Booking website
       And Sign in current account
       When I create a list to search for the given parameters
       And I set the parameters for 3 by test data
       And Choosing the first and last hotel
       Then Check what color is the heart
       When Write the names of the selected hotels to the list
       And Go to 'My next trips' list
       Then Check availability of selected hotels
       And I log out of my booking.com account

 Scenario: Checking for an element on a web page
       Given I go to the Booking website
       And Sign in current account
       When Checking for an element
       And I log out of my booking.com account