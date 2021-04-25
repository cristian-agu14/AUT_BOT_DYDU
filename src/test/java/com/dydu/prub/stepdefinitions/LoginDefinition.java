package com.dydu.prub.stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.TheUserIsLogin;
import tasks.EnterUserAndPass;
import utils.WebDriverFactory;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginDefinition {

	@Before
	public void antesDelTest() {
		OnStage.setTheStage(new OnlineCast());
	}

	@Given("the user opens the portal (.*)")
	public void theUserOpenThePortal(String page) throws FileNotFoundException, IOException {
		OnStage.theActorCalled("The user").whoCan(BrowseTheWeb.with(WebDriverFactory.web().onPage(page)));
	}

	@When("the user writes the user and password")
	public void theUserEnterTheUserAndPassword() {
		theActorInTheSpotlight().attemptsTo(EnterUserAndPass.inPageOfLogin());
	}

	@Then("the user sees the homepage")
	public void theUserSeeTheHomepage() {
		theActorInTheSpotlight().should(seeThat(TheUserIsLogin.successful()));
	}

}
