package formats;

import intentory.kalerantes.Item;
import intentory.kalerantes.ItemList;

public class CsvFormat { 
	
	

	private ItemList items;
	
	
	public CsvFormat(ItemList items) {
		this.items=items;
	}


	public ItemList getItems() {
		return items;
	}
	
	
	
	public void printCsv(StringBuilder strBuilder) {
		System.out.println("INVETORY CSV REPORT");
		System.out.println("********************");
		
		for(Item item:getItems().getLi()) {
			strBuilder.append(item.getName()+","+item.getSerialNumber()+","+item.getValue()+"\n");
		}
		
		
		System.out.println(strBuilder.toString()+"\n");
		
		
		
	}



	

}
