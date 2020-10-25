@rest
Feature: REST API Automation for Careers project

  @rest1
  Scenario: REST API Position CRUD
    Given I login via REST as "recruiter"
    When I create via REST "automation" position
    Then I verify via REST new "automation" position is in the list
    When I update via REST "automation" position
    Then I verify via REST new "automation" position is updated
    When I delete via REST new position
    Then I verity via REST new position is deleted
