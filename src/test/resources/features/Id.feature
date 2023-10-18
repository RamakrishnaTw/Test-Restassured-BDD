@id @smoke @all
Feature: Validate the Title feature search

  Scenario: Validate the OMDB feature with IMBD ID
    Given the OMDB feature has valid apikey for Authentication
    When searched with Movie ID "tt0499549"
     And made request to OMDB service
    Then response should be "200" Status code
    And Title in the response should be "Avatar"