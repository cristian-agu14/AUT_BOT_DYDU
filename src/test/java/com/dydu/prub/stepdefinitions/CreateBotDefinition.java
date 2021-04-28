package com.dydu.prub.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static uis.HomePage.ELEMENT_LIST_BOTS;

import exceptions.MyExcepction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.TheTarget;
import tasks.CreateBot;
import tasks.StartTheCreation;

public class CreateBotDefinition {

	@When("the user starts to create the bot")
	public void theUserStartToCreateTheBot() {
		theActorInTheSpotlight().attemptsTo(StartTheCreation.ofABot());
	}

	@When("enter (.*) and (.*) for the user")
	public void theUserEnterBot(String nameBot, String language) {
		theActorInTheSpotlight().attemptsTo(CreateBot.whitNameAndLanguaje(nameBot, language));
	}

	@Then("the user can to see the bot created with the name (.*)")
	public void theUserCanToSeeTheBotCreatedWithThe(String nameBot) {
		theActorInTheSpotlight().should(seeThat(TheTarget.isPresent(ELEMENT_LIST_BOTS.of(nameBot)))
				.orComplainWith(MyExcepction.class, MyExcepction.ERROR_CREATION_BOT));
	}

}
