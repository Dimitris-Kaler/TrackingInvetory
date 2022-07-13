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
}


