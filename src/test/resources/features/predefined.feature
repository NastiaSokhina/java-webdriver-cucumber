#Assignment 3 - Nastia Sokhina

@predefined
Feature:
  Background:
    Given I open url "https://skryabin.com/market/quote.html"

  @predefined1
  Scenario: Responsive UI
    And I resize window to 1280 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And I resize window to 800 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And I resize window to 400 and 1024
    Then element with xpath "//b[@id='location']" should not be displayed

  @predefined2
  Scenario: Min length
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//*[@id='username-error']" should be displayed
    And I clear element with xpath "//input[@name='username']"
    When I type "ab" into element with xpath "//input[@name='username']"
    Then element with xpath "//*[@id='username-error']" should not be displayed
    
  @predefined3
    Scenario: 'Email' field behavior
      When I type "rhjvb" into element with xpath "//input[@name='email']"
      And I click on element with xpath "//button[@type='submit']"
      Then element with xpath "//label[@id='email-error']" should be present
      Then I clear element with xpath "//input[@name='email']"
      Then I type "email@test.com" into element with xpath "//input[@name='email']"
      And I click on element with xpath "//button[@type='submit']"
      Then element with xpath "//label[@id='email-error']" should not be displayed
      
  @predefined4
    Scenario: Validate 'Password' fields
      When I clear element with xpath "//input[@name='password']"
      Then element with xpath "//input[@name='confirmPassword']" should be disabled
      When I type "password" into element with xpath "//input[@name='password']"
      Then element with xpath "//input[@name='confirmPassword']" should be present

  @predefined5
    Scenario: Validate 'Name' field behavior
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//div[@id='nameDialog']" should be present
      Then I type "Nastia" into element with xpath "//input[@id='firstName']"
      And I type "V" into element with xpath "//input[@id='middleName']"
      And I type "Sokhina" into element with xpath "//input[@id='lastName']"
      Then I click on element with xpath "//span[contains(text(), 'Save')]"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "Nastia V Sokhina"

  @predefined6
    Scenario: Validate 'Terms and Conditions' as required field
      When I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//*[@type='checkbox'][@name='agreedToPrivacyPolicy']" should have attribute "aria-required" as "true"
      When I click on element with xpath "//*[@type='checkbox'][@name='agreedToPrivacyPolicy']"
      Then element with xpath "//*[@type='checkbox'][@name='agreedToPrivacyPolicy']" should have attribute "aria-invalid" as "false"

  @predefined7
    Scenario: Submit the form and verify the data
    #submit form
      When I type "username1" into element with xpath "//input[@name='username']"
      And I type "test1@mail.com" into element with xpath "//input[@name='email']"
      And I type "Welcome1" into element with xpath "//input[@id='password']"
      And I type "Welcome1" into element with xpath "//input[@id='confirmPassword']"
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//div[@id='nameDialog']" should be present
      Then I type "Nastia" into element with xpath "//input[@id='firstName']"
      And I type "V" into element with xpath "//input[@id='middleName']"
      And I type "Sokhina" into element with xpath "//input[@id='lastName']"
      Then I click on element with xpath "//span[contains(text(), 'Save')]"
      Then I type "8888888888" into element with xpath "//input[@name='phone']"
      When I click on element with xpath "//input[@id='dateOfBirth']"
      Then element with xpath "//table[@class='ui-datepicker-calendar']" should be present
      Then I click on element with xpath "//select[@class='ui-datepicker-year']/option[@value='1996']"
      And I click on element with xpath "//select[@class='ui-datepicker-month']/option[@value='3']"
      And I click on element with xpath "//tr[3]//td[7]"
      Then I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Russia']"
      Then I click on element with xpath "//input[@value='female'][@type='radio']"
      Then I click on element with xpath "//input[@type='checkbox'][contains(@name,'Contact')]"
      Then I type "123 Main St" into element with xpath "//textarea[@id='address']"
      Then I click on element with xpath "//select[@name='carMake']/option[@value='Other']"
      Then I click on element with xpath "//input[contains(@name, 'PrivacyPolicy')]"
      Then I click on element with xpath "//button[@id='formSubmit']"
      #verify info
      Then element with xpath "//div[@id='quotePageResult']" should contain text "username1"
      Then element with xpath "//div[@id='quotePageResult']" should contain text "Nastia V Sokhina"
      Then element with xpath "//div[@id='quotePageResult']" should contain text "test1@mail.com"
      Then element with xpath "//b[@name='password']" should not contain text "Welcome1"




        



