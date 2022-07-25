package inventory.kalerantes;

import java.util.ArrayList;
import java.util.List;

public class ItemList {

	private List<Item> list;

	public ItemList() {
		list = new ArrayList<>();
	}

	public List<Item> getList() {
		return list;
	}

	public void addItem(Item item) {
		getList().add(item);
	}

}
