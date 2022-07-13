package intentory.kalerantes;

import java.math.BigDecimal;

import exceptions.EmptyNameNotAllowedException;
import exceptions.LessThanOneValueException;
import exceptions.NullNameNotAllowedException;
import exceptions.NullSerialNumberNotAllowedException;
import exceptions.NullValueNotAllowedException;
import exceptions.OneLetterNotAllowedException;
import exceptions.SerialNumberLengthNotEqualNine;

public class Item {

	private String name;
	private String serialNumber;
	private BigDecimal value;

	public Item(String name, String serialNumber, BigDecimal value) {
		this.name = name;
		this.serialNumber = serialNumber;
		this.value = value;
//		validateValue(value);
		validateInput(name, value, serialNumber);
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

	private void validateInput(String name, BigDecimal value, String serialNumber) {
		validateName(name);
		validateSerialNumber(serialNumber);
		validateValue(value);
	}

	private void validateName(String name) {
		checkNotNullName(name);
		checkNotEmptyName(name);
		checkLengthNotOnlyOneLetter(name);
	}

	private void validateSerialNumber(String serialNumber) {
		checkNotNullSerialNumber(serialNumber);
		checkSerialNumberLengthNot9(serialNumber);
	}

	private void validateValue(BigDecimal value) {
		checkNotNullValue(value);
		valueLessThanOne(value);
	}

	private void checkNotNullName(String name) {
		if (name == null)
			throw new NullNameNotAllowedException();
	}

	private void checkNotEmptyName(String name) {
		if ("".equals(name))
			throw new EmptyNameNotAllowedException();
	}

	private void checkLengthNotOnlyOneLetter(String name) {
		if (name.length() == 1)
			throw new OneLetterNotAllowedException();
	}

	private void checkNotNullSerialNumber(String serialNumber) {
		if (serialNumber == null)
			throw new NullSerialNumberNotAllowedException();
	}

	private void checkSerialNumberLengthNot9(String serialNumber) {
		if (serialNumber.length() != 9)
			throw new SerialNumberLengthNotEqualNine();
	}

	private void checkNotNullValue(BigDecimal value) {
		if (value == null)
			throw new NullValueNotAllowedException();
	}

	private void valueLessThanOne(BigDecimal value) {
		if (value.compareTo(BigDecimal.valueOf(1)) == -1)
			throw new LessThanOneValueException();
	}

}
