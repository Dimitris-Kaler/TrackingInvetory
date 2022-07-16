package intentory.kalerantes;

import java.util.Scanner;

import formats.JsonFormat;

public class SaveJSONFileMenuItem extends MenuItem {

	public SaveJSONFileMenuItem() {
		super("5", "Save Inventory to Json file");
	}

	@Override
	public void execute(ItemList list, Scanner scanner) {
		JsonFormat jFormat = new JsonFormat(list);
		//TODO this one fails
		jFormat.createFileWithJsonFormat();
	}

}
