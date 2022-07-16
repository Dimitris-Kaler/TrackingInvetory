package inventory.kalerantes

import inventory.kalerantes.Exit
import inventory.kalerantes.ExitProgramMenuItem
import inventory.kalerantes.ItemList
import spock.lang.Specification

class ExitProgramMenuItemSpec extends Specification {

	ExitProgramMenuItem mi

	def setup() {
		mi = new ExitProgramMenuItem()
	}

	def "the code is 6 and the description Exit The program"() {
		expect:
		mi.code == "6"
		mi.description == "Exit The program"
	}

	def 'message says BYE BYE!!!'() {
		expect:
		mi.message() == "BYE BYE!!!"
	}

	def "when execute method is called then a call to the method that exits is made"() {
		given:
		Exit mock = Mock()
		mi.exit = mock
		Scanner scanner = new Scanner(System.in)
		ItemList list = new ItemList()

		when:
		mi.execute(list, scanner)

		then:
		1 * mock.doIt()
	}


}
