Feature: Login

  Scenario: Successful Login with Valid Credentials
    Given User Launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    #And  User clean emailid and password
    #Then Page Title should be "Your store.Login"
    And close browser

  Scenario Outline: Login Data Driven
    Given User Launch chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and password as "<password>"
    And click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    #Then page Title should be "Your store. Login"
    And close browser

    Examples: 
      | email                | password |
      | admin@yourstore.com  | admin    |
      | admin1@yourstore.com | admin123 |
      
      
