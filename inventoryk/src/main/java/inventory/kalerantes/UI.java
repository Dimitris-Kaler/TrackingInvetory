package inventory.kalerantes;

import java.io.InputStream;
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

	public void run(InputStream in, PrintStream out, PrintStream err) {
		Scanner scanner = new Scanner(in);
		displayMenuWithPrompt(out);
		while (scanner.hasNext())
			dotIt(scanner, out, err);

	}

	private void dotIt(Scanner scanner, PrintStream out, PrintStream err) {
		String choice = parseInputFromCommandLine(scanner, out, err);
		MenuItem menuItemSelected = menu.findByCode(choice);
		menuItemSelected.execute(list, scanner, out);
		displayMenuWithPrompt(out);
	}


	private void displayMenuWithPrompt(PrintStream out) {
		printMenuOptions(out);
		prompt(out);
	}

	private String parseInputFromCommandLine(Scanner sc, PrintStream out, PrintStream err) {
			try {
				return validateChoice(sc, out);
			} catch (Exception e) {
				err.println(e.getMessage());
				err.flush();
				prompt(out);
				out.flush();
				return parseInputFromCommandLine(sc, out, err);
		}
	}

	private String validateChoice(Scanner sc, PrintStream out) {
		String choice = sc.next();
		cliMenuChoiceValidator.validate(choice);
		return choice;
	}

	private void printMenuOptions(PrintStream out) {
		out.println(menu.options());
	}

	private void prompt(PrintStream out) {
		out.println("Enter choice: ");
	}


}
