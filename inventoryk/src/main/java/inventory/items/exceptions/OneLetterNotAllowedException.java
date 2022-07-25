package inventory.items.exceptions;

public class OneLetterNotAllowedException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Expected name with more than one characters";
	}

}
