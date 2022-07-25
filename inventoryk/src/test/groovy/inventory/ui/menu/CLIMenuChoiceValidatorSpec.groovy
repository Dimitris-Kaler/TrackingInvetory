package inventory.ui.menu

import inventory.ui.exceptions.InvalidMenuChoice
import spock.lang.Specification
import spock.lang.Unroll

class CLIMenuChoiceValidatorSpec extends Specification {

	CLIMenuChoiceValidator validator

	def setup() {
		Menu menu = new Menu();
		validator = new CLIMenuChoiceValidator(menu)
	}

	def "validate throws exception if choice not menu items codes"() {
		when:
		validator.validate(choice)

		then:
		def e = thrown(InvalidMenuChoice)
		e.message == "Expected value between 1 and 6 but got ${choice} instead."

		where:
		choice << ["a", "asdfasdgfasdg", "112", "0", null]
	}


	@Unroll
	def "accept input only if in menu items codes" () {
		when:
		validator.validate(choice)

		then:
		notThrown(InvalidMenuChoice)

		where:
		choice << ("1".."6")
	}

}
