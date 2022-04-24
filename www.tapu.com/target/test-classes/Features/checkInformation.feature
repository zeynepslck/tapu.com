#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Check information of the registered user

Scenario: Check informations
    Given User is on "https://www.tapu.com/"
    And User click "Uye Ol" button at homepage
    And User enter name, surname, mobile phone information
    And User select the checkboxs of campaignsoffers and membership agreement
    When User click "Uye Ol" button at uye ol modal
    Then Close verify modal
    And User should be check name and surname
    And User click "Bilgilerim" menu
    And User check name, surname, mobile phone information
    And Close browser
