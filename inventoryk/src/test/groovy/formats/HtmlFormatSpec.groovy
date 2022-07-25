package formats

import inventory.kalerantes.Item
import inventory.kalerantes.ItemList
import  spock.lang.Specification


class HtmlFormatSpec extends Specification {

	ItemList items

	def setup() {
		items = new ItemList()
	}


	def "initialise HtmlFormat"(){
		when:
		HtmlFormat htmlFormat = new HtmlFormat(items);

		then:
		htmlFormat.items == items;
	}

	def "header of html"(){
		given:
		HtmlFormat htmlFormat = new HtmlFormat();

		expect:
		htmlFormat.htmlHeader() == header();
	}

	def "message if the list of items is empty"(){
		given:
		HtmlFormat htmlFormat = new HtmlFormat();
		StringBuilder strBuilder = new StringBuilder()

		expect:
		htmlFormat.printItems() == " <p>No items on the Invetory.</p>\n"
	}

	def "items of the list"() {
		given:
		Item item = new Item("SEGA", "345ERW2QA", 250)
		items.getLi().add(item)
		HtmlFormat htmlFormat = new HtmlFormat(items);

		expect:
		htmlFormat.printItems() ==  tableItems();
	}

	def "html footer"(){
		given:
		HtmlFormat htmlFormat = new HtmlFormat();

		expect:
		htmlFormat.htmlFooter() == footer()
	}

	private String header() {
		"<!DOCTYPE html>${System.lineSeparator()}<html lang=\"en\">${System.lineSeparator()} <head>${System.lineSeparator()}\t<meta charset=\"UTF-8\">${System.lineSeparator()}" +
		"\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">${System.lineSeparator()}" +
		"\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">${System.lineSeparator()}" +
		"\t<title>HTML REPORT</title>${System.lineSeparator()}" +
		"</head>${System.lineSeparator()}" +
		"<body>${System.lineSeparator()}"
	}

	private String tableItems() {
		"<table style='margin:auto;border-top:2px solid blue;border-bottom:2px solid blue;text-align:center;width:300px;'>${System.lineSeparator()}" +
		"\t<thead style='border-bottom:1px solid blue'><tr><th>Name</th><th>Serial Number</th><th>Value</th></tr></thead>${System.lineSeparator()}" +
		"\t<tbody><tr><td>SEGA</td><td>345ERW2QA</td><td>250</td></tr></tbody>${System.lineSeparator()}" +
		"</table>"
	}

	private String footer() {
		"\t</body>${System.lineSeparator()}</html>${System.lineSeparator()}"
	}

	def "create HtmlFile With the invetory List"(){
		given:
		HtmlFormat htmlFormat=new HtmlFormat(items);
		when:
		htmlFormat.createHtmlFile();

		then:
		File file=new File("inventory.html")
		FileWriter fWriter=new FileWriter(file)
		fWriter.write(htmlFormat.printHtml());
	}
}
