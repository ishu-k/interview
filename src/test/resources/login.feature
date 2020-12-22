Feature:Login
  As an end user
  I want to login
  So that I can login succesfully
  Scenario: Verify login with valid data
    Given I am on home page
    And I click on Login
    When I enter valid login details
    And I click on Login button
    Then I should see welcome page
    And I should see full name on top of the page