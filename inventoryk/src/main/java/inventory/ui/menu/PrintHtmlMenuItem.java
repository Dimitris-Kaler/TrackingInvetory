package inventory.ui.menu;

import java.io.PrintStream;
import java.util.Scanner;

import inventory.formatters.HtmlFormatter;
import inventory.items.ItemList;

public class PrintHtmlMenuItem extends MenuItem {

	private HtmlFormatter htmlFormat;

	public PrintHtmlMenuItem() {
		super("2", "Print Out HTML format");
		htmlFormat = new HtmlFormatter();
	}

	@Override
	public void execute(ItemList list, Scanner scanner, PrintStream out) {
		htmlFormat.setItems(list);
		out.println(headerMessage());
		out.println(htmlFormat.html());
	}

	private String headerMessage() {
		return String.format("INVETORY HTML REPORT%s********************", System.lineSeparator());
	}

}
