Feature: practice

  Scenario Outline: testing dropdown and selects
    Given a user is on Home Page
    When they select Job Title "<job title>"
    And they click Search Employee
    Then they see employees with job title "<job title>"

    Examples:
      | job title  |
      | Consultant |


  Scenario Outline: testing checkboxes
    Given a user is on Home Page
    When they click checkbox next to employee ID "<employee ID>"
    Then checkbox is checked for employee "<employee ID>"

    Examples:
      | employee ID |  |
      | 635919      |  |