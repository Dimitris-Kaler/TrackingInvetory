package inventory.items.exceptions;

public class NullItemListException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Expected items in the inventory but we took null instead!";

	}

}
