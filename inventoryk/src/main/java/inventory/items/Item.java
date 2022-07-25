package inventory.items;

import java.math.BigDecimal;

import inventory.items.exceptions.EmptyNameNotAllowedException;
import inventory.items.exceptions.LessThanOneValueException;
import inventory.items.exceptions.NullNameNotAllowedException;
import inventory.items.exceptions.NullSerialNumberNotAllowedException;
import inventory.items.exceptions.NullValueNotAllowedException;
import inventory.items.exceptions.SerialNumberLengthNotEqualNine;

public class Item {

	private String name;
	private String serialNumber;
	private BigDecimal value;

	public Item(String name, String serialNumber, BigDecimal value) {
		this.name = name;
		this.serialNumber = serialNumber;
		this.value = value;
		validateInput();
	}

	public String getName() {
		return name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public BigDecimal getValue() {
		return value;
	}

	private void validateInput() {
		validateName();
		validateSerialNumber();
		validateValue();
	}

	private void validateName() {
		checkNotNullName();
		checkNotEmptyName();
	}

	private void validateSerialNumber() {
		checkNotNullSerialNumber();
		checkSerialNumberLengthNot9();
	}

	private void validateValue() {
		checkNotNullValue();
		valueLessThanOne();
	}

	private void checkNotNullName() {
		if (name == null)
			throw new NullNameNotAllowedException();
	}

	private void checkNotEmptyName() {
		if ("".equals(name))
			throw new EmptyNameNotAllowedException();
	}

	private void checkNotNullSerialNumber() {
		if (serialNumber == null)
			throw new NullSerialNumberNotAllowedException();
	}

	private void checkSerialNumberLengthNot9() {
		if (serialNumber.length() != 9)
			throw new SerialNumberLengthNotEqualNine();
	}

	private void checkNotNullValue() {
		if (value == null)
			throw new NullValueNotAllowedException();
	}

	private void valueLessThanOne() {
		if (value.compareTo(BigDecimal.valueOf(1)) < 0)
			throw new LessThanOneValueException(value);
	}

}
