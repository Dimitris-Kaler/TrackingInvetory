package inventory.menu;

import java.io.PrintStream;
import java.util.Scanner;

import inventory.kalerantes.Exit;
import inventory.kalerantes.ItemList;

public class ExitProgramMenuItem extends MenuItem {

	private Exit exit;

	public ExitProgramMenuItem() {
		super("6", "Exit The program");
		exit = new Exit();
	}

	@Override
	public void execute(ItemList list, Scanner scanner, PrintStream out) {
		System.out.println(message());
		exit.doIt();
	}

	private String message() {
		return "BYE BYE!!!";
	}

}
