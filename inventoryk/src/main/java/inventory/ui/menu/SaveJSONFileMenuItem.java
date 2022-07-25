package inventory.ui.menu;

import java.io.PrintStream;
import java.util.Scanner;

import formats.JsonFormat;
import inventory.items.ItemList;

public class SaveJSONFileMenuItem extends MenuItem {

	private JsonFormat jsonFormat;

	public SaveJSONFileMenuItem() {
		super("5", "Save Inventory to Json file");
		jsonFormat = new JsonFormat();
	}

	@Override
	public void execute(ItemList list, Scanner scanner, PrintStream out) {
		jsonFormat.setItems(list);
		jsonFormat.createFileWithJsonFormat();
	}

}
