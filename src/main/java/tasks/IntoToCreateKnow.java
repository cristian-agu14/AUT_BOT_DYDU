package tasks;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static uis.HomePage.BUTTON_ADD;
import static uis.HomePage.BUTTON_NEW_KNOWLEDGE;
import static uis.HomePage.BUTTON_SOCIAL;
import static uis.HomePage.CARD_BUTTON_KNOW;
import static uis.HomePage.ELEMENT_LIST_BOTS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;

import interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class IntoToCreateKnow implements Task {

	private String nameBot;

	public IntoToCreateKnow() {
		// It's empty intentionally
	}

	public IntoToCreateKnow(String nameBot) {
		this.nameBot = nameBot;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		if (!ELEMENT_LIST_BOTS.of(nameBot).resolveFor(actor).isVisible()) {
			theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_SOCIAL));
		}

		theActorInTheSpotlight().attemptsTo(Click.on(ELEMENT_LIST_BOTS.of(nameBot)));
		actor.attemptsTo(Wait.page());
		theActorInTheSpotlight().attemptsTo(Click.on(CARD_BUTTON_KNOW));

//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
//		}
		
		//actor.attemptsTo(WaitUntil.the(BUTTON_ADD, isVisible()).forNoMoreThan(60).seconds());
		
		actor.attemptsTo(Wait.page());

		theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_ADD));
		theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_NEW_KNOWLEDGE));
		

	}

	public static IntoToCreateKnow newInTheBot(String nameBot) {
		return Tasks.instrumented(IntoToCreateKnow.class, nameBot);
	}

}
