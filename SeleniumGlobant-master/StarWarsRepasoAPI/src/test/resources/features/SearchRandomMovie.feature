@SearchRandomMovie
Feature: Verify Wikipedia Edit Page for a Random Star Wars Movie

  Scenario: Verify Wikipedia Edit Page for a Random Star Wars Movie
    Given User requests a random Star Wars movie
    When User searches for that movie on Wikipedia
    Then Edit page should be displayed correctly
    And Edit page title should match the selected movie