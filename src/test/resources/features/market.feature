@market
  Feature: Marketing test suite

    @market1
    Scenario: Get page details
      Given I go to "quote" page
      And I get page info

    @market2
      Scenario: Navigate
        Given I go to "google" page
        And I go to "quote" page
        And I go back and forward
        And I refresh the page

    @market3
      Scenario: Resolution
        Given I go to "quote" page
        And I change resolution to "phone"
#       And I change resolution to "desktop"

    @market4
    Scenario: Find element
      Given I go to "quote" page
      And I fill out required fields
      And I submit the page
      Then I verify that fields values recorded correctly

    @market5
    Scenario: Verify email behavior
      Given I go to "quote" page
      And I verify email behavior



