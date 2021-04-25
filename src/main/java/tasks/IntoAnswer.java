package tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static uis.KnowledgesPage.BUTTON_UPDATE;
import static uis.KnowledgesPage.IFRAME;
import static uis.KnowledgesPage.TEXT_FIELD_ANSWER;

import org.openqa.selenium.WebDriver;

import interactions.Switch;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class IntoAnswer implements Task {

	private String answer;

	public IntoAnswer() {
		// It's empty intentionally
	}

	public IntoAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();

		actor.attemptsTo(Switch.toFrame(driver, IFRAME));
		actor.attemptsTo(WaitUntil.the(TEXT_FIELD_ANSWER, isEnabled()).forNoMoreThan(180).seconds());
		actor.attemptsTo(Enter.theValue(answer).into(TEXT_FIELD_ANSWER));

		actor.attemptsTo(Switch.toFrame(driver).backFrame());

		actor.attemptsTo(Click.on(BUTTON_UPDATE));

	}

	public static IntoAnswer inField(String answer) {
		return Tasks.instrumented(IntoAnswer.class, answer);
	}

}
