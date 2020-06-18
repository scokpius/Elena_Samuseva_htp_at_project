Feature: Create a new user on booking

   Scenario: New user registration on booking.com
   Given I get a temporary mail and go to booking.com
   And I fill in the login and password fields
   When I confirm registration on booking.com
   And I return to booking.com to check in the registration
   And I write the login and password of my booking.com account to a file
   Then Checking registration on booking.com
   And I log out of my booking.com account