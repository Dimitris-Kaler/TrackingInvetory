package inventory.kalerantes

import spock.lang.Specification

class ItemListSpec extends Specification {

	def "create item list"(){
		when:
		ItemList li=new ItemList();

		then:
		li.getLi()==new ArrayList();
	}

	def "add item"() {
		given:
		ItemList list  =new ItemList();

		when:
		list.addItem(new Item("123", "123456789", 23))

		then:
		list.li.size() == 1
	}

}


