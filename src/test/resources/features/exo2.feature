Feature: Test POST - Créer un utilisateur

  Scenario Outline: Vérifier la création d'un utilisateur
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

