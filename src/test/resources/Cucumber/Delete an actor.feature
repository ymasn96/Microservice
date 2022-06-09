Feature: Delete an actor
  as a user I would like to delete an actor from my table

  Scenario: I successfully delete an actor from my table
    Given I have the actor information for deletion
    When I send the delete request
    Then I get the deleted return string