package questions;

import interactions.GetTextFrom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static utils.RemembresTheActor.ANSWER_BOT_FROM_CHAT_BOT;

public class WhichIsTheAnswer implements Question<String> {

	@Subject("For say if the bot was created successfully")
	public String answeredBy(Actor actor) {
		actor.attemptsTo(GetTextFrom.chatBox("0"));
		String answerBot = actor.recall(ANSWER_BOT_FROM_CHAT_BOT);
		return answerBot;
	}

	public static WhichIsTheAnswer ofChatBot() {
		return new WhichIsTheAnswer();

	}

}
