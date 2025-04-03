Feature:
  Scenario: get all reservations
    Given url "https://restful-booker.herokuapp.com"
    And path "/booking/1"
    * header Accept = "application/json"
    When method get
    Then status 200
