package inventory.kalerantes;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;

public class ItemCLIParser {

	public Item parseItem(Scanner scanner, PrintStream out) {
		out.print("Item name: ");
		String name = scanner.next();
		out.print("Item serial number: ");
		String SerialNumber = scanner.next();
		out.print("Item value: ");
		BigDecimal value = scanner.nextBigDecimal();
//		TODO you do not handle InputMismatch
		return new Item(name, SerialNumber, value);
	}

}
