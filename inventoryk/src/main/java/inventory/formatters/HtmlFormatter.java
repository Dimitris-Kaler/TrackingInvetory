package inventory.formatters;

import java.util.stream.Collectors;

import inventory.items.Item;
import inventory.items.ItemList;

public class HtmlFormatter {

	private static final String LINE_SEP = System.lineSeparator();
	private static final String TABLE_STYLE = "'margin:auto;border-top:2px solid blue;border-bottom:2px solid blue;text-align:center;width:300px;'";
	private static final String HEADER_STYLE = "'border-bottom:1px solid blue'";
	private ItemList items;

	public HtmlFormatter() {
		this.items = new ItemList();
	}

	public HtmlFormatter(ItemList items) {
		this.items = items;
	}

	public void setItems(ItemList items) {
		this.items = items;
	}

	public ItemList getItems() {
		return items;
	}

	public String html() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(header());
		strBuilder.append(formattedItems());
		strBuilder.append(footer());
		return strBuilder.toString();
	}

	private String header() {
		String line1 = String.format("<!DOCTYPE html>%s<html lang=\"en\">%s <head>%s", LINE_SEP, LINE_SEP, LINE_SEP);
		String line2 = String.format("\t<meta charset=\"UTF-8\">%s", LINE_SEP);
		String line3 = String.format("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">%s", LINE_SEP);
		String line4 = String.format("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">%s", LINE_SEP);
		String line5 = String.format("\t<title>HTML REPORT</title>%s</head>%s<body>%s", LINE_SEP, LINE_SEP, LINE_SEP);
		return String.format("%s%s%s%s%s", line1, line2, line3, line4, line5);
	}

	private String formattedItems() {
		if (!items.getList().isEmpty())
			return table(String.format("\t%s%s\t%s", tableHeader(), LINE_SEP, tableRows()));

		return String.format("\t<p>No items on the Invetory.</p>%s", LINE_SEP);
	}

	private String footer() {
		return String.format("\t</body>%s</html>%s", LINE_SEP, LINE_SEP);
	}

	private String table(String content) {
		return String.format("<table style=%s>%s%s%s</table>", TABLE_STYLE, LINE_SEP, content, LINE_SEP);
	}

	private String tableHeader() {
		return String.format("<thead style=%s>%s</thead>", HEADER_STYLE, row(cellHeaders()));
	}

	private String tableRows() {
		return String.format("<tbody>%s</tbody>", lineItems());
	}

	private String lineItems() {
		return getItems().
				getList().
				stream().
				map(item -> row(cells(item)))
				.collect(Collectors.joining(""));
	}

	private String row(String content) {
		return String.format("<tr>%s</tr>", content);
	}

	private String cellHeaders() {
		 return String.format("%s%s%s", th("Name"), th("Serial Number"), th("Value"));
	}

	private String th(String content) {
		return String.format("<th>%s</th>", content);
	}

	private String cells(Item item) {
		return String.format("%s%s%s", cell(item.getName()), cell(item.getSerialNumber()), cell(item.getValue().toString()));
	}

	private String cell(String content) {
		return String.format("<td>%s</td>", content);
	}

}
