package inventory.kalerantes;

import java.util.Scanner;

import formats.JsonFormat;

public class SaveJSONFileMenuItem extends MenuItem {

	private JsonFormat jsonFormat;

	public SaveJSONFileMenuItem() {
		super("5", "Save Inventory to Json file");
		jsonFormat = new JsonFormat();
	}

	@Override
	public void execute(ItemList list, Scanner scanner) {
		jsonFormat.setItems(list);
		jsonFormat.createFileWithJsonFormat();
	}

}
