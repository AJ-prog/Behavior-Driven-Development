Feature: New Account Page 
	As a user I want a new account page so that accounts can be created.
	
 	
Scenario Outline: C235 - User should be able to create a new account 
	Given a user with username "<username>" and password "<password>" 
#	And a user with valid credentials
	When user navigates to New Account Page 
	And user create new account using title "<title>" Description "<description>" Amount "<amount>" 
	Then new account page should display
	Examples: 
		|username		  |password|title   |description|amount|
		|demo@techfios.com|abc123  |Shrimp  |Two Topping|10    |
		|demo@techfios.com|abc123  |Sandwich| Kabab     |5     |
		