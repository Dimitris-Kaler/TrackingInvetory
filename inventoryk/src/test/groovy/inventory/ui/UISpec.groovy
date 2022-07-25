package inventory.ui

import inventory.ui.menu.CLIMenuChoiceValidator
import inventory.ui.menu.Menu
import inventory.ui.menu.MenuItem
import inventory.utils.Utils
import spock.lang.Specification

class UISpec extends Specification {

	UI ui
	PrintStream out
	PrintStream err

	def setup() {
		ui = new UI()
		out = Utils.printStream()
		err = Utils.printStream()
	}

	def prompt() {
		when: "prompting"
		ui.prompt(out)

		then: 'the appropriate message is displayed'
		out.out.toString() == "Enter choice: ${System.lineSeparator()}"
	}

	def printMenuOptions() {
		given: "a menu"
		ui = new UI(menuStub())

		when: "printing the menu options"
		ui.printMenuOptions(out)

		then: "those option as displayed in the output stream"
		out.out.toString() == options() + System.lineSeparator()
	}

	def "parse input with valid choice"() {
		given: "a valid menu choice"
		String validChoice = "1"
		Scanner scanner = menuChoices([validChoice])

		and: "the validation will succeed"
		CLIMenuChoiceValidator successValidatorStub = Stub()
		ui.cliMenuChoiceValidator = successValidatorStub

		when: "parsing"
		String choice = ui.parseInputFromCommandLine(scanner, out, err)

		then: "the valid choice is captured"
		choice == validChoice

		and: "nothing is displayed in the output stream"
		out.out.toString() == ""

		and: "nothing is displayed in the error stream"
		err.out.toString() == ""
	}

	def "parse invalid input"() {
		given: "an invalid choice"
		String invalidChoice = "a"

		and: "then a valid choice"
		String validChoice = "1"
		Scanner scanner = menuChoices([invalidChoice, validChoice])

		when: "parsing"
		String choice = ui.parseInputFromCommandLine(scanner, out, err)

		then: "the final choice is the valid choice"
		choice == validChoice

		and: "no exception is thrown"
		notThrown(Exception)

		and: "the error message of the invalid choice is captured"
		err.out.toString() == "Expected value between 1 and 6 but got a instead.${System.lineSeparator()}"

		and: "the user was asked to re-enter a valid choice"
		out.out.toString() == "Enter choice: ${System.lineSeparator()}"
	}

	def captureAndProcessMenuChoice() {
		given: "a valid choice"
		String choice = "1"
		Scanner scanner = menuChoices([choice])

		Menu menuMock = Mock()
		ui.menu = menuMock
		MenuItem menuItemMock = Mock()

		when: 'capturing and processing the menu choice'
		ui.captureAndProcessMenuChoice(scanner, out, err)

		then: "menu options is called"
		1 * menuMock.options() >> options()

		and: "find by code returns the appropriate menu item"
		1 * menuMock.findByCode(choice) >>  menuItemMock

		and: "the menu item is executed"
		1 * menuItemMock.execute(ui.list, scanner, out)

		and: 'menu options and prompt are displayed in output stream'
		out.out.toString() == "${options()}${System.lineSeparator()}Enter choice: ${System.lineSeparator()}"

		and: 'no error message displated in the error stream'
		err.out.toString() == ""
	}

	def 'handle exception thrown from Menu Item execution' () {
		given: "a valid choice"
		String choice = "1"
		Scanner scanner = menuChoices([choice])

		and:
		MenuItem menuItemStub = Stub()
		menuItemStub.execute(_, _, _) >> { throw new RuntimeException("fail")}

		and:
		Menu menuStub = Stub()
		menuStub.findByCode(_) >> menuItemStub
		menuStub.options() >> options()
		ui.menu = menuStub

		when: 'capturing and processing the menu choice'
		ui.captureAndProcessMenuChoice(scanner, out, err)

		then: 'no exception is thrown to the UI'
		notThrown(Exception)

		and: 'an error message is displayed in the error stream'
		err.out.toString() == "Unexpected error: class java.lang.RuntimeException: fail${System.lineSeparator()}"

		and: 'the program prints again the menu and asks for new input'
		out.out.toString() == "${options()}${System.lineSeparator()}Enter choice: ${System.lineSeparator()}"
	}

	private Menu menuStub() {
		Menu menu = Stub()
		menu.options() >> options()
		menu
	}

	private String options() {
		"option1${System.lineSeparator()}option2"
	}

	//this method might me useful in other specs
	private Scanner menuChoices(def choices) {
		def userKeys = choices.join(System.lineSeparator()) + System.lineSeparator()
		new Scanner(new ByteArrayInputStream(userKeys.getBytes()))
	}

}
