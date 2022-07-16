package intentory.kalerantes

import spock.lang.Specification

class PrintHtmlMenuItemSpec extends Specification {

	def "the code is 2 and the description Print Out HTML format"() {
		given:
		PrintHtmlMenuItem mi = new PrintHtmlMenuItem()

		expect:
		mi.code == "2"
		mi.description == "Print Out HTML format"
	}




}
