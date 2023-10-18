@title @smoke @all
Feature: Validate the Title feature search

  Scenario: Validate the OMDB feature with Movie title
    Given the OMDB feature has valid apikey for Authentication
    When searched with Movie title "Avatar"
     And made request to OMDB service
    Then response should be "200" Status code
    And Title in the response should be "Avatar"

  Scenario: Validate the OMDB feature with Movie title and year
    Given the OMDB feature has valid apikey for Authentication
    When searched with Movie title "Avatar"
    And also with Year "2009"
    And made request to OMDB service
    Then response should be "200" Status code
    And year in the response should be "2009"

  Scenario Outline: Validate the OMDB feature with Movie title and returntype
    Given the OMDB feature has valid apikey for Authentication
    When searched with Movie title "Avatar"
    And with Return type "<return-type>"
    And made request to OMDB service
    Then response should be "200" Status code
    And response should be in "<return-type>" format
    Examples:
      | return-type  |
      |   json       |
      |   xml       |


