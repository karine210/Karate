Feature: Plan for Export

	@POEI20252-464 @Maxence_Droz
	Scenario: Valid Login
		Given The user is on the login page
		When The user inputs a valid username "john"
		And The user inputs a valid password "demo"
		And The user presses the login button
		Then The user is successfully connected and redirected to the home page
		
	@POEI20252-482 @Maxence_Droz
	Scenario: Valid Register
		Given The user is on the login page
		When The user clicks on the register link
		When The user input his information
		  | firstName | lastName | address      | city     | state | zipCode | phoneNumber | username | password      |
		  | John      | Doe      | 1234 Main St | New York | NY    | 10001   | 555-1234    | john_doe | SecurePass123 |
		And The user clicks on the register button
		Then The user is registered and a welcome message is displayed
		
