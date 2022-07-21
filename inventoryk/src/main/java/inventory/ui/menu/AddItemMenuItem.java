package inventory.ui.menu;

import java.io.PrintStream;
import java.util.Scanner;

import inventory.kalerantes.Item;
import inventory.kalerantes.ItemCLIParser;
import inventory.kalerantes.ItemList;

public class AddItemMenuItem extends MenuItem {

	ItemCLIParser parser;

	public AddItemMenuItem() {
		this(new ItemCLIParser());
	}

	public AddItemMenuItem(ItemCLIParser parser) {
		super("1", "Add Item");
		this.parser = parser;
	}

	@Override
	public void execute(ItemList list, Scanner scanner, PrintStream out) {
		//TODO why do you need that line?
		scanner.nextLine();
		try {
			Item item = parser.parseItem(scanner, out);
			list.addItem(item);
			//TODO why do you need that line?
//		scanner.nextLine();
			out.println("The item has succesfully submitted to the ItemList");
		} catch (Exception e) {
			if (e.getMessage() != null)
				out.println(e.getMessage());
			else
				out.println("Unexpected Error: " + e.getClass().toString());
		}
	}

}
