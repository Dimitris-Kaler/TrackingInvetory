package intentory.kalerantes;

public class LessThanOneValueException extends RuntimeException {

	@Override
	public String getMessage(){
		return "Expected value greater than one but got less tha one instead.";
	}
}
