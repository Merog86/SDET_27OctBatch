@login
Feature: Wordpress application
Scenario: Login to Wordpress application
Given I open my wordpress application
And I login with following credentials into the application
| admin | demo123 |
And I validate the page title
|Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress|