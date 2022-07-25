package inventory.ui.menu

import inventory.items.ItemList
import inventory.kalerantes.Exit
import inventory.utils.Utils
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
		ExitProgramMenuItem.MESSAGE == "BYE BYE!!!"
	}

	def "when execute method is called then a call to the method that exits is made"() {
		given:
		Exit mock = Mock()
		mi.exit = mock
		Scanner scanner = new Scanner(System.in)
		ItemList list = new ItemList()

		and: "an and output stream"
		PrintStream out = Utils.printStream()

		when:
		mi.execute(list, scanner, out)

		then:
		1 * mock.doIt()
		out.out.toString() == "BYE BYE!!!${System.lineSeparator()}"
	}

}
