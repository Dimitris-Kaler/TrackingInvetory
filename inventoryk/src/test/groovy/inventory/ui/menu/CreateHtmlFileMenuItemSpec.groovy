package inventory.ui.menu

import formats.HtmlFormat
import inventory.kalerantes.ItemList
import inventory.ui.menu.CreateHtmlFileMenuItem
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
		given:
		HtmlFormat mock = Mock()
		mi.htmlFormatter = mock
		Scanner scanner = new Scanner(System.in)
		ItemList list = new ItemList()

		when:
		mi.execute(list, scanner, System.out) //TODO capture and assert the output

		then:
		1 * mock.setItems(list)
		1 * mock.createHtmlFile()
	}

}
