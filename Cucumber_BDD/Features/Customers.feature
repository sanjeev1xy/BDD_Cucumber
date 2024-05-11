Feature: Customers

Scenario: Add a new Customer
Given User Launch chrome browser
When User opens URL "http://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And click on Login
Then User Can view Dashboard
When User click on customers Menu
And click on customers Menu Item
And Click on Add new button
Then User can view Add new customer page 
When User enter customer info
And click on save button
Then User User can view confirmation message "The new customer has been added successful"
And close browser