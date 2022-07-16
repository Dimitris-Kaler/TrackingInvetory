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
		System.out.println("INVETORY HTML REPORT");
		System.out.println("********************");
		System.out.println(htmlFormat.printHtml());
	}

}
