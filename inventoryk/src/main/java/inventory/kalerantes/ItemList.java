package inventory.kalerantes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemList {

	private List<Item> li;

	public ItemList() {
		li = new ArrayList<Item>();
	}

	public List<Item> getLi() {
		return li;
	}

	public void addItem(Scanner scanner) {
		System.out.print("Item name: ");
		String name = scanner.next();
		System.out.print("Item serial number: ");
		String SerialNumber = scanner.next();
		System.out.print("Item value: ");
		BigDecimal value = scanner.nextBigDecimal();

		Item item = new Item(name, SerialNumber, value);
		getLi().add(item);
		scanner.nextLine();
		System.out.println("The item has succesfully submitted to the ItemList");
	}

}
