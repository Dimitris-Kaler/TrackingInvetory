package inventory.ui.menu;

import java.io.PrintStream;
import java.util.Scanner;

import formats.HtmlFormatter;
import inventory.kalerantes.ItemList;

public class CreateHtmlFileMenuItem extends MenuItem {

	private HtmlFormatter htmlFormatter;

	public CreateHtmlFileMenuItem() {
		super("3", "Save Inventory To Html file");
		htmlFormatter = new HtmlFormatter();
	}

	@Override
	public void execute(ItemList list, Scanner scanner, PrintStream out) {
		htmlFormatter.setItems(list);
		//TODO formatter and saving file are 2 different things
		htmlFormatter.createHtmlFile();
	}

}
