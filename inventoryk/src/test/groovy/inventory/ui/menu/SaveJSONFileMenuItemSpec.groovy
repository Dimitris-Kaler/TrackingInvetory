package inventory.ui.menu

import formats.JsonFormat
import inventory.items.ItemList
import inventory.ui.menu.SaveJSONFileMenuItem
import spock.lang.Specification

class SaveJSONFileMenuItemSpec extends Specification {

	SaveJSONFileMenuItem mi

	def setup() {
		mi = new SaveJSONFileMenuItem()
	}

	def "the code is 5 and the description Save Inventory to Json file"() {
		expect:
		mi.code == "5"
		mi.description == "Save Inventory to Json file"
	}

	def "when execute is called it create a json file"() {
		given:
		JsonFormat mock = Mock()
		mi.jsonFormat = mock
		Scanner scanner = new Scanner(System.in)
		ItemList list = new ItemList()

		when:
		mi.execute(list, scanner, System.out) //TODO capture and assert the output

		then:
		1 * mock.setItems(list)
		1 * mock.createFileWithJsonFormat()
	}

}
