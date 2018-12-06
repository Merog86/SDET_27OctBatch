Feature: Orange application scenarios

@RegressionTest
Scenario: Login to orangeHR application
Given UserId and Password are visible
When User is able to enter values in login page
Then Login page is successfully submitted and landing page is loaded

@RegressionTest
Scenario: Dashboard Validation
Given Dashboard Page is visible and UI is as per business rule
When Dashboard page is completely loaded

@SmokeTest1
Scenario: Dashboard Validation
Given Availability of report
When User is having report access rights
Then Perform validation on data

@SmokeTest
Scenario: Login to application
Given I open my application
And I login with following credentials 
| admin | admin123 |
And I validate the title
|OrangeHRM|

@SmokeTest2
Scenario: Sum of list of numbers should be calculated
Given a list of numbers
|17 |
| 42  |
| 4711 |
When I summarize them
Then I should get 4770

@SmokeTest3
Scenario: search the Directory
Given I open my application
And I login with following credentials 
| admin | admin123 |
When I click on Directory tab
And I enter username as "Linda Anderson"
And I select the Job Title as "HR Manager"
And I select the Location as "    Texas R&D"
When I click the Search button
Then I should see the user in the result table
