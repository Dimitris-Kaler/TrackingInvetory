package intentory.kalerantes;

import java.util.Scanner;

public class AddItemMenuItem extends MenuItem {

	public AddItemMenuItem(String code, String description) {
		super(code, description);
	}

	@Override
	public void execute(ItemList list, Scanner scanner) {
		scanner.nextLine();
		list.addItem(scanner);
	}

}
