package exceptions;

public class ValueNotNumeric extends RuntimeException {

	public ValueNotNumeric(String valueString) {
		super(message(valueString));
	}

	private static String message(String valueString) {
		return String.format("Expected numeric value for item's value but got '%s' instead", valueString);
	}

}
