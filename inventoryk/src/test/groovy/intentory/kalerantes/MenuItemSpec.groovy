package intentory.kalerantes

import spock.lang.Specification

class MenuItemSpec extends Specification {

	def "it has a code" () {
		expect:
		new MenuItem("1");
	}

}
