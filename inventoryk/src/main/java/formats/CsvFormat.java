package formats;

import inventory.kalerantes.Item;
import inventory.kalerantes.ItemList;

public class CsvFormat {

	private ItemList items;

	public CsvFormat(ItemList items) {
		this.items = items;
	}

	public CsvFormat() {
		this.items = new ItemList();
	}

	public void setItems(ItemList items) {
		this.items = items;
	}

	public ItemList getItems() {
		return items;
	}

	public String printCsv() {
		StringBuilder strBuilder = new StringBuilder();

		if (getItems().getLi().isEmpty()) {
			strBuilder.append("The inventory List is emtpy\n");

		} else {

			for (Item item : getItems().getLi()) {
				strBuilder.append(item.getName() + "," + item.getSerialNumber() + "," + item.getValue() + "\n");
			}
		}

		return strBuilder.toString();

	}

}
