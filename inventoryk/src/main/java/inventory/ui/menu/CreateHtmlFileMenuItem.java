package inventory.ui.menu;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import formats.HtmlFormatter;
import inventory.files.TextFile;
import inventory.kalerantes.ItemList;

public class CreateHtmlFileMenuItem extends MenuItem {

	private static final String HTML_FILE_PATH = "src/main/resources/inventory.html";
	private HtmlFormatter htmlFormatter;
	private TextFile textFile;

	public CreateHtmlFileMenuItem() {
		super("3", "Save Inventory To Html file");
		htmlFormatter = new HtmlFormatter();
		textFile = new TextFile(HTML_FILE_PATH);
	}

	@Override
	public void execute(ItemList list, Scanner scanner, PrintStream out) {
		htmlFormatter.setItems(list);
		String html = htmlFormatter.html();
		try {
			textFile.writeText(html);
			out.println(String.format("HTML file created in %s", HTML_FILE_PATH));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
