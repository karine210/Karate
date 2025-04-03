Feature: Test post

  Scenario: test post
    Given url 'https://restful-booker.herokuapp.com/booking/1'
    When method delete
    Then status 403
    * print response