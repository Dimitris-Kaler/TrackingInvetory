package inventory.kalerantes;

import java.io.PrintStream;
import java.util.Scanner;

import inventory.menu.Menu;
import inventory.menu.MenuItem;

public class UI {

	private ItemList list;
	private Menu menu;
	private CLIMenuChoiceValidator cliMenuChoiceValidator;

	public UI() {
		list = new ItemList();
		menu = new Menu();
		cliMenuChoiceValidator = new CLIMenuChoiceValidator();
	}

	public UI(Menu menu) {
		this();
		this.menu = menu;
	}

	public void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				dotIt(scanner, System.out, System.err);
			}
		}
	}

	private void dotIt(Scanner scanner, PrintStream out, PrintStream err) {
		printMenuOptions(out);
		String choice = parseInputFromCommandLine(scanner, out, err);
		MenuItem menuItemSelected = menu.findByCode(choice);
		menuItemSelected.execute(list, scanner, out);
	}

	private void printMenuOptions(PrintStream out) {
		out.println(menu.options());
	}

	private String parseInputFromCommandLine(Scanner sc, PrintStream out, PrintStream err) {
		prompt(out);
		while(sc.hasNext()) {
			try {
				return validateChoice(sc, out);
			} catch (Exception e) {
				err.println(e.getMessage());
			}
			finally {
				prompt(out);
			}
		}
		return null;
	}

	private String validateChoice(Scanner sc, PrintStream out) {
		String choice = sc.next();
		out.println("Choice:" + choice);
		cliMenuChoiceValidator.validate(choice);
		return choice;
	}

	private void prompt(PrintStream out) {
		out.println("Enter choice: ");
	}


}
