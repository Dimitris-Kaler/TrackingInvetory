package inventory.ui.menu

import inventory.files.TextFile
import inventory.formatters.HtmlFormatter
import inventory.items.ItemList
import inventory.utils.Utils
import spock.lang.Specification

class CreateHtmlFileMenuItemSpec extends Specification {

	CreateHtmlFileMenuItem mi

	def setup() {
		mi = new CreateHtmlFileMenuItem()
	}

	def "the code is 3 and the description Save Inventory To Html file"() {
		expect:
		mi.code == "3"
		mi.description == "Save Inventory To Html file"
	}

	def "when execute method is called then an html file is created"() {
		given: 'a list of items'
		ItemList list = new ItemList()

		and: 'an html formatter that return html succcesfully'
		HtmlFormatter htmlFormatterMock = Mock()
		mi.htmlFormatter = htmlFormatterMock

		and: 'a text file that writes successfuly'
		TextFile textFileMock = Mock()
		mi.textFile = textFileMock

		and: 'a Scanner'
		Scanner scanner = new Scanner(System.in)

		and: 'an output stream'
		PrintStream out = Utils.printStream()

		when: 'executing'
		mi.execute(list, scanner, out)

		then: 'the formatter is called appropriately'
		1 * htmlFormatterMock.setItems(list)
		1 * htmlFormatterMock.html() >> "html content"

		and: 'the text file is called appropriately'
		1 * textFileMock.writeText("html content")

		and: 'a success message is shown on the output'
		out.out.toString() == "HTML file created in src/main/resources/inventory.html${System.lineSeparator()}"
	}

	def "when an IOException is thrown then it is wrapped and thrown to the client for handling"() {
		given: 'a list of items'
		ItemList list = new ItemList()

		and: 'a text file that fails'
		TextFile textFileMock = Stub()
		textFileMock.writeText(_) >> {throw new IOException("Error")}
		mi.textFile = textFileMock

		when: 'executing'
		mi.execute(list, new Scanner(System.in), System.out)

		then:
		def e = thrown(RuntimeException)
		e.cause instanceof IOException
		e.message == "java.io.IOException: Error"
	}

}
