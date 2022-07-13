package formats

import intentory.kalerantes.Item
import intentory.kalerantes.ItemList
import exceptions.NullItemListException
import spock.lang.Specification


class JsonFormatSpec extends Specification {
	
	def "initalise JsonFormat"(){
	
	when:
	ItemList items=new ItemList()
	JsonFormat jFormat=new JsonFormat(items)
	
	then:
	jFormat.items==items
	
	}
	def "Message if invetory List is empty"(){
		when:
		ItemList li=new ItemList();
		JsonFormat jFormat=new JsonFormat(li)
		jFormat.createFileWithJsonFormat()
		
		then:
		def e=thrown(NullItemListException.class)
		e.message=="Expected items in the inventory but we took null instead!"
				
		
	}
	
	def "convert ItemList to Json Format"(){
		given:
		Item item=new Item("SKODA","XSWER234R",2000)
		
		ItemList items=new ItemList()
		items.getLi().add(item)
		JsonFormat jFormat=new JsonFormat(items)
		
		when:
		String result=jFormat.convertToJson()
		
		then:
		System.out.println(result);
		result==("[\n"
			+ "  {\n    \"name\": \"SKODA\",\n"
			+"    \"serialNumber\": \"XSWER234R\",\n"
			+"    \"value\": 2000\n"
			+"  }\n"
			+"]")
				
		
	}
	
	def "loop convert ItemList to Json Format"(){
		given:
		Item item=new Item("SKODA","XSWER234R",2000)
		Item item1=new Item("BMW","WEDFG12WQ",10000)
		
		ItemList items=new ItemList()
		items.getLi().add(item)
		items.getLi().add(item1)
		JsonFormat jFormat=new JsonFormat(items)
		
		when:
		String result=jFormat.convertToJson()
		
		then:
		result==("[\n"
			+ "  {\n    \"name\": \"SKODA\",\n"
			+"    \"serialNumber\": \"XSWER234R\",\n"
			+"    \"value\": 2000\n"
			+"  },\n"
			+ "  {\n    \"name\": \"BMW\",\n"
			+"    \"serialNumber\": \"WEDFG12WQ\",\n"
			+"    \"value\": 10000\n"
			+"  }\n"
			+"]")
		
	}
	

	

	
	def "Save JsonFormat to File"(){
		given:
		Item item=new Item("SKODA","XSWER234R",2000)
		
		ItemList items=new ItemList()
		items.getLi().add(item)
		JsonFormat jFormat=new JsonFormat(items)
		File file=new File("text.json")
		FileWriter fWriter=new FileWriter(file)
		
		when:
		jFormat.createFileWithJsonFormat()
		
		then:
		fWriter.write(jFormat.convertToJson())
		
		
	}


}
