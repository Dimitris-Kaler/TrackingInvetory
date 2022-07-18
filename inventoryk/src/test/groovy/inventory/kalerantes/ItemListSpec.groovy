package inventory.kalerantes

import spock.lang.Specification

class ItemListSpec extends Specification {

	def "create item list"(){
		when:
		ItemList li=new ItemList();

		then:
		li.getLi()==new ArrayList();
	}

	def "capture user input, create an item and put it on the list"() {
		given: "item properties"
		String name = "name"
		String sn = "123456789"
		String value = "20"

		and: 'a scanner that simulates the user input'
		Scanner scanner = new Scanner(simulateUserInput(name, sn, value))

		and: 'and print stream for capturing program output'
		OutputStream captureOutput = new ByteArrayOutputStream()
		PrintStream out = new PrintStream(captureOutput)

		and: 'a new item list'
		ItemList list = new ItemList();


		when: 'adding an item'
		list.addItem(scanner, out)

		then: 'this item goes inside the list'
		list.li.size() == 1
		def item = list.li.first()
		item.name == name
		item.serialNumber == sn
		item.value == new BigDecimal(value)

		and: 'the appropriate output is captured'
		captureOutput.toString() == "Item name: Item serial number: Item value: The item has succesfully submitted to the ItemList${System.lineSeparator()}"
	}


	private def simulateUserInput(String name, String sn, String value) {
		new ByteArrayInputStream((name + System.lineSeparator() + sn + System.lineSeparator() + value).getBytes());
	}

}


