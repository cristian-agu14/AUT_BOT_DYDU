package tasks;

import static uis.HomePage.BUTTON_ADD;
import static uis.HomePage.BUTTON_NEW_KNOWLEDGE;
import static uis.HomePage.BUTTON_SOCIAL;
import static uis.HomePage.CARD_BUTTON_KNOW;
import static uis.HomePage.ELEMENT_LIST_BOTS;

import interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

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
			actor.attemptsTo(Click.on(BUTTON_SOCIAL));
		}

		actor.attemptsTo(Click.on(ELEMENT_LIST_BOTS.of(nameBot)));
		actor.attemptsTo(Wait.page());
		actor.attemptsTo(Click.on(CARD_BUTTON_KNOW));
		
		actor.attemptsTo(Wait.page());

		actor.attemptsTo(Click.on(BUTTON_ADD));
		actor.attemptsTo(Click.on(BUTTON_NEW_KNOWLEDGE));
		

	}

	public static IntoToCreateKnow newInTheBot(String nameBot) {
		return Tasks.instrumented(IntoToCreateKnow.class, nameBot);
	}

}
