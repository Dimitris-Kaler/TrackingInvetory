package intentory.kalerantes

import formats.CsvFormat
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
		mi.messageHeader() == "INVETORY CSV REPORT\n********************"
	}

	def "when execute is called then a csv format is printed"() {
		given:
		CsvFormat mock = Mock()
		mi.csvFormatter = mock
		Scanner scanner = new Scanner(System.in)
		ItemList list = new ItemList()

		when:
		mi.execute(list, scanner)

		then:
		1 * mock.setItems(list)
		1 * mock.printCsv()

	}

}
