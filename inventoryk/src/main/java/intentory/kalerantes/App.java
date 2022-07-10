/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package intentory.kalerantes;

import java.util.Scanner;


import formats.HtmlFormat;


public class App {
	
	
    public String getGreeting() {
        return "Hello World!";
    }
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
    	StringBuilder strBuilder=new StringBuilder();
    	boolean loop=true;
        System.out.println(new App().getGreeting());
    
        try(Scanner scanner=new Scanner(System.in)){
    while(loop) {
    	
    	System.out.println("WELCOME TO TRACKING INVETORY - PROJECT");
    	System.out.println("********************");
    	System.out.println("1.Add Item");
    	System.out.println("2.Print Out HTML format");
    	System.out.println("3.Print Out CSV fromat");
    	System.out.println("4.Exit The program");
    	int choice=readInt(scanner,1,4);
    	
    	if(choice==1) {
    		scanner.nextLine();
    		list.addItem(scanner);
    		
    	}if(choice==4) {
    		System.out.println(list.getLi());
    		loop=false;
    		
    	}
    	if(choice==3) {
    		continue;
    	}
    	if(choice==2) {
//    		System.out.println(list.print());
//    		System.out.print(HtmlFormat.printItemsToReport(list));
    		htmlformat.printHtml(strBuilder);
    		
    	}
    	}
   }
    	
    }
}
