package exceptions;

public class NullNameNotAllowedException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Expected name for item but got null name instead.";
	}
}
