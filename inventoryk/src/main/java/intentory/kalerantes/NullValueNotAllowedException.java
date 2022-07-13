package intentory.kalerantes;

public class NullValueNotAllowedException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Expected value for item but got null value instead.";
	}

}
