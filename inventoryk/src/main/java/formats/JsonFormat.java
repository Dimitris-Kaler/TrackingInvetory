package formats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import exceptions.NullItemListException;
import intentory.kalerantes.ItemList;

public class JsonFormat {

	private ItemList items;

	public JsonFormat() {
		items = new ItemList();
	}

	public JsonFormat(ItemList items) {
		this.items = items;
	}

	public void setItems(ItemList items) {
		this.items = items;
	}

	public ItemList getItems() {
		return items;
	}

	public void createFileWithJsonFormat() {
		if (items.getLi().size() == 0) {
			throw new NullItemListException();
		} else {
			File file = new File("text.json");
			try (FileWriter fWriter = new FileWriter(file)) {
				fWriter.write(convertToJson());
				System.out.println("The JsonFile with the Inventory Items has succesfully created!!");

			} catch (IOException e) {
				System.out.println(e);
			}
		}

	}

	public String convertToJson() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String strJson = gson.toJson(items.getLi());

		return strJson;

	}

}
