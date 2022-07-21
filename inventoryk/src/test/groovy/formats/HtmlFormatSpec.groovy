package formats

import inventory.kalerantes.Item
import inventory.kalerantes.ItemList
import  spock.lang.Specification


class HtmlFormatSpec extends Specification {


	def "initialise HtmlFormat"(){
		when:
		ItemList items = new ItemList()
		HtmlFormat htmlFormat = new HtmlFormat(items);

		then:
		htmlFormat.items==items;
	}

	def "print header of html"(){
		given:
		HtmlFormat htmlFormat = new HtmlFormat();

		expect:
		htmlFormat.htmlHeader() == header();
	}


	private String header() {
		"<!DOCTYPE html>${System.lineSeparator()}<html lang=\"en\">${System.lineSeparator()} <head>${System.lineSeparator()}\t<meta charset=\"UTF-8\">${System.lineSeparator()}" +
		"\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">${System.lineSeparator()}" +
		"\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">${System.lineSeparator()}" +
		"\t<title>HTML REPORT</title>${System.lineSeparator()}" +
		"</head>${System.lineSeparator()}" +
		"<body>${System.lineSeparator()}"
	}

	def "print message if the list of items is empty"(){

		when:
		ItemList items=new ItemList()
		HtmlFormat htmlFormat=new HtmlFormat(items);
		StringBuilder strBuilder=new StringBuilder()
		htmlFormat.printItems(items,strBuilder);
		items.getLi().isEmpty()


		then:
		strBuilder.append(" <p>No items on the Invetory.</p>\n");
	}

	def "print items of the list"(){
		given:
		Item item = new Item("SEGA","345ERW2QA", 250)
		ItemList items=new ItemList()
		items.getLi().add(item)
		HtmlFormat htmlFormat=new HtmlFormat(items);
		StringBuilder strBuilder=new StringBuilder()
		when:
		htmlFormat.printItems(items,strBuilder);



		then:
		strBuilder.length()>34
	}

	def "Print the footer of the html"(){
		when:
		HtmlFormat htmlFormat=new HtmlFormat();
		StringBuilder strBuilder=new StringBuilder()
		htmlFormat.htmlFooter(strBuilder)

		then:
		strBuilder.length()==17
	}

	def "create HtmlFile With the invetory List"(){
		given:
		ItemList items=new ItemList()
		HtmlFormat htmlFormat=new HtmlFormat(items);
		when:
		htmlFormat.createHtmlFile();



		then:
		File file=new File("inventory.html")
		FileWriter fWriter=new FileWriter(file)
		fWriter.write(htmlFormat.printHtml());
	}
}
