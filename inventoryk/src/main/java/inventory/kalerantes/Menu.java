package inventory.kalerantes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.InvalidMenuItemCode;

public class Menu {

	private List<MenuItem> menu;

	public Menu() {
		menu = new ArrayList<MenuItem>();
		menu.add(new AddItemMenuItem());
		menu.add(new PrintHtmlMenuItem());
		menu.add(new CreateHtmlFileMenuItem());
		menu.add(new PrintCSVMenuItem());
		menu.add(new SaveJSONFileMenuItem());
		menu.add(new ExitProgramMenuItem());
	}

	public String options() {
		return header() + menuOptionsAsString();
	}

	public MenuItem findByCode(String code) {
		for (MenuItem mi : menu)
			if (mi.getCode().equals(code))
				return mi;

		throw new InvalidMenuItemCode();
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
