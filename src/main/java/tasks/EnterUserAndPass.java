package tasks;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static uis.LoginPage.BUTTON_CONNECT;
import static uis.LoginPage.TEXT_FIELD_PASSWORD;
import static uis.LoginPage.TEXT_FIELD_USER;

import interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class EnterUserAndPass implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Wait.page());
		theActorInTheSpotlight().attemptsTo(Enter.theValue(System.getProperty("user")).into(TEXT_FIELD_USER));
		theActorInTheSpotlight().attemptsTo(Enter.theValue(System.getProperty("password")).into(TEXT_FIELD_PASSWORD));
		theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_CONNECT));
	}

	public static EnterUserAndPass inPageOfLogin() {
		return Tasks.instrumented(EnterUserAndPass.class);
	}

}
