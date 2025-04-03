Feature: Test post

  Scenario: test post
    Given url 'https://restful-booker.herokuapp.com/booking'

    And header Accept = "application/json"


    And request { "firstname": "Pierre","lastname": "Martin","totalprice": 150,"depositpaid": true,"bookingdates": {"checkin": "2024-05-01","checkout": "2024-05-05"},"additionalneeds": "Petit déjeuner"}
    When method post
    Then status 200
    And match response.bookingid != null
    And def id = response.bookingid
    * print response