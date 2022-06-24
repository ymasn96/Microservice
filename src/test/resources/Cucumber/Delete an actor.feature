Feature: Delete an actor from table
  As a user I would like to delete an actor from the actor table

  Scenario: I successfully delete an actor from the actor table
    Given I have the id of the actor that I would like to delete
    When I input the id of that specific actor
    Then I receive a response showing that the actor has been deleted