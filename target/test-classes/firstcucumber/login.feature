Feature: Login

#  Scenario: Login
#    Given Move to login page
#    When User abv
#    Then Abc
#    And ancc
#
#  Scenario Outline: Login fail
#    Given Move to login page
#    When User attemp to login with "<Username>" and "<Password>"
#    Then Error "Message" will be showed
#    Examples:
#      | Username | Password | Message           |
#      | Tesst    | 123acb   | The message must be more than 6 characters             |
#      | Khanhnv  | sdf      | The email is null |
@Sprint1
Scenario: Show user with valid keyword search
  Given The user input information for 10 record
        |fullname|dateofbirth|whereborn|
        |khanh tran|01/01/86 |BacNinh  |
  When The user find with the keyword "khanh tran"
  Then The information about Khan Tran is showed
@Sprint2
Scenario: Training
  Given The user add 5 items
    |item|
    |Test1|
    |Test2|
    |Test3|
  When User refresh browser
  Then Check items are shorted