package formats

import inventory.kalerantes.Item
import inventory.kalerantes.ItemList
import  spock.lang.Specification


class HtmlFormatterSpec extends Specification {

	ItemList items

	def setup() {
		items = new ItemList()
	}

	def "initialise formatter"(){
		when:
		HtmlFormatter formatter = new HtmlFormatter(items);

		then:
		formatter.items == items;
	}

	def "header of html"(){
		given:
		HtmlFormatter formatter = new HtmlFormatter();

		expect:
		formatter.header() == expectedHeader();
	}

	def "message if the list of items is empty"(){
		given:
		HtmlFormatter formatter = new HtmlFormatter();

		expect:
		formatter.formattedItems() == "\t<p>No items on the Invetory.</p>${System.lineSeparator()}"
	}

	//TODO Should you test many??
	def "items of the list"() {
		given:
		Item item = new Item("SEGA", "345ERW2QA", 250)
		//TODO law of Demeter violation
		items.getList().add(item)
		HtmlFormatter formatter = new HtmlFormatter(items);

		expect:
		formatter.formattedItems() ==  expectedTableItems();
	}

	def "html footer"(){
		given:
		HtmlFormatter formatter = new HtmlFormatter();

		expect:
		formatter.footer() == expectedFooter()
	}

	private String expectedHeader() {
		"<!DOCTYPE html>${System.lineSeparator()}<html lang=\"en\">${System.lineSeparator()} <head>${System.lineSeparator()}\t<meta charset=\"UTF-8\">${System.lineSeparator()}" +
		"\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">${System.lineSeparator()}" +
		"\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">${System.lineSeparator()}" +
		"\t<title>HTML REPORT</title>${System.lineSeparator()}" +
		"</head>${System.lineSeparator()}" +
		"<body>${System.lineSeparator()}"
	}

	private String expectedTableItems() {
		"<table style='margin:auto;border-top:2px solid blue;border-bottom:2px solid blue;text-align:center;width:300px;'>${System.lineSeparator()}" +
		"\t<thead style='border-bottom:1px solid blue'><tr><th>Name</th><th>Serial Number</th><th>Value</th></tr></thead>${System.lineSeparator()}" +
		"\t<tbody><tr><td>SEGA</td><td>345ERW2QA</td><td>250</td></tr></tbody>${System.lineSeparator()}" +
		"</table>"
	}

	private String expectedFooter() {
		"\t</body>${System.lineSeparator()}</html>${System.lineSeparator()}"
	}

}
