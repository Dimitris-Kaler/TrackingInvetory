package inventory.ui

import inventory.ui.UI
import inventory.ui.menu.CLIMenuChoiceValidator
import inventory.ui.menu.Menu
import inventory.ui.menu.MenuItem
import spock.lang.Specification

class UISpec extends Specification {

	UI ui

	def setup() {
		ui = new UI()
	}

	def prompt() {
		given: 'an output stream'
		PrintStream out = new PrintStream(new ByteArrayOutputStream())

		when: "prompting"
		ui.prompt(out)

		then: 'the appropriate message is displayed'
		out.out.toString() == "Enter choice: ${System.lineSeparator()}"
	}

	def printMenuOptions() {
		given: "a menu"
		ui = new UI(menuStub())

		and: 'and an output stream'
		PrintStream out = new PrintStream(new ByteArrayOutputStream())

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

		and: "an and output stream"
		PrintStream out = new PrintStream(new ByteArrayOutputStream())

		and: "an error stream"
		PrintStream err = new PrintStream(new ByteArrayOutputStream())

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

		and: "an and output stream"
		PrintStream out = new PrintStream(new ByteArrayOutputStream())

		and: "an error stream"
		PrintStream err = new PrintStream(new ByteArrayOutputStream())

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

	def doIt() {
		given: "a valid choice"
		String choice = "1"
		Scanner scanner = menuChoices([choice])

		Menu menuStub = Mock()
		ui.menu = menuStub
		MenuItem menuItemMock = Mock()

		and: "an and output stream"
		PrintStream out = new PrintStream(new ByteArrayOutputStream())

		and: "an error stream"
		PrintStream err = new PrintStream(new ByteArrayOutputStream())

		when: 'capturing and processing the menu choice'
		ui.captureAndProcessMenuChoice(scanner, out, err)

		then: "menu options is called"
		1 * menuStub.options() >> options()

		and: "find by code returns the appropriate menu item"
		1 * menuStub.findByCode(choice) >>  menuItemMock

		and: "the menu item is executed"
		1 * menuItemMock.execute(ui.list, scanner, out)

		and: 'menu options and prompt are displayed in output stream'
		out.out.toString() == "${options()}${System.lineSeparator()}Enter choice: ${System.lineSeparator()}"

		and: 'no error message displated in the error stream'
		err.out.toString() == ""
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