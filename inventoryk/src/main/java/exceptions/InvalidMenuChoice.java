package exceptions;

public class InvalidMenuChoice extends RuntimeException {

	public InvalidMenuChoice(String choice) {
		super(message(choice));
	}

	private static String message(String choice) {
		return String.format("Expected value between 1 and 6 but got %s instead.", choice);
	}

}
