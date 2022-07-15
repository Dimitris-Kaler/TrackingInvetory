package intentory.kalerantes;

import formats.HtmlFormat;

public class PrintHtmlMenuItem extends MenuItem {

	public PrintHtmlMenuItem(String code, String description) {
		super(code, description);
	}

	@Override
	public void execute(ItemList list) {
		HtmlFormat htmlFormat = new HtmlFormat(list);
		System.out.println("INVETORY HTML REPORT");
		System.out.println("********************");
		System.out.println(htmlFormat.printHtml());
	}

}
