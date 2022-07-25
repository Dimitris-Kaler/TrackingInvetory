package exceptions;

import java.math.BigDecimal;

public class LessThanOneValueException extends RuntimeException {

	private final BigDecimal value;

	public LessThanOneValueException(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String getMessage() {
		return String.format("Expected value greater than one but got %s instead.", value.toString());
	}
}
