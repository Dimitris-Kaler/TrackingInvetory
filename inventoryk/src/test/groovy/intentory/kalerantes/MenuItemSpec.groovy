package intentory.kalerantes

import spock.lang.Specification

class MenuItemSpec extends Specification {

	def "it has a code and a description" () {
		when:
		def mi = new MenuItem("1", "description");

		then:
		mi.code == "1"
		mi.description == "description"
	}

}
