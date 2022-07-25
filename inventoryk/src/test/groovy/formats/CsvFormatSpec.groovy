package formats

import spock.lang.Specification

import org.junit.jupiter.api.Test

import inventory.kalerantes.Item
import inventory.kalerantes.ItemList

class CsvFormatSpec extends Specification {

	def "initialise CsvFormat"(){
		when:
	ItemList items=new ItemList()
	CsvFormat csvFormat=new CsvFormat(items);
	then:
	csvFormat.items==items;
	}
	
	def "print list in CsvFormat"(){
		given:
		Item item=new Item("SKODA","XSWER234R",2000);
		ItemList items=new ItemList()
		items.getList().add(item)
		CsvFormat csvFormat=new CsvFormat(items);
		when:
		String result=csvFormat.printCsv()
		
		then:
		result=="SKODA,XSWER234R,2000\n"

		
//		
	}
	
	def "print message if the list of items is empty"(){
		given:
		ItemList items=new ItemList()
		CsvFormat csvFormat=new CsvFormat(items);
		
		when:
		String result=csvFormat.printCsv()
		csvFormat.items.getList().isEmpty();
		
		then: 
		result=="The inventory List is emtpy\n"
		
		
	}

}
