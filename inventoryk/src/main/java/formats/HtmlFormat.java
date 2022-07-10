package formats;

import intentory.kalerantes.Item;
import intentory.kalerantes.ItemList;

public class HtmlFormat {
	
	private ItemList items;
	
	
	
	public HtmlFormat(ItemList items) {
		this.items=items;
		
	}
	
	

	
	public ItemList getItems() {
		return items;
	}

	public void printHtml(StringBuilder strBuilder){
		System.out.println("INVETORY HTML REPORT");
		System.out.println("********************");
		 htmlHeader(strBuilder);
		 printItems(getItems(),strBuilder);
		 htmlFooter(strBuilder);	
		
		
		
	}

	public void htmlHeader(StringBuilder sbuilder) {
		final String HTMLSTRING="<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>HTML REPORT</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n";
					
				
			 sbuilder.append(HTMLSTRING);
	}
	 public void printItems(ItemList list,StringBuilder sbuilder) {
		 if(list.getLi().size()==0) {
			 sbuilder.append(" <p>No items on the Invetory.</p>\n");
		 }else {
			sbuilder.append(" <table>\n"
					+"  <thead>\n"
					+"   <tr>\n"
					+ "    <th>name</th>\n"
					+ "    <th>serialNumber</th>\n"
					+ "    <th>value</th>\n"
					+"   </tr>\n");
			for (Item item:getItems().getLi()) {
				 String str="   <tr>\n"
				 		+ "    <th>"+item.getName()+"</th>\n"
				 				+ "    <th>"+item.getSerialNumber()+"</th>\n"
				 						+ "    <th>"+item.getValue()+"</th>\n"
				 								+ "   </tr>\n";
				 sbuilder.append(str);
			}
			sbuilder.append("  <tbody>\n </table>\n");}
	
}
	 public void htmlFooter(StringBuilder sbuilder) {
		 final String HTMLSTRING= "</body>\r\n"
		 		+ "</html>";
		 
		 sbuilder.append(HTMLSTRING);
		 System.out.println(sbuilder.toString()+"\n");
		 
	 }
}
