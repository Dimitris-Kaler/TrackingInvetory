package intentory.kalerantes;

import java.math.BigDecimal;

public class Item {

	private String name;
	private BigDecimal value;

	public Item(String name, BigDecimal value) {
		this.name = name;
		this.value = value;
		validateInput(name, value);
	}

	public String getName() {
		return name;
	}

	public BigDecimal getValue() {
		return value;
	}

	private void validateInput(String name, BigDecimal value) {
		validateName(name);
		validateValue(value);
	}

	private void validateName(String name) {
		checkNotNullName(name);
		checkNotEmptyName(name);
	}

	private void validateValue(BigDecimal value) {
		if (value.compareTo(BigDecimal.valueOf(1)) == -1 )
			throw new LessThanOneValueException();
	}

	private void checkNotNullName(String name) {
		if (name == null)
			throw new NullNameNotAllowedException();
	}

	private void checkNotEmptyName(String name) {
		if ("".equals(name))
			throw new EmptyNameNotAllowedException();
	}


}
