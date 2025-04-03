Feature: Mise à jour de réservation

  Scenario: Flux complet création + mise à jour
  # Création
    * def creation = call read('createReservation.feature')
    * def bookingId = creation.bookingId

  # Mise à jour
    Given url "https://restful-booker.herokuapp.com/booking/" + bookingId
    And header Content-Type = "application/json"
    And request
    """
    {
      "firstname": "Pierre",
      "lastname": "Martin",
      "totalprice": 200,
      "depositpaid": true,
      "bookingdates": {
        "checkin": "2024-05-01",
        "checkout": "2024-05-05"
      },
      "additionalneeds": "Petit déjeuner"
    }
    """
    When method put
    Then status 403