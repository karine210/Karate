Feature: Test GET – Lister les utilisateurs
  Scenario: Récupérer les informations de l'utilisateur 2
    Given url "https://reqres.in/api/users?page=2"
    When method get
    Then status 200
    And match response.page == 2
    And match response.data == '#[6]'
    And match response.data[0].id == 7
    And print response


