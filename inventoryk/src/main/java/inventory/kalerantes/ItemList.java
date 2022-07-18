package inventory.kalerantes;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemList {

	private List<Item> li;

	public ItemList() {
		li = new ArrayList<Item>();
	}

	public List<Item> getLi() {
		return li;
	}


	//TODO this piece of code has to do with parsing from command line and not with items list
	public void addItem(Scanner scanner, PrintStream out) {
		Item item = new ItemCLIParser().parseItem(scanner, out);
		getLi().add(item);
		//TODO why do you need that line?
//		scanner.nextLine();
		out.println("The item has succesfully submitted to the ItemList");
	}



}
