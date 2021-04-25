package uis;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {

	public static final Target BUTTON_USER_HOMEPAGE = Target
			.the("Button that is in the homepage after successful login").located(By.id("userActionDropdown"));

	public static final Target BUTTON_SOCIAL = Target.the("Button with name social")
			.locatedBy("//button[@data-testid='testid-bot-select-button-dropdown']");

	public static final Target BUTTON_CREER_UN_BOT = Target.the("Button for create a bot")
			.locatedBy("//button[@class='button button_primary button_wide']");

	public static final Target TEXT_FIELD_NAME_BOT = Target.the("Text field for name bot").located(By.id("nameFld"));

	public static final Target SELECT_LANGUAGE_BOT = Target.the("List of all languages for select")
			.located(By.id("language"));

	public static final Target BUTTON_CREATE = Target.the("Button for create a bot")
			.locatedBy("//button[contains(text(),'Create')]");

	public static final Target ELEMENT_LIST_BOTS = Target.the("List that contains all bot created")
			.locatedBy("//div//a[@class='button button_inline button_text button_wide' and contains(text(),'{0}')]");

	public static final Target COMBO_BOX_BOT_NOT_SELECTED = Target.the("Combo box that use when is not selected")
			.locatedBy(
					"//div//a[@class='button button_inline button_text button_wide' and contains(text(),'{0}')]//following-sibling::a");

	public static final Target CARD_BUTTON_KNOW = Target.the("This card button is the link for create know")
			.locatedBy("(//a[@class='card__link'])[1]");

	public static final Target CARD_BUTTON_CREATE = Target.the("This card button is the link for create know")
			.locatedBy("(//div[@class='card__link'])[1]");

	public static final Target CARD_BUTTON_CREATE_QUESTION = Target
			.the("This card button is the link for create a question")
			.locatedBy("(//div[@class='col_container selectionable-item'])[1]");

	public static final Target BUTTON_ADD = Target.the("Button add new knowlede")
			.locatedBy("//button[@ data-testid='testid-dropdown-button-dropdown' and @source-id='newActionDropdown']");

	public static final Target BUTTON_NEW_KNOWLEDGE = Target.the("Sub button new knowledge")
			.locatedBy("//a//span[contains(text(),'New knowledge')]");
}
