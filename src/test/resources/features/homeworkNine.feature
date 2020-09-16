Feature: Homework 9

  @homework1
    Scenario: Converter
    Given I go to "converter" page
    Then I click on "Temperature" tab
    Then I select to convert from "Celsius" to "Fahrenheit"
    Then I calculate for the value of "24" and see the result

  @homework2
  Scenario: Verify calculator result
    Given I go to "calculator" page
    When I navigate to "Auto Loan Calculator"
    And I clear all calculator fields
    And I calculate
    Then I verify "Please provide a positive auto price." calculator error
    Then I verify "Please provide a positive interest value." calculator error
    And I enter "25000" price, "60" months, "4.5" interest, "5000" downpayment, "0" trade-in, "California" state, "7" percent tax, "300" fees
    And I calculate
    Then I verify monthly pay is "$372.86"

  @homework3
  Scenario: Every door direct mail
    Given I go to "USPS" page
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I click "Show Table" on the map
    When I click "Select All" on the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

  @homework4
  Scenario Outline: Converter scenario outline
    Given I go to "converter" page
    Then I click on "<conversion>" tab
    Then I select to convert from "<from>" to "<to>"
    Then I calculate for the value of "<value>" and see the result

    Examples:
      | conversion  | from      | to         | value |
      | Length      | Inch      | Centimeter | 2     |
      | Temperature | Celsius   | Fahrenheit | 180   |
      | Area        | Acre      | Hectare    | 2     |
      | Volume      | US Gallon | Liter      | 1     |
      | Weight      | Carrat    | Milligram  | 2     |
      | Time        | Hour      | Minute     | 24    |