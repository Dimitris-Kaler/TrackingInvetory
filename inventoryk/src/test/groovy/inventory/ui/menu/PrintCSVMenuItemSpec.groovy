package inventory.ui.menu

import formats.CsvFormat
import inventory.items.ItemList
import inventory.utils.Utils
import spock.lang.Specification

class PrintCSVMenuItemSpec extends Specification {

	PrintCSVMenuItem mi

	def setup() {
		mi = new PrintCSVMenuItem()
	}

	def "the code is 4 and the description Print Out Csv format"() {
		expect:
		mi.code == "4"
		mi.description == "Print Out Csv format"
	}

	def "message header"() {
		expect:
		mi.messageHeader() == "INVETORY CSV REPORT${System.lineSeparator()}********************"
	}

	def "when execute is called then a csv format is printed"() {
		given:
		CsvFormat mock = Mock()
		mi.csvFormatter = mock
		Scanner scanner = new Scanner(System.in)
		ItemList list = new ItemList()

		and: "an and output stream"
		PrintStream out =  Utils.printStream()

		when:
		mi.execute(list, scanner, out)

		then:
		1 * mock.setItems(list)
		1 * mock.printCsv() >> "csv"
		out.out.toString() == "INVETORY CSV REPORT${System.lineSeparator()}********************${System.lineSeparator()}csv${System.lineSeparator()}"
	}

}
