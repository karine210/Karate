Feature: Utiliser un token pour mettre à jour une réservation

  Background:

  * url 'https://restful-booker.herokuapp.com/'

  Scenario: Générer token, créer et modifier une réservation avec auth


    Given path '/auth'
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And request
    """
    {
      "username": "admin",
      "password": "password123"
    }
    """
    When method POST
    Then status 200
    * print response

    * def token = response.token


    Given path '/booking'
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And request
    """
    {
      "firstname": "Pierre",
      "lastname": "Martin",
      "totalprice": 150,
      "depositpaid": true,
      "bookingdates": {
        "checkin": "2024-05-01",
        "checkout": "2024-05-05"
      },
      "additionalneeds": "Petit déjeuner"
    }
    """
    When method POST
    Then status 200
    * print response

    * def bookingId = response.bookingid


    Given path '/booking', bookingId
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Cookie = 'token=' + token
    And request
    """
    {
      "additionalneeds": "Dinner"
    }
    """
    When method patch
    Then status 200
    And match response.additionalneeds == 'Dinner'
    * print response