Feature: View actor information
  As a user I would like to view all searched actors

  Scenario: The information responds to search query input
    Given The web application is running
    When I type an actor's first name or last name into the search box
    Then I get a card displaying the actors name