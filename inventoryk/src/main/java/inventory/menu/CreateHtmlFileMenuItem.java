package inventory.menu;

import java.util.Scanner;

import formats.HtmlFormat;
import inventory.kalerantes.ItemList;

public class CreateHtmlFileMenuItem extends MenuItem {

	private HtmlFormat htmlFormatter;

	public CreateHtmlFileMenuItem() {
		super("3", "Save Inventory To Html file");
		htmlFormatter = new HtmlFormat();
	}

	@Override
	public void execute(ItemList list, Scanner scanner) {
		htmlFormatter.setItems(list);
		//TODO formatter and saving file are 2 different things
		htmlFormatter.createHtmlFile();
	}

}
