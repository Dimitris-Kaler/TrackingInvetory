package inventory.items.exceptions;

public class NullSerialNumberNotAllowedException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Expected serialNumber for item but got null serialNumber instead.";
	}

}
