package inventory.ui.menu;

import exceptions.InvalidMenuChoice;

public class CLIMenuChoiceValidator {

	public void validate(String choice) {
		validateInBounds(validateInteger(choice));
	}

	private static void validateInBounds(int value) {
		if (value < 1 || value > 6)
			throw new InvalidMenuChoice(String.valueOf(value));
	}

	private static int validateInteger(String choice) {
		try {
			return Integer.parseInt(choice);
		} catch (NumberFormatException e) {
			throw new InvalidMenuChoice(choice);
		}
	}

}
