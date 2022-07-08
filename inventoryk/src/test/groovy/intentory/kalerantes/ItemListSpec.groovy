package intentory.kalerantes

import spock.lang.Specification



class ItemListSpec extends Specification {


	def "create item list"(){
		when:
		ItemList li=new ItemList();
		
		then:
		li.getLi()==new ArrayList();
		
		
	}

}
