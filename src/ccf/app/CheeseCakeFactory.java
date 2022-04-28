package ccf.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;

import ccf.impl.*;
//import ccf.intf.*;
import ccf.vO.*;

public class CheeseCakeFactory {

	static Logger log = Logger.getLogger(CheeseCakeFactory.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menuOption;
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		
		//Welcome message
		System.out.println("___Welcome to Cheesecake Factory___\n");
		
		//System.out.println("Creating a file.");
		  try {
		      File myObj1 = new File("E://Eclipse/File/Cheesecake_Management.txt"); //Creating a new file at the specified path
		      log.info("File Created");
		      if (myObj1.createNewFile()) {
		        //System.out.println("File created: " + myObj1.getName()); //confirmation of file creation
		      //Writing to a file
			    try {
			        FileWriter myWriter1 = new FileWriter("E://Eclipse/File/Cheesecake_Management.txt"); //Setting the file to write 
			        
			        myWriter1.write("Category\t$Item\t$Price\t$Quantity\t$Total#\n"); //Writing to file
			        myWriter1.close(); //Closing the writer
			        //System.out.println("Successfully wrote to the file."); //Confirmation message
			        log.info("Written the first line to file successfully");
			      } catch (IOException e) { // error message
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			        log.debug("Writing to file failed.");
			      }
		      }//end if 
		      else {
		        //System.out.println("File already exists."); // Informing user about the file existence already
		        log.debug("File exists in the given directory.");
		      }
		    } 
		    catch (IOException e) { 	//in case on an error print a message
		      System.out.println("An error occurred."); 
		      e.printStackTrace();
		      log.debug("File creation failed.");
		    } // end catch
		
		while(true) {
		menuOption = displayOptions();
		
		/* Switching between the menu */ 
		switch (menuOption) {
		case 1:
			System.out.println("Option Selected: Enter Customer Details");
			addCustomer();
			break;
		case 2:
			System.out.println("Option selected: Take Order");
			displayMenu();
			break;
		case 9:
			System.out.println("Option selected: Exit");
			System.out.println("Thank you for visiting Cheesecake Factory. Visit again");
			//break();
			System.exit(0);
			break;
		default:
			System.out.println("Enter valid choice.");
			break;
		}
		}
	}
	
	private static int displayOptions() {
		int option;
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		//Printing the menu on screen
		System.out.println("\nMain Menu\n1\tEnter Customer Details\n2\tTake Order\n9\tExit");
		option = scan.nextInt();
		return option;
		
	}
	
	private static void addCustomer() {
		System.out.println("\n\nWelcome to adding customer details\n");
		
		Customer C = new Customer();
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the customer phone number");
		C.setPhone(scan.next()); 
		
		System.out.println("Enter the customer name");
		C.setName(scan.next());
		
		try {
		//Invoking the Data operation for customer
		FileImplementation dao = new FileImplementation();
		//DatabaseImplementation dao = new DatabaseImplementation();
		dao.customerData(C);
		}catch(Exception ex) {
			System.out.println("Failed to add customer - pls contact Admin ");
		}
		
		return;
	}
	
	
	private static void displayMenu() {
		int total=0;
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		int count=0;
		while(true){
		 	//Displaying the main menu
			count = count+1;
			
			System.out.println("\n\nSl.No\tCategory\n");
            System.out.println("1\tDesserts\n2\tSnacks");
            System.out.println("3\tAppetizers\n4\tSalads");
            System.out.println("5\tBeverages\n6\tPizzas\n7\tPastas\n");
            System.out.println("9\tOrder Complete\n0\tExit to main menu\n");

			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
	
			switch(choice){
			case 1: 
				System.out.println("Dessets Menu:");
				total = total + ccf.impl.Implementation.desserts();
			break;
			case 2: 
				System.out.println("Snacks Menu:");
				total = total + ccf.impl.Implementation.snacks();
			break;
			case 3: 
				System.out.println("Appetizers Menu:");
				total = total + ccf.impl.Implementation.appetizers();
			break;
			case 4: 
				System.out.println("Salads Menu:");
				total = total + ccf.impl.Implementation.salads();
			break;
			case 5: 
				System.out.println("Beverages Menu:");
				total = total + ccf.impl.Implementation.beverages();
			break;			
			case 6: 
				System.out.println("Pizzas Menu:");
				total = total + ccf.impl.Implementation.pizzas();
			break;
			case 7: 
				System.out.println("Pastas Menu:");
				total = total + ccf.impl.Implementation.pastas();
			break;
			case 9: 
				ccf.impl.Implementation.display(count);
				System.out.println("Total Bill amount is: "+total);
				break; 
			case 0:	
				System.out.println("Thanks for ordering from Cheesecake Factory.\n\n");
				return;
			default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
		}
		
	//scan.close();
	}
		
		//return 0;
	}

}
