package intentory.kalerantes;

import java.util.Scanner;

import formats.HtmlFormat;

public class PrintHtmlMenuItem extends MenuItem {

	public PrintHtmlMenuItem() {
		super("2", "Print Out HTML format");
	}

	@Override
	public void execute(ItemList list, Scanner scanner) {
		HtmlFormat htmlFormat = new HtmlFormat(list);
		System.out.println(headerMessage());
		System.out.println(htmlFormat.printHtml());
	}

	private String headerMessage() {
		return "INVETORY HTML REPORT\n********************";
	}

}
