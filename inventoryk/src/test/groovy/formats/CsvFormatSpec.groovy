package formats

import spock.lang.Specification
import intentory.kalerantes.Item
import intentory.kalerantes.ItemList
import org.junit.jupiter.api.Test

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
		items.getLi().add(item)
		CsvFormat csvFormat=new CsvFormat(items);
		StringBuilder sBuilder=new StringBuilder()
		when:
		csvFormat.printCsv(sBuilder)
		
		then:
		sBuilder.length()>20;
	}
	
//	def "print message if the list of items is empty"(){
//		given:
//		ItemList items=new ItemList()
//		StringBuilder sBuilder=new StringBuilder()
//		CsvFormat csvFormat=new CsvFormat(items);
//		
//		when:
//		csvFormat.printCsv(sBuilder)
//		csvFormat.items.getLi().isEmpty();
//		
//		then: 
//		System.out.println(csvFormat.items.getLi().isEmpty());
//		sBuilder.append("The List is Empty.")
//		
//		
//	}

}
