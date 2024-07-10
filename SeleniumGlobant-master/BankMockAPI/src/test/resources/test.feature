Feature: Check if endpoint is empty
  Scenario: endpoint is empty
    Given The endpoint is empty
    When The Test requests data from the endpoint
    Then The endpoint should return nothing


Feature: Initialize Ten People

  Scenario Outline: On an empty endpoint add 10 people with First and last names, emails, passwords and account balance
    Given The endpoint is empty
    When POST POJO data
    Then The endpoint should have 10 people
    Examples:

    |ID|Username|Password|eMail|Account Balance|
    |0|JohnDoe0|pass0|johnDoe0@email.com|100|
    |1|JohnDoe1|pass1|johnDoe1@email.com|50|
    |2|JohnDoe2|pass2|johnDoe2@email.com|20|
    |3|JohnDoe3|pass3|johnDoe3@email.com|500|
    |4|JohnDoe4|pass4|johnDoe4@email.com|800|
    |5|JohnDoe5|pass5|johnDoe5@email.com|10|
    |6|JohnDoe6|pass6|johnDoe6@email.com|0|
    |7|JohnDoe7|pass7|johnDoe7@email.com|15|
    |8|JohnDoe8|pass8|johnDoe8@email.com|20|
    |9|JohnDoe9|pass9|johnDoe9@email.com|10|