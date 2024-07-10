@SearchCharacterOnWikipedia
Feature: Verify Wikipedia Article for Star Wars Characters

  Scenario Outline: Check Wikipedia article displayed for Star Wars Characters
    Given I am a user at the Wikipedia WebPage requesting SW character <number>
    When I search the requested character name on Wikipedia search page
    Then I should be able to see the article page correctly displayed for the requested character

    Examples:
      | number |
      | 1      |
      | 2      |
      | 3      |
      | 4      |
      | 5      |