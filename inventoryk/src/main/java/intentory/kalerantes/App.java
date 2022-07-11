/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package intentory.kalerantes;

import java.util.Scanner;

import formats.CsvFormat;
import formats.HtmlFormat;
import formats.JsonFormat;




public class App {
	
    public static int readInt(Scanner sc,int lower,int upper){
        int choice;
        while(true){
            System.out.print("Your choice:");
            if(sc.hasNextInt()){
                choice=sc.nextInt();
                if(choice<lower || choice>upper){
                    System.out.println("Error: Between "+lower+" and "+upper);
                }
                else
                    return choice;


            }else{
                sc.next();
                System.out.println("Invalid input!!!");

            }
        }

    }

    public static void main(String[] args) {
    	ItemList list=new ItemList();
    	HtmlFormat htmlformat=new HtmlFormat(list);
    	CsvFormat csvFormatter=new CsvFormat(list);
        JsonFormat jFormat=new JsonFormat(list);
        boolean loop=true;
        try(Scanner scanner=new Scanner(System.in)){
    while(loop) {
    	
    	System.out.println("WELCOME TO TRACKING INVETORY - PROJECT");
    	System.out.println("********************");
    	System.out.println("1.Add Item");
    	System.out.println("2.Print Out HTML format");
    	System.out.println("3.Print Out CSV fromat");
    	System.out.println("4.Save Inventory to Json file");
    	System.out.println("5.Exit The program");
    	int choice=readInt(scanner,1,5);
    	
    	if(choice==1) {
    		scanner.nextLine();
    		list.addItem(scanner);
    		
    	}
      	if(choice==2) {
    		htmlformat.printHtml();
    		
    	}
      	if(choice==3) {
      		csvFormatter.printCsv();
    	}
      	if(choice==4) {
      		
      		jFormat.createFileWithJsonFormat();
      		System.out.println("The JsonFile with the Inventory Items has succesfully created!!");
      		
      	}
    	if(choice==5) {
    		System.out.println("BYE BYE!!!");
    		loop=false;
    		
    	}
    	
  
    	}
   }
    	
    }
}
