package inventory.items

import inventory.items.Item
import inventory.items.ItemList
import spock.lang.Specification

class ItemListSpec extends Specification {

	def "create item list"(){
		when:
		ItemList li=new ItemList();

		then:
		li.getList()==new ArrayList();
	}

	def "add item"() {
		given:
		ItemList list  =new ItemList();

		when:
		list.addItem(new Item("123", "123456789", 23))

		then:
		list.list.size() == 1
	}

}


