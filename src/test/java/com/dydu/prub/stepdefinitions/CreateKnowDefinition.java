package com.dydu.prub.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.WhichIsTheAnswer;
import tasks.InTheChatBot;
import tasks.IntoAnswer;
import tasks.IntoQuestion;
import tasks.IntoToCreateKnow;

public class CreateKnowDefinition {

	@When("the user selects a bot created with (.*)")
	public void theUserSelectABotCreatedWithBot_test_qa(String nameBot) {
		theActorInTheSpotlight().attemptsTo(IntoToCreateKnow.newInTheBot(nameBot));
	}

	@When("the user writes a question (.*) in the bot select")
	public void theUserWriteAInTheBotSelect(String question) {
		theActorInTheSpotlight().attemptsTo(IntoQuestion.inField(question));
	}

	@When("the user configure a answer (.*) for the question created")
	public void theUserConfigureAForTheQuestionCreated(String answer) {
		theActorInTheSpotlight().attemptsTo(IntoAnswer.inField(answer));
	}

	@When("test the know to created with the question (.*)")
	public void testTheKnowToCreated(String question) {
		theActorInTheSpotlight().attemptsTo(InTheChatBot.enterTheQuestion(question));
	}

	@Then("user can to see the (.*) is correct")
	public void userCanToSeeTheToTheEspagnol(String answer) {
		theActorInTheSpotlight().should(seeThat(WhichIsTheAnswer.ofChatBot(), equalTo(answer)));
	}

}
