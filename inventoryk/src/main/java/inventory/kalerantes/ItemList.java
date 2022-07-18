package inventory.kalerantes;

import java.util.ArrayList;
import java.util.List;

public class ItemList {

	private List<Item> li;

	public ItemList() {
		li = new ArrayList<Item>();
	}

	public List<Item> getLi() {
		return li;
	}

	public void addItem(Item item) {
		getLi().add(item);
	}

}
