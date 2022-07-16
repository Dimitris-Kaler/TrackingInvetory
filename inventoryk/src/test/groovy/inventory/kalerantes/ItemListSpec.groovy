package inventory.kalerantes

import inventory.kalerantes.ItemList
import spock.lang.Ignore
import spock.lang.Specification



class ItemListSpec extends Specification {



	def "create item list"(){
		when:
		ItemList li=new ItemList();

		then:
		li.getLi()==new ArrayList();
	}

	//TODO the fact that this test is using the scanner is a code smell
	@Ignore
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


