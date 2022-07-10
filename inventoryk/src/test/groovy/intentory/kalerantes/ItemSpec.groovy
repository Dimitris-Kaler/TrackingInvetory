package intentory.kalerantes

import spock.lang.Specification
import spock.lang.Unroll

class ItemSpec extends Specification{

	@Unroll
	def "create item with name and value"() {
		when:
		Item item = new Item(name,serialNumber, value)

		then:
		item.name == name
		item.serialNumber==serialNumber
		item.value == value

		where:
		name 	    |serialNumber| value
		"dimitris" 	|"AXB124AXY" |24.34
		"stelios"  	| "S40AZBDE4"|1
	}

	def "create item with null name"() {
		when:
		new Item(null,"AXB124AXY", 12)

		then:
		def e = thrown(NullNameNotAllowedException.class)
		e.message == "Expected name for item but got null name instead."
	}

	def "create item with empty name"() {
		when:
		new Item("","AXB124AXY", 12)

		then:
		def e = thrown(EmptyNameNotAllowedException.class)
		e.message == "Expected name for item but got empty value for name instead."
	}
	def "create item with null serial Number"(){
		when:
		new Item("dimitris",null,10)
		
		then:
		def e=thrown(NullSerialNumberNotAllowedException.class)
	}
	
	def "create item with serialNumber length different from 9"(){
		when:
		new Item("dimitris","AXB124A",10)
		
		then:
		def e=thrown(SerialNumberLengthNotEqual9.class)
		
	}
	
	def "create item with null value"(){
		when:
		new Item("dimitris","AXB124AXY",null)
		
		then:
		def e=thrown(NullValueNotAllowedException.class)
	}
	

	def "create item with value less than 1" () {
		when:
		new Item("name","AXB124AXY", 0.5)

		then:
		def e = thrown(LessThanOneValueException.class)
	}

	



}
