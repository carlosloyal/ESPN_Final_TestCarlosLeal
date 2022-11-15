@FullScenarios
Feature: ESPN Web module

  Background:
    Given The data of environment and users of the system

  @ScenarioLogin
  Scenario:  A. Doing Login
    Given I open up the page ESPN
    When  I open the modal to login
    Then I see the web elements mentioned

    Given  I am logged in
    When  I go to Watch
    Then I validate that at least one carousel is present
    And Each target has a title and a small description about streaming source

    Given  I am in the watch site
    When   I click on the second card in the first carousel
    Then I validate that (x) is present on the page, and closes the card


    Given  I open up the page ESPN
    When  I hover the (User Icon) element located at the top right corner of the view
    Then I validate that in the sign up modal says Welcome "carlos!"


    Given  I log out from current session
    When  I hover the (User Icon) element located at the top right corner of the view
    Then I validate that in the sign up modal says Welcome! without username


  @ScenarioLogout
  Scenario: B. Doing Logout
    Given I open up the page ESPN
    When  I open the modal to login
    Then I am logged in

    Given  I log out from current session
    When  I hover the (User Icon) element located at the top right corner of the view
    Then I validate that in the sign up modal says Welcome! without username


  @ScenarioDeactivateAccount
  Scenario: C. Deactivate Account
    Given I open up the page ESPN
    When  I open the modal to login
    Then I am logged in


    Given  I hover the (User Icon) element located at the top right corner of the view
    When I click on the ESPN profile option
    Then I can deactivate the account
    And I validate the check green action when the account is deactivated


    Given I open the modal to login
    When I am logged in
    Then I get message from page








