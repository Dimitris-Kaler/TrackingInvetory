package formats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import intentory.kalerantes.Item;
import intentory.kalerantes.ItemList;

public class HtmlFormat {

	private ItemList items;

	public HtmlFormat() {
		this.items = new ItemList();
	}

	public HtmlFormat(ItemList items) {
		this.items = items;
	}

	public void setItems(ItemList items) {
		this.items = items;
	}

	public ItemList getItems() {
		return items;
	}

	public String printHtml() {
		StringBuilder strBuilder = new StringBuilder();
		htmlHeader(strBuilder);
		printItems(getItems(), strBuilder);
		htmlFooter(strBuilder);
		return strBuilder.toString();

	}

	public void htmlHeader(StringBuilder sbuilder) {
		final String HTMLSTRING = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>HTML REPORT</title>\r\n" + "</head>\r\n" + "<body>\r\n";

		sbuilder.append(HTMLSTRING);
	}

	public void printItems(ItemList list, StringBuilder sbuilder) {
		if (list.getLi().size() == 0) {
			sbuilder.append(" <p>No items on the Invetory.</p>\n");
		} else {
			sbuilder.append(
					" <table style='margin:auto;border-top:2px solid blue;border-bottom:2px solid blue;text-align:center;width:300px;'>\n"
							+ "  <thead style='border-bottom:1px solid blue'>\n" + "   <tr>\n" + "    <th>name</th>\n"
							+ "    <th>serialNumber</th>\n" + "    <th>value</th>\n" + "   </tr>\n");
			appendListItems(sbuilder);

		}
	}

	private void appendListItems(StringBuilder sbuilder) {
		for (Item item : getItems().getLi()) {
			String str = "   <tr>\n" + "    <td>" + item.getName() + "</td>\n" + "    <td>" + item.getSerialNumber()
					+ "</td>\n" + "    <td>" + item.getValue() + "</td>\n" + "   </tr>\n";
			sbuilder.append(str);
		}
		sbuilder.append("  <tbody>\n </table>\n");
	}

	public void htmlFooter(StringBuilder sbuilder) {
		final String HTMLSTRING = "</body>\r\n" + "</html>\n";

		sbuilder.append(HTMLSTRING);

	}

	public void createHtmlFile() {
		File file = new File("inventory.html");
		try (FileWriter fWriter = new FileWriter(file)) {
			fWriter.write(printHtml());
			System.out.println("HTML File created!");

		} catch (IOException e) {
			System.out.println(e);

		}
	}

}
