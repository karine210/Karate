Feature: Karate

	@POEI20252-621 @Karine
	Scenario Outline: POST_Utilisateurs
		Given url "https://reqres.in/api/users"
		    And request { "name": "<name>", "job": "<job>" }
		    When method post
		    Then status 201
		    And match response.name == "<name>"
		    And match response.job == "<job>"
		    And match response.id == '#notnull'
		    And print response
		
		    Examples:
		      | name     | job      |
		      | morpheus | leader   |
		      | john      | QA   |
		
	@POEI20252-614 @Karine
	Scenario: GET–Utilisateurs
		Given url "https://reqres.in/api/users?page=2"
		    When method get
		    Then status 200
		    And match response.page == 2
		    And match response.data == '#[6]'
		    And match response.data[0].id == 7
		    And print response
		
