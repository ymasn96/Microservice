Feature: Adding a new Actor
  As a user I would like to add a new actor into my table

  Scenario: The user requests to view all actors
    Given The list of actors is not empty
    When The user requests the list of actors from the API
    Then The actors are added to the database
