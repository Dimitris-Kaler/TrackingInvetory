package inventory.ui.menu;

import java.io.PrintStream;
import java.util.Scanner;

import inventory.items.ItemList;

public interface MenuItemCommand {

	void execute(ItemList list, Scanner scanner, PrintStream out);

}
