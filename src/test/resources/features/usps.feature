@usps
  Feature: USPS scenarios

    @usps1
    Scenario: Validate ZIP code
      Given I go to "USPS" page
      When I look up ZIP by address
#      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
      And I fill out "306 hawthorne" street, "Houston" city, "TX" state
      And I submit the form
#      Then I validate "94022" ZIP code exists in the result
      Then I validate "77006" ZIP code exists in the result

      #______________UI tasks for Homework 8__________
  @usps2
  Scenario: Calculate price
    Given I go to "USPS" page
    When I go to Calculate Price Page
#    And I select "Canada" with "Postcard" shape
#    And I define "2" quantity
#    Then I calculate the price and validate cost is "$2.40"

  @usps3
  Scenario: Phone number of the nearest Mail Pickup
    Given I go to "USPS" page
    When I navigate to Find a Location page
#    And I filter by "Post Offices" location types, "Pickup Services" services, "Accountable Mail" available services
#    And I provide data as "4970 El Camino Real 110" street, "Los Altos" city, "CA" state
#    Then I verify phone number is "800-275-8777"