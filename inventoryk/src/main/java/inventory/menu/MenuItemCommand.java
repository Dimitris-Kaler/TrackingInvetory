package inventory.menu;

import java.io.PrintStream;
import java.util.Scanner;

import inventory.kalerantes.ItemList;

public interface MenuItemCommand {

	void execute(ItemList list, Scanner scanner, PrintStream out);

}
