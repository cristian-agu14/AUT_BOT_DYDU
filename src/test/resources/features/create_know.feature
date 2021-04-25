#Author: cristian.agu14@gmail.com
@create-know
Feature: Create a know for a bot

  Background: 
    Given the user opens the portal dydupage
    When the user writes the user and password
    When the user sees the homepage

  @create-know-to-bot-created
  Scenario Outline: how user I wants to create a Knowledge, I want to create this Knowledge to a bot created
    Given the user sees the homepage
    When the user selects a bot created with <nameBot>
    When the user writes a question <question> in the bot select
    When the user configure a answer <answer> for the question created
    When test the know to created with the question <question>
    Then user can to see the <answer> is correct

    Examples: 
      | nameBot   | question                        | answer                                   |
      | cristian1 | ¿Cuantas veces puedo descargar? | Hola, hasta 5 descargas diarias. Saludos |

  @create-a-bot-with-a-Knowledge
  Scenario Outline: how user create a Knowledge, I want to create a bot and a Knowledge to this bot
    Given the user sees the homepage
    When the user starts to create the bot
    When enter <botName> and <language> for the user
    When the user can to see the bot created with the name <botName>
    When the user select a bot created with <nameBot>
    When the user writes a question <question> in the bot select
    When the user configure a answer <answer> for the question created
    When test the know to created with the question <question>
    Then user can to see the <answer> is correct

    Examples: 
      | nameBot   | language | question                                          | answer                                             |
      | cristian2 | Spanish  | ¿Cuantas consultas medicas puedo tener en un dia? | Hola, puede agendar hasta 3 citas por día. Saludos |
