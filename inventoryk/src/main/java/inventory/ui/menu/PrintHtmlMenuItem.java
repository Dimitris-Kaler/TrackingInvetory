package inventory.ui.menu;

import java.io.PrintStream;
import java.util.Scanner;

import formats.HtmlFormat;
import inventory.kalerantes.ItemList;

public class PrintHtmlMenuItem extends MenuItem {

	private HtmlFormat htmlFormat;

	public PrintHtmlMenuItem() {
		super("2", "Print Out HTML format");
		htmlFormat = new HtmlFormat();
	}

	@Override
	public void execute(ItemList list, Scanner scanner, PrintStream out) {
		htmlFormat.setItems(list);
		out.println(headerMessage());
		out.println(htmlFormat.printHtml());
	}

	private String headerMessage() {
		return String.format("INVETORY HTML REPORT%s********************",System.lineSeparator());
	}

}