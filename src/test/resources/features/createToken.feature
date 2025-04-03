Feature: Génération de token d'authentification

  Scenario: POST /auth - Obtenir un token valide
    Given url "https://restful-booker.herokuapp.com/auth"
    And header Content-Type = "application/json"
    And request
    """
    {
      "username": "admin",
      "password": "password123"
    }
    """
    When method post
    Then status 200
    And match response contains {  token: '#string'  }
    And match response.token != null
    And match response.token != ''
    * def authToken = response.token
    * print 'Token généré:', authToken