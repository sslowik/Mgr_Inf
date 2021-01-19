Feature: Log in

  As a user, I want to be able to log in to the system, so that I can use powerful options

  Scenario Outline: Home page default login
    Given User is on landing page
    When User login into application with <username> login and password <password>
    Then Home page is visible
    And Card are displayed

    Examples:
      |username      | password |
      |Adam Bogdanka | 12345    |
      |Adam Nowak    | 54321    |

  @SmokeTest
  Scenario: Home page default login
    Given User is on landing page
    When User login into application with "Adam Nowak" login and "54321" password
    Then Home page is visible
    And Card are displayed

  @MobileTest
  Scenario: Home page default login
    Given User is on landing page
    When User sign up into application with the following details
      |Adam Nowak | 54321 |
    Then Home page is visible
    And Card are displayed
