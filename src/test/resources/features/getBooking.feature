Feature:
  Scenario: get all reservations
    Given url "https://restful-booker.herokuapp.com"
    And path "/booking"
    When method get
    Then status 200
    * assert response.size() > 0