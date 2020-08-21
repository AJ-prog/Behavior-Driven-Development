Feature: Email Message Log
 		As a user I want to be able to veiw and manage email messsages.

Scenario: user should be able to view Email Message Log
Given valid user 
When user navigate to utilities
And user navigate to email message log
And user views email details
Then email details should display
