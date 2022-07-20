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
		Scanner scanner = new Scanner(System.in);
		printMenuOptions(System.out);
		prompt(System.out);
		while (scanner.hasNext())
			dotIt(scanner, System.out, System.err);
	}

	private void dotIt(Scanner scanner, PrintStream out, PrintStream err) {
		String choice = parseInputFromCommandLine(scanner, out, err);
		MenuItem menuItemSelected = menu.findByCode(choice);
		menuItemSelected.execute(list, scanner, out);
		printMenuOptions(out);
		prompt(out);
	}

	private void printMenuOptions(PrintStream out) {
		out.println(menu.options());
	}

	private String parseInputFromCommandLine(Scanner sc, PrintStream out, PrintStream err) {
		while(sc.hasNext()) {
			try {
				return validateChoice(sc, out);
			} catch (Exception e) {
				err.println(e.getMessage());
				err.flush();
				prompt(out);
				out.flush();
			}
		}
		return null;
	}

	private String validateChoice(Scanner sc, PrintStream out) {
		String choice = sc.next();
		cliMenuChoiceValidator.validate(choice);
		return choice;
	}

	private void prompt(PrintStream out) {
		out.println("Enter choice: ");
	}


}
