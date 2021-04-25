package questions;

import static uis.HomePage.BUTTON_SOCIAL;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class TheTarget implements Question<Boolean> {

	private Target webElement;

	public TheTarget(Target webElement) {
		this.webElement = webElement;
	}

	public TheTarget() {
		// It's empty intentionally
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(Click.on(BUTTON_SOCIAL));
		return webElement.resolveFor(actor).isPresent();
	}

	public static TheTarget isPresent(Target webElement) {
		return new TheTarget(webElement);
	}

}
