package inventory.ui.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import inventory.ui.menu.exceptions.InvalidMenuItemCode;

public class Menu {

	private List<MenuItem> menuList;

	public Menu() {
		menuList = new ArrayList<>();
		menuList.add(new AddItemMenuItem());
		menuList.add(new PrintHtmlMenuItem());
		menuList.add(new CreateHtmlFileMenuItem());
		menuList.add(new PrintCSVMenuItem());
		menuList.add(new SaveJSONFileMenuItem());
		menuList.add(new ExitProgramMenuItem());
	}

	public String options() {
		return header() + menuOptionsAsString();
	}

	public MenuItem findByCode(String code) {
		for (MenuItem mi : menuList)
			if (mi.getCode().equals(code))
				return mi;

		throw new InvalidMenuItemCode();
	}

	private String header() {
		return "WELCOME TO TRACKING INVETORY - PROJECT\n" +
				"**************************************\n";
	}

	private String menuOptionsAsString() {
		return menuList.stream()
			.map(MenuItem::toString)
			.collect(Collectors.joining("\n"));
	}

}
