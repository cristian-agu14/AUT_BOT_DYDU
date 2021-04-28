package tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static uis.KnowledgesPage.BUTTON_CARD_ANSWER_QUESTION;
import static uis.KnowledgesPage.BUTTON_CREATE;
import static uis.KnowledgesPage.TEXT_FIELD_ANSWER;
import static uis.KnowledgesPage.TEXT_FIELD_QUESTION;

import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class IntoQuestion implements Task {

	private String question;

	public IntoQuestion() {
		// It's empty intentionally
	}

	public IntoQuestion(String question) {
		this.question = question;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Click.on(BUTTON_CARD_ANSWER_QUESTION));
		actor.attemptsTo(Click.on(TEXT_FIELD_QUESTION));
		actor.attemptsTo(Enter.theValue(question).into(TEXT_FIELD_QUESTION));

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			LoggerFactory.getLogger(IntoQuestion.class).error("Error in the wait time", e);
		}

		actor.attemptsTo(Click.on(BUTTON_CREATE));

		actor.attemptsTo(WaitUntil.the(TEXT_FIELD_ANSWER, isNotVisible()).forNoMoreThan(60).seconds());

	}

	public static IntoQuestion inField(String question) {
		return Tasks.instrumented(IntoQuestion.class, question);
	}

}
