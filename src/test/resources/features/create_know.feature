#Author: cristian.agu14@gmail.com
@create-know
Feature: Create a know for a bot

  Background: 
    Given the user opens the portal dydupage
    When the user writes the user and password

  @create-a-bot-with-a-Knowledge
  Scenario Outline: how user create a Knowledge, I want to create a bot and a Knowledge to this bot
    Given the user sees the homepage
    When the user starts to create the bot
    When enter <nameBot> and <language> for the user
    When the user can to see the bot created with the name <nameBot>
    When the user selects a bot created with <nameBot>
    When the user writes a question <question> in the bot select
    When the user configure a answer <answer> for the question created
    When test the know to created with the question <question>
    Then user can to see the <answer> is correct

    Examples: 
      | nameBot   | language | question                                 | answer                               |
      | cristian4 | English  | How many oranges are in the supermarket? | There are not oranges in this moment |

  @create-know-to-bot-created
  Scenario Outline: how user I wants to create a Knowledge, I want to create this Knowledge to a bot created
    Given the user sees the homepage
    When the user selects a bot created with <nameBot>
    When the user writes a question <question> in the bot select
    When the user configure a answer <answer> for the question created
    When test the know to created with the question <question>
    Then user can to see the <answer> is correct

    Examples: 
      | nameBot   | question                           | answer                                             |
      | cristian2 | Where is the American bus station? | The American bus station is next to the University |
