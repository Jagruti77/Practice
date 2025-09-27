@tag
Feature: Purchase Order from Ecommerce Website
  I want to use this template for my feature file

Background:
  Given I have landed on login page

@tag1
Scenario Outline: Purchase Order - Positive
  Given I have logged with <username> and <password>
  When I add product <productname> to cart
  And I Checkout <productname> and submit the order
  Then "THANKYOU FOR THE ORDER." msg should be displayed on Confirmation page

  Examples: 
    | username                | password   | productname |
    | sharmajagruti@gmail.com | J@123456$j | Laptop      |