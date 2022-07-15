package intentory.kalerantes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {

	private List<MenuItem> menu;

	public Menu() {
		menu = new ArrayList<MenuItem>();
		menu.add(new MenuItem("1", "Add Item"));
		menu.add(new MenuItem("2", "Print Out HTML format"));
		menu.add(new MenuItem("3", "Save Inventory To Html file"));
		menu.add(new MenuItem("4", "Print Out Csv format"));
		menu.add(new MenuItem("5", "Save Inventory to Json file"));
		menu.add(new ExitProgramMenuItem("6", "Exit The program"));
	}

	public String options() {
		return header() + menuOptionsAsString();
	}

	private String header() {
		return "WELCOME TO TRACKING INVETORY - PROJECT\n" +
				"**************************************\n";
	}

	private String menuOptionsAsString() {
		return menu.stream()
			.map(mi -> mi.toString())
			.collect(Collectors.joining("\n"));
	}

}