package inventory.ui

import exceptions.ValueNotNumeric
import inventory.kalerantes.Item
import inventory.ui.ItemCLIParser
import spock.lang.Specification

class ItemCLIParserSpec extends Specification {

	def "capture user input, create an item and put it on the list"() {
		//TODO a big part of this test is duplicated but I think that add item method is going to be deleted
		//so I will handle it later
		given: "item properties"
		String name = "name"
		String sn = "123456789"
		String value = "20"

		and: 'a scanner that simulates the user input'
		Scanner scanner = new Scanner(simulateUserInput(name, sn, value))

		and: 'and print stream for capturing program output'
		OutputStream captureOutput = new ByteArrayOutputStream()
		PrintStream out = new PrintStream(captureOutput)

		when: 'parsing an item'
		Item item = new ItemCLIParser().parseItem(scanner, out)


		then: 'this item goes inside the list'
		item.name == name
		item.serialNumber == sn
		item.value == new BigDecimal(value)

		and: 'the appropriate output is captured'
		captureOutput.toString() == "Item name: Item serial number: Item value: "
	}

	def "no numeric value for item's value"() {
		given:
		String name = "name"
		String sn = "123456789"
		String value = "abc"

		and: 'a scanner that simulates the user input'
		Scanner scanner = new Scanner(simulateUserInput(name, sn, value))

		and: 'and print stream for capturing program output'
		OutputStream captureOutput = new ByteArrayOutputStream()
		PrintStream out = new PrintStream(captureOutput)

		when: 'parsing an item'
		Item item = new ItemCLIParser().parseItem(scanner, out)

		then:
		def e = thrown(ValueNotNumeric)
		e.message == "Expected numeric value for item's value but got 'abc' instead"
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
