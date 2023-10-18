@search @smoke @all
Feature: Validate the Title feature search

  Scenario: Validate the OMDB feature with Movie title
    Given the OMDB feature has valid apikey for Authentication
    When using "Avatar" as search parameter.
     And made request to OMDB service
    Then response should be "200" Status code
    And All Titles in the response should be contains "Avatar"