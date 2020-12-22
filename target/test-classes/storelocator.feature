  @storelocator
Feature: Store Locator
  As an end user
  I want to locate the store using postcode
  so That it should display the stock
  
  Scenario: Verify functionality of store locator that stock clothing
    Given I am on Home page
    When I click Tu store locator link
    And enter post code
    And select checkbox for only show stores that stock clothing and tick checkbox womens
    Then it should display store that stock clothing
