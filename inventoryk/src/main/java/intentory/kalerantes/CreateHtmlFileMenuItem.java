package intentory.kalerantes;

import java.util.Scanner;

import formats.HtmlFormat;

public class CreateHtmlFileMenuItem extends MenuItem {

	public CreateHtmlFileMenuItem(String code, String description) {
		super(code, description);
	}

	@Override
	public void execute(ItemList list, Scanner scanner) {
		HtmlFormat htmlformatter = new HtmlFormat(list);
		//TODO formatter and saving file are 2 different things
		htmlformatter.createHtmlFile();
	}

}
