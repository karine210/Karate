Feature: Récupération d'une réservation par ID

  Scenario: GET /booking/{id} - Vérifier la réponse
    Given url "https://restful-booker.herokuapp.com"

  # Première étape : obtenir un ID valide
    Given path "/booking"
    When method get
    Then status 200
    And match response != []
    * def firstBookingId = response[0].bookingid

  # Deuxième étape : tester avec un ID valide
    Given path "/booking/", firstBookingId
    And header Accept = "application/json"
    When method get
    Then status 200

      # Définition du schéma attendu
    And def expectedSchema =
  """
{
  firstname: '#string',
  lastname: '#string',
  totalprice: '#number',
  depositpaid: '#boolean',
  bookingdates:
  {   checkin: '#string',
      checkout: '#string'
  }
}
"""
    And match response contains expectedSchema
    * print 'Détails de la réservation:', response