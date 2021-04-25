#Author: cristian.agu14@gmail.com
@login
Feature: Login in the DYDU app

  @CorrectLogin
  Scenario: Login in the portal web with user and password
    Given the user opens the portal dydupage
    When the user writes the user and password
    Then the user sees the homepage
