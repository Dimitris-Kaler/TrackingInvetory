package inventory.ui.menu

import inventory.items.ItemList
import inventory.ui.menu.exceptions.InvalidMenuItemCode
import spock.lang.Specification
import spock.lang.Unroll

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

	def "searching for menu item with invalid code" () {
		given:
		Menu menu = new Menu();

		when:
		MenuItem mi = menu.findByCode("1f3")

		then:
		thrown(InvalidMenuItemCode)
	}

	def "searching for menu item with null" () {
		given:
		Menu menu = new Menu();

		when:
		MenuItem mi = menu.findByCode(null)

		then:
		thrown(InvalidMenuItemCode)
	}

	@Unroll
	def "find menu item by code"() {
		given:
		Menu menu = new Menu();

		when:
		MenuItem mi = menu.findByCode(code)

		then:
		mi.code == code
		mi.description == description

		where:
		code || description
		"1"  || "Add Item"
		"2"  || "Print Out HTML format"
		"3"  || "Save Inventory To Html file"
		"4"  || "Print Out Csv format"
		"5"  || "Save Inventory to Json file"
		"6"  || "Exit The program"
	}

	def "menu codes"() {
		given:
		Menu menu = new Menu()
		menu.menuList = [new MenuItem1(), new MenuItem2()]

		expect:
		menu.codes() == ["code1", "code"]
	}

	class MenuItem1 extends MenuItem {

			MenuItem1() {
				super("code1", "")
			}

			@Override
			public void execute(ItemList list, Scanner scanner, PrintStream out) {
				// TODO Auto-generated method stub
			}
		}

		class MenuItem2 extends MenuItem {

			MenuItem2() {
				super("code", "")
			}

			@Override
			public void execute(ItemList list, Scanner scanner, PrintStream out) {
				// TODO Auto-generated method stub
			}
		}

}


