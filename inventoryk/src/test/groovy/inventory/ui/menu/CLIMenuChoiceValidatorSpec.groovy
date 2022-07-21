package inventory.ui.menu

import exceptions.InvalidMenuChoice
import inventory.ui.menu.CLIMenuChoiceValidator
import spock.lang.Specification
import spock.lang.Unroll

class CLIMenuChoiceValidatorSpec extends Specification {

	def "validate throws exception if choice not between 1 and 6"() {
		given:
		CLIMenuChoiceValidator v = new CLIMenuChoiceValidator()

		when:
		v.validate(choice)

		then:
		def e = thrown(InvalidMenuChoice)
		e.message == "Expected value between 1 and 6 but got ${choice} instead."

		where:
		choice << ["a", "asdfasdgfasdg", "112", "0", null]
	}


	@Unroll
	def "accept input only between 1 and 6" () {
		given:
		CLIMenuChoiceValidator v = new CLIMenuChoiceValidator()

		when:
		v.validate(choice)

		then:
		notThrown(InvalidMenuChoice)

		where:
		choice << ("1".."6")
	}
}
