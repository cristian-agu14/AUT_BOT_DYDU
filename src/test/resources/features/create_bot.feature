#Author: cristian.agu14@gmail.com
@create-bots
Feature: I need to create a bot for test this functionality

  Background: 
    Given the user opens the portal dydupage
    When the user writes the user and password

  @create-bot
  Scenario Outline: Feature for test the create bots
    Given the user sees the homepage
    When the user starts to create the bot
    When enter <botName> and <language> for the user
    Then the user can to see the bot created with the name <botName>

    Examples: 
      | botName | language |
      | botNew3 | English  |
