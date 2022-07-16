package inventory.menu;

import java.util.Scanner;

import inventory.kalerantes.ItemList;

public interface MenuItemCommand {

	public void execute(ItemList list, Scanner scanner);

}
