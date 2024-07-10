Feature: Movie search on Wikipedia using an API

  Scenario: Request random movie on the Star Wars API and validate
  Given the user is on SW api requesting a random movie
  And the user search on Wikipedia that movie
  When the user click on edit link
  Then the user should be able to see the article title correctly displayed for that


