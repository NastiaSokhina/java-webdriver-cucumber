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