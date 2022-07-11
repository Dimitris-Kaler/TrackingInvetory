package intentory.kalerantes

import spock.lang.Specification



class ItemListSpec extends Specification {


	def "create item list"(){
		when:
		ItemList li=new ItemList();
		
		then:
		li.getLi()==new ArrayList();
		
		
	}
	def "Add Item with Scanner"(){
		setup:
		Scanner scanner=new Scanner(System.in)
		ItemList li=new ItemList()
		
		when:
		def result=li.getLi().size()
		li.addItem(scanner)
		
		then:
		result<li.getLi().size()
		}
		
		
	def "Print html Introductoryreport"(){
		setup:
		def li=new ItemList();
		def string="<!DOCTYPE html>\r\n"+ "<html lang=\"en\">\r\n"+ "<head>\r\n"+ "    <meta charset=\"UTF-8\">\r\n"+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"+ "    <title>HTML REPORT</title>\r\n"+ "</head>\r\n"+ "<body>\r\n"
		StringBuilder sBuilder=new StringBuilder();
		
		when:
		def result=li.print()
		
		then:
		string
		
	}
	
	def "Print items of the itemlist at html report"(){
		
		
		
		
	}
		
		

	
	
		
	}


