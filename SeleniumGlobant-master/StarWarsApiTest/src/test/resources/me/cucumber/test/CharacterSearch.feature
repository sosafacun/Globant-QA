Feature: Character search on Wikipedia using an API

  Scenario Outline: Request the first five characters on Star Wars API and validate
  Given the user is on SW api requesting character id <number>
  When the user search on Wikipedia "<cName>"
  Then the user should be able to see the article page correctly displayed for "<cName>"

  Examples:
    | number | cName |
    | 1 | Luke Skywalker |
    | 2 | C-3PO |
    | 3 | R2-D2 |
    | 4 | Darth Vader |
    | 5 | Princess Leia |

