package inventory.ui;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;

import inventory.kalerantes.Item;
import inventory.ui.exceptions.ValueNotNumeric;

public class ItemCLIParser {

	public Item parseItem(Scanner scanner, PrintStream out) {
		out.print("Item name: ");
		String name = scanner.next();
		out.print("Item serial number: ");
		String sn = scanner.next();
		out.print("Item value: ");
		String valueString = scanner.next();
		BigDecimal value;
		try {
			value = new BigDecimal(valueString);
			return new Item(name, sn, value);
		} catch (NumberFormatException e) {
			throw new ValueNotNumeric(valueString);
		}

	}

}