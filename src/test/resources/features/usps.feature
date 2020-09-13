@usps
  Feature: USPS scenarios

    Background:
      Given I go to "USPS" page

    @usps1
    Scenario: Validate ZIP code
      When I look up ZIP by address
#      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
      And I fill out "306 hawthorne" street, "Houston" city, "TX" state
      And I submit the form
#      Then I validate "94022" ZIP code exists in the result
      Then I validate "77006" ZIP code exists in the result

      #______________UI tasks for Homework 8__________
  @usps2
  Scenario: Calculate price
    When I go to Calculate Price Page
    And I select "Canada" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.40"

  @usps3
  Scenario: Phone number of the nearest Mail Pickup
    When I navigate to Find a Location page
    And I filter by "Post Offices" location types, "Pickup Services" services, "Accountable Mail" available services
    And I provide data as "4970 El Camino Real 110" street, "Los Altos" city, "CA" state
    Then I verify phone number is "800-275-8777"

  @usps4
  Scenario: Quadcopters delivery
    When I go to "Help" tab
    And I perform "Quadcopters delivery" help search
    Then I verify that no results of "Quadcopters delivery" available in help search

          #______________Homework 12__________
  @usps5
Scenario: Wrong store id does not match
    When I go to "Postal Store" tab
    And I enter "12345" into store search
    Then I search and validate no products found

    @usps6
    Scenario: One item found
      When I go to "Stamps" under "Postal Store"
      And choose mail service Priority Mail
#      Then I verify 1 items found
