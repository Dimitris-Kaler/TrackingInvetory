package intentory.kalerantes

import spock.lang.Specification

class MenuItemSpec extends Specification {

	def mi

	public void setup() {
		mi = new AddItemMenuItem();
	}

	def "it has a code and a description" () {
		expect:
		mi.code == "1"
		mi.description == "Add Item"
	}

	def "header message"() {
		mi.headerMessage() == "INVETORY HTML REPORT\n********************"
	}

}
