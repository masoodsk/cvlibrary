
Feature: Job search functionality scenario with More search option
  @Test
  Scenario Outline: Verify the Job Search functionality
    Given The user is on Job Search Page
    Then Click on More Search Options
    And User Enters "<Keywords>" , "<Location>" and selects "<Distance>"
    Then User Enters "<SalaryMin>", "<SalaryMax>" ,
    And USer Selects "<SalaryType>" and "<JobType>"
    And Click on FIND JOBS
    Then User is navigated to search results page


    Examples: 
      | Keywords       | Location | Distance | SalaryMin | SalaryMax | SalaryType | JobType   |
      | Test Analyst   | London  |       10 |        50 |       100 | hour       | Contract  |

