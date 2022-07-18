package inventory.menu;

import java.io.PrintStream;
import java.util.Scanner;

import inventory.kalerantes.Item;
import inventory.kalerantes.ItemCLIParser;
import inventory.kalerantes.ItemList;

public class AddItemMenuItem extends MenuItem {

	public AddItemMenuItem() {
		super("1", "Add Item");
	}

	@Override
	public void execute(ItemList list, Scanner scanner, PrintStream out) {
		scanner.nextLine();
		Item item = new ItemCLIParser().parseItem(scanner, out);
		list.addItem(item);
		//TODO why do you need that line?
//		scanner.nextLine();
		out.println("The item has succesfully submitted to the ItemList");
	}

}
