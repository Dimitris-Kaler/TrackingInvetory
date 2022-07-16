package intentory.kalerantes;

import java.util.Scanner;

import formats.HtmlFormat;

public class CreateHtmlFileMenuItem extends MenuItem {

	public CreateHtmlFileMenuItem() {
		super("3", "Save Inventory To Html file");
	}

	@Override
	public void execute(ItemList list, Scanner scanner) {
		HtmlFormat htmlformatter = new HtmlFormat(list);
		//TODO formatter and saving file are 2 different things
		htmlformatter.createHtmlFile();
	}

}
