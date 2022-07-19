package inventory.kalerantes;

import java.io.PrintStream;
import java.util.Scanner;

import inventory.menu.Menu;
import inventory.menu.MenuItem;

public class UI {

	private ItemList list;
	private Menu menu;

	public UI() {
		list = new ItemList();
		menu = new Menu();
	}

	public void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean loop = true;
			while (loop) {
				printMenuOptions();
				String choice = parseInputFromCommandLine(scanner);
				MenuItem menuItemSelected = menu.findByCode(choice);
				menuItemSelected.execute(list, scanner, System.out);
			}
		}
	}

	private void printMenuOptions() {
		System.out.println(menu.options());
	}

	private String parseInputFromCommandLine(Scanner sc) {
		prompt(System.out);
		while(sc.hasNext()) {
			try {
				return validateChoice(sc);
			} catch (Exception e) {
				handleException(e);
			}
			finally {
				prompt(System.out);
			}
		}
		return null;
	}

	private void handleException(Exception e) {
		System.err.println(e.getMessage());
	}

	private String validateChoice(Scanner sc) {
		String choice = sc.next();
		new CLIMenuChoiceValidator().validate(choice);
		return choice;
	}

	private void prompt(PrintStream out) {
		out.println("Enter choice: ");
	}


}
