package intentory.kalerantes

import spock.lang.Specification
import spock.lang.Unroll

class ItemSpec extends Specification{

	@Unroll
	def "create item with name and value"() {
		when:
		Item item = new Item(name, value)

		then:
		item.name == name
		item.value == value

		where:
		name 		| value
		"dimitris" 	| 24.34
		"stelios"  	| 1
	}

	def "create item with null name"() {
		when:
		new Item(null, 12)

		then:
		def e = thrown(NullNameNotAllowedException.class)
		e.message == "Expected name for item but got null name instead."
	}

	def "create item with empty name"() {
		when:
		new Item("", 12)

		then:
		def e = thrown(EmptyNameNotAllowedException.class)
		e.message == "Expected name for item but got empty value for name instead."
	}

	def "create item with value less than 1" () {
		when:
		new Item("name", 0.5)

		then:
		def e = thrown(LessThanOneValueException.class)
	}



}
