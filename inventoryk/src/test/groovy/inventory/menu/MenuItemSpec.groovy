package inventory.menu

import inventory.kalerantes.Item
import inventory.kalerantes.ItemCLIParser
import inventory.kalerantes.ItemList
import spock.lang.Specification

class MenuItemSpec extends Specification {

	def mi

	public void setup() {
		mi = new AddItemMenuItem();
	}

	def "it has a code and a description" () {
		expect:
		mi.code == "1"
		mi.description == "Add Item"
	}

	def execute() {
		given: "an item list"
		ItemList list = new ItemList()

		and: "a parser that returns an item successfully"
		ItemCLIParser mock = Mock()
		Item item = item()
		mi = new AddItemMenuItem(mock);

		and: "a simulated user input"
		def input = new ByteArrayInputStream((System.lineSeparator()).getBytes());
		Scanner scanner = new Scanner(input)

		and:
		PrintStream out = Mock()

		when: "executing the menu item"
		mi.execute(list, scanner, out)

		then: "the parser is called with the appropriate input"
		1 * mock.parseItem(scanner, out) >>  item

		and: "the parsed item lives inside the item list"
		list.li.size() == 1
		list.li.first() == item

		and: "a successful message is returned to the output"
		1 * out.println("The item has succesfully submitted to the ItemList")
	}

	private Item item() {
		new Item("name", "123456789", 20)
	}

}
