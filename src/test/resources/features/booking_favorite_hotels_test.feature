Feature: Favorite hotels


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

