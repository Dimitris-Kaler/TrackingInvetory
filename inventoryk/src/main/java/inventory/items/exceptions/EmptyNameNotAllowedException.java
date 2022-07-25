package exceptions;

public class EmptyNameNotAllowedException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Expected name for item but got empty value for name instead.";
	}

}
