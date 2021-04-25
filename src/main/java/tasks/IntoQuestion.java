package tasks;

import static uis.KnowledgesPage.BUTTON_CARD_ANSWER_QUESTION;
import static uis.KnowledgesPage.BUTTON_CREATE;
import static uis.KnowledgesPage.TEXT_FIELD_QUESTION;

import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

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
		actor.attemptsTo(Enter.theValue(question).into(TEXT_FIELD_QUESTION));
		actor.attemptsTo(Click.on(BUTTON_CREATE));
		if (BUTTON_CREATE.resolveFor(actor).isPresent()) {
			actor.attemptsTo(Click.on(BUTTON_CREATE));
		}
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}

	}

	public static IntoQuestion inField(String question) {
		return Tasks.instrumented(IntoQuestion.class, question);
	}

}
