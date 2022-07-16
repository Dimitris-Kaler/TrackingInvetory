package intentory.kalerantes

import spock.lang.Specification

class MenuItemSpec extends Specification {

	def "it has a code and a description" () {
		when:
		def mi = new AddItemMenuItem();

		then:
		mi.code == "1"
		mi.description == "Add Item"
	}

}
