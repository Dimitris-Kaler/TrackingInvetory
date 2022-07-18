package inventory.menu;

import java.io.PrintStream;
import java.util.Scanner;

import formats.CsvFormat;
import inventory.kalerantes.ItemList;

public class PrintCSVMenuItem extends MenuItem {

	private CsvFormat csvFormatter;

	public PrintCSVMenuItem() {
		super("4", "Print Out Csv format");
		csvFormatter = new CsvFormat();
	}

	@Override
	public void execute(ItemList list, Scanner scanner, PrintStream out) {
		csvFormatter.setItems(list);
		System.out.println(messageHeader());
		System.out.println(csvFormatter.printCsv() + "\n");
	}

	private String messageHeader() {
		return "INVETORY CSV REPORT\n********************";
	}

}
