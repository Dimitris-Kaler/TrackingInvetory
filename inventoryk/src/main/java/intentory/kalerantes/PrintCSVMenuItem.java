package intentory.kalerantes;

import java.util.Scanner;

import formats.CsvFormat;

public class PrintCSVMenuItem extends MenuItem {

	public PrintCSVMenuItem(String code, String description) {
		super(code, description);
	}

	@Override
	public void execute(ItemList list, Scanner scanner) {
		CsvFormat csvFormatter = new CsvFormat(list);
		System.out.println("INVETORY CSV REPORT");
		System.out.println("********************");
		System.out.println(csvFormatter.printCsv() + "\n");
	}

}
