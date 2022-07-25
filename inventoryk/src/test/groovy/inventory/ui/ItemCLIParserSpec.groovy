package inventory.ui

import inventory.items.Item
import inventory.ui.exceptions.ValueNotNumeric
import inventory.utils.Utils
import spock.lang.Specification

class ItemCLIParserSpec extends Specification {

	def "capture user input, create an item and put it on the list"() {
		given: "item properties"
		String name = "name"
		String sn = "123456789"
		String value = "20"

		and: 'a scanner that simulates the user input'
		Scanner scanner = new Scanner(simulateUserInput(name, sn, value))

		and: 'and print stream for capturing program output'
		PrintStream out = Utils.printStream()

		when: 'parsing an item'
		Item item = new ItemCLIParser().parseItem(scanner, out)

		then: 'this item goes inside the list'
		item.name == name
		item.serialNumber == sn
		item.value == new BigDecimal(value)

		and: 'the appropriate output is captured'
		out.out.toString() == "Item name: Item serial number: Item value: "
	}

	def "no numeric value for item's value"() {
		given: 'a scanner that simulates the user input'
		Scanner scanner = new Scanner(simulateUserInput("name", "123456789", "abc"))

		when: 'parsing an item'
		Item item = new ItemCLIParser().parseItem(scanner, Utils.printStream())

		then:
		def e = thrown(ValueNotNumeric)
		e.message == "Expected numeric value for item's value but got 'abc' instead"

		and: "the scanner buffer is empty - the abc value is removed"
		boolean flag = false;
		try {
			scanner.next()
		}
		catch(NoSuchElementException e1) {
			flag = true
		}
		assert flag

	}

	private def simulateUserInput(String name, String sn, String value) {
		new ByteArrayInputStream((name + System.lineSeparator() + sn + System.lineSeparator() + value).getBytes());
	}

}
