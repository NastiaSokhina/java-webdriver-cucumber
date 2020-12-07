@rest
Feature: REST API Automation for Careers project

  @rest1
  Scenario: REST API Position CRUD
    Given I login via REST as "recruiter"
    When I create via REST "automation" position
    Then I verify via REST new "automation" position is in the list
#    When I update via REST "automation" position
#    Then I verify via REST new "automation" position is updated
#    When I delete via REST new position
#    Then I verify via REST new position is deleted

  @rest2
  Scenario: REST API Candidates CRUD
    Given I login via REST as "recruiter"
    When I create via REST "sdet" candidate
      # Then I verify via REST new "sdet" candidate is in the list
    When I add via REST "pdf" resume to a new candidate
    Then I verify via REST that "pdf" resume has been added
    When I update via REST "sdet" candidate
    Then I verify via REST new "sdet" candidate is updated
    When I delete via REST new candidate
    Then I verify via REST new candidate is deleted

  @rest3
  Scenario: REST API Application CRUD
    Given I login via REST as "recruiter"
    When I create via REST "automation" position
    And I create via REST "sdet" candidate
    And I add via REST "pdf" resume to a new candidate
    When I apply new candidate to a new position
    Then I verify via REST new application is submitted
    When I update via REST "rtf" resume of a new candidate
    Then I verify via REST "rtf" resume of a new application is updated
    When I delete via REST new application
    Then I verify via REST new application is deleted