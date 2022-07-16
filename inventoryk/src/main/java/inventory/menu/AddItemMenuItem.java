package inventory.menu;

import java.util.Scanner;

import inventory.kalerantes.ItemList;

public class AddItemMenuItem extends MenuItem {

	public AddItemMenuItem() {
		super("1", "Add Item");
	}

	@Override
	public void execute(ItemList list, Scanner scanner) {
		scanner.nextLine();
		list.addItem(scanner);
	}

}
