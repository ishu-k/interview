Feature: Search
  As an end user
  I want to search for product
  So that i shpuld see the desired product
  Scenario: Searchwithvaliddata
    Given Im on home page
    When I search for a prodcut
    Then I should see the desired product

   Scenario: search with invalid productid
      Given Im on home page
      When I search for a invalid productid
      Then i should see the error

   Scenario: search with no data
        Given Im on home page
        When I search with no data
        Then I should see the desired error

     Scenario: search with 
