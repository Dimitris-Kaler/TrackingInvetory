package inventory.ui.menu;

import inventory.ui.exceptions.InvalidMenuChoice;

public class CLIMenuChoiceValidator {


	private Menu menu;

	public CLIMenuChoiceValidator(Menu menu) {
		this.menu = menu;
	}

	public void validate(String choice) {
		if (!menu.codes().contains(choice))
			throw new InvalidMenuChoice(choice);
	}

}
