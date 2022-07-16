package intentory.kalerantes;

import java.util.Scanner;

public class ExitProgramMenuItem extends MenuItem {

	public ExitProgramMenuItem() {
		super("6", "Exit The program");
	}

	@Override
	public void execute(ItemList list, Scanner scanner) {
		System.out.println("BYE BYE!!!");
		System.exit(0);
	}

}
