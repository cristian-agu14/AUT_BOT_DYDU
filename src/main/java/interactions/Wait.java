package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static uis.LoginPage.PNG_LOARDING_PAGE;

public class Wait implements Interaction {

	@Override
	public <T extends Actor> void performAs(T actor) {
		if (PNG_LOARDING_PAGE.resolveFor(actor).isVisible()) {
			actor.attemptsTo(WaitUntil.the(PNG_LOARDING_PAGE, isNotVisible()).forNoMoreThan(180).seconds());
		}

	}

	public static Wait page() {
		return Tasks.instrumented(Wait.class);
	}

}
