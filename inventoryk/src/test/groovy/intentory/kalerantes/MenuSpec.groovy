package intentory.kalerantes


import spock.lang.Specification

class MenuSpec extends Specification {

	def "menu options"() {
		given:
		Menu menu = new Menu();

		expect:
		menu.options() == """WELCOME TO TRACKING INVETORY - PROJECT
**************************************
1.Add Item
2.Print Out HTML format
3.Save Inventory To Html file
4.Print Out Csv format
5.Save Inventory to Json file
6.Exit The program"""
	}

}
