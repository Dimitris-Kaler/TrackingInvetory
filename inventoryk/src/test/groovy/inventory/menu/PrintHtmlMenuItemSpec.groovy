package inventory.menu

import formats.HtmlFormat
import inventory.kalerantes.ItemList
import spock.lang.Specification

class PrintHtmlMenuItemSpec extends Specification {

	PrintHtmlMenuItem mi

	def setup() {
		mi = new PrintHtmlMenuItem()
	}

	def "the code is 2 and the description Print Out HTML format"() {
		expect:
		mi.code == "2"
		mi.description == "Print Out HTML format"
	}

	def "header message"() {
		expect:
		mi.headerMessage() == "INVETORY HTML REPORT\n********************"
	}

	def "when calling execute then htmlFormat printHtml method is called"() {
		given:
		HtmlFormat htmlMock = Mock(HtmlFormat)
		Scanner scanner = new Scanner(System.in)
		ItemList list = new ItemList()
		mi.htmlFormat = htmlMock

		when:
		mi.execute(list, scanner, System.out) //TODO capture and assert the output

		then:
		1 * htmlMock.setItems(list)
		1 * htmlMock.printHtml()
	}


}
