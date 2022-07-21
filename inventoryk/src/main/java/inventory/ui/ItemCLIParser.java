package inventory.ui;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;

import exceptions.ValueNotNumeric;
import inventory.kalerantes.Item;

public class ItemCLIParser {

	public Item parseItem(Scanner scanner, PrintStream out) {
		out.print("Item name: ");
		String name = scanner.next();
		out.print("Item serial number: ");
		String SerialNumber = scanner.next();
		out.print("Item value: ");
		String valueString = scanner.next();
		BigDecimal value;
		try {
			value = new BigDecimal(valueString);
			return new Item(name, SerialNumber, value);
		} catch (NumberFormatException e) {
			throw new ValueNotNumeric(valueString);
		}

	}

}