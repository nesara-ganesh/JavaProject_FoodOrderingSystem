package ccf.impl;

//import java.io.File;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.Scanner;

import ccf.vO.*;

import org.apache.log4j.Logger;

public class Implementation {
	static Logger log = Logger.getLogger(Implementation.class.getName());
	
	public static int desserts(){
		log.info("In Desserts menu");
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		int dessert[]= {60,80,70,150,90,120};
		String[] item = {"Almond Malai Kulfi", "Lemon Tart", "Pistachio Phirni", "Fudgy Chewy Brownies", "Low Fat Tiramisu","Chocolate Coffee Truffle"};
		int order, subtotal=0;
		String category = "Dessert";
		
		Order O = new Order();
		
		System.out.println("Sl.No\tItem\tPrice\n");
        System.out.println("1\tAlmond Malai Kulfi\t"+dessert[0]);
        System.out.println("2\tLemon Tart\t"+dessert[1]);
        System.out.println("3\tPistachio Phirni\t"+dessert[2]);
        System.out.println("4\tFudgy Chewy Brownies\t"+dessert[3]);
        System.out.println("5\tLow Fat Tiramisu\t"+dessert[4]);
        System.out.println("6\tChocolate Coffee Truffle\t"+dessert[5]+"\n");
        System.out.println("0\tGo Back to Main Menu\n");
        do {
        	System.out.println("Enter your choice\n");
        	order = scan.nextInt();
        	if (order == 0) break;
        	System.out.println("Enter the quantity\n");
        	int quantity = scan.nextInt();
        
        int price = quantity * dessert[order - 1];
        subtotal = subtotal + price;
        System.out.println("Subtotal of Dessert: "+subtotal);
        
        O.setCategory(category);
        O.setItem(item[order-1]);
        O.setPrice(dessert[order-1]);
        O.setQuantity(quantity);
        O.setSerialNum(order);
        
        //Invoking the Data operation for customer
      	FileImplementation dao = new FileImplementation();
      	//DatabaseImplementation dao = new DatabaseImplementation();
        dao.getOrder(O);
        
        
		} while (order != 0);
        log.info("Returning to main menu");
	return subtotal;
	}

	public static int snacks(){
		log.info("In Snacks menu");
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		int snacks[]= {130,80,70,80,90,120};
		int order, subtotal=0;
		String[] item = {"Methi Muthia", "Spinach peas Patties", "Spring Rolls", "Veggie Sticks", "French Fries","Cheese Nachos"};
		Order O = new Order();
		String category = "Snacks";
		
		System.out.println("Sl.No\tItem\tPrice\n");
        System.out.println("1\tMethi Muthia\t"+snacks[0]);
        System.out.println("2\tSpinach peas Patties\t"+snacks[1]);
        System.out.println("3\tSpring Rolls\t"+snacks[2]);
        System.out.println("4\tVeggie Sticks\t"+snacks[3]);
        System.out.println("5\tFrench Fries\t"+snacks[4]);
        System.out.println("6\tCheese Nachos\t"+snacks[5]+"\n");
        System.out.println("0\tGo Back to Main Menu\n");
        do {
        	System.out.println("Enter your choice\n");
        	order = scan.nextInt();
        	if (order == 0) break;
        	System.out.println("Enter the quantity\n");
        	int quantity = scan.nextInt();
        
        int price = quantity * snacks[order - 1];
        subtotal = subtotal + price;
        System.out.println("Subtotal of Snacks: "+subtotal);
        
        O.setCategory(category);
        O.setItem(item[order-1]);
        O.setPrice(snacks[order-1]);
        O.setQuantity(quantity);
        O.setSerialNum(order);
        
        //Invoking the Data operation for customer
      	FileImplementation dao = new FileImplementation();
      	//DatabaseImplementation dao = new DatabaseImplementation();
        dao.getOrder(O);
        
		} while (order != 0);
        log.info("Returning to main menu");
	return subtotal;
	}

	public static int appetizers(){
		log.info("In Appetizers menu");
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		int appet[]= {130,180,170,180,190,150};
		int order, subtotal=0;
		String[] item = {"Gobi Manchurian", "Jalapeno Cheese Puffs", "Simply Guacamole", "Italian Party Bread", "tuffed Mushroom","Tortellini Skewers"};
		Order O = new Order();
		String category = "Appetizer";
		
		System.out.println("Sl.No\tItem\tPrice\n");
        System.out.println("1\tGobi Manchurian\t"+appet[0]);
        System.out.println("2\tJalapeno Cheese Puffs\t"+appet[1]);
        System.out.println("3\tSimply Guacamole\t"+appet[2]);
        System.out.println("4\tItalian Party Bread\t"+appet[3]);
        System.out.println("5\tStuffed Mushroom\t"+appet[4]);
        System.out.println("6\tTortellini Skewers\t"+appet[5]+"\n");
        System.out.println("0\tGo Back to Main Menu\n");
        do {
        	System.out.println("Enter your choice\n");
        	order = scan.nextInt();
        	if (order == 0) break;
        	System.out.println("Enter the quantity\n");
        	int quantity = scan.nextInt();
        
        int price = quantity * appet[order - 1];
        subtotal = subtotal + price;
        System.out.println("Subtotal of Appetizers: "+subtotal);
        
        O.setCategory(category);
        O.setItem(item[order-1]);
        O.setPrice(appet[order-1]);
        O.setQuantity(quantity);
        O.setSerialNum(order);
        
        //Invoking the Data operation for customer
      	FileImplementation dao = new FileImplementation();
      	//DatabaseImplementation dao = new DatabaseImplementation();
        dao.getOrder(O);
        
		} while (order != 0);
        log.info("Returning to main menu");
	return subtotal;
	}

	public static int salads(){
		log.info("In Salads menu");
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		int sal[]= {120,80,200,180,220,110};
		int order, subtotal=0;
		String[] item = {"Cesar Salad", "Garden Delux", "Greek", "Tivoli", "Chefs Special","High Protien"};
		Order O = new Order();
		String category = "Salad";
		
		System.out.println("Sl.No\tItem\tPrice\n");
        System.out.println("1\tCesar Salad\t"+sal[0]);
        System.out.println("2\tGarden Delux\t"+sal[1]);
        System.out.println("3\tGreek\t"+sal[2]);
        System.out.println("4\tTivoli\t"+sal[3]);
        System.out.println("5\tChefs Special\t"+sal[4]);
        System.out.println("6\tHigh Protien\t"+sal[5]+"\n");
        System.out.println("0\tGo Back to Main Menu\n");
        do {
        	System.out.println("Enter your choice\n");
        	order = scan.nextInt();
        	if (order == 0) break;
        	System.out.println("Enter the quantity\n");
        	int quantity = scan.nextInt();
        
        int price = quantity * sal[order - 1];
        subtotal = subtotal + price;
        System.out.println("Subtotal of Salads: "+subtotal);
        
        O.setCategory(category);
        O.setItem(item[order-1]);
        O.setPrice(sal[order-1]);
        O.setQuantity(quantity);
        O.setSerialNum(order);
        
        //Invoking the Data operation for customer
      	FileImplementation dao = new FileImplementation();
      	//DatabaseImplementation dao = new DatabaseImplementation();
        dao.getOrder(O);
        
		} while (order != 0);
        log.info("Returning to main menu");
	return subtotal;
	}

	public static int beverages(){
		log.info("In Beverages menu");
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		int bev[]= {70,70,70,70,70,70};
		int order, subtotal=0;
		String[] item = {"Container Orange", "Lychee Ice Tea", "Container Blue", "Berry Sensation", "Green Garden","Brewed Coffee"};
		Order O = new Order();
		String category = "Beverage";
		
		System.out.println("Sl.No\tItem\tPrice\n");
        System.out.println("1\tContainer Orange\t"+bev[0]);
        System.out.println("2\tLychee Ice Tea\t"+bev[1]);
        System.out.println("3\tContainer Blue\t"+bev[2]);
        System.out.println("4\tBerry Sensation\t"+bev[3]);
        System.out.println("5\tGreen Garden\t"+bev[4]);
        System.out.println("6\tBrewed Coffee\t"+bev[5]+"\n");
        System.out.println("0\tGo Back to Main Menu\n");
        do {
        	System.out.println("Enter your choice\n");
        	order = scan.nextInt();
        	if (order == 0) break;
        	System.out.println("Enter the quantity\n");
        	int quantity = scan.nextInt();
        
        int price = quantity * bev[order - 1];
        subtotal = subtotal + price;
        System.out.println("Subtotal of Beverages: "+subtotal);
        
        O.setCategory(category);
        O.setItem(item[order-1]);
        O.setPrice(bev[order-1]);
        O.setQuantity(quantity);
        O.setSerialNum(order);
        
        //Invoking the Data operation for customer
      	FileImplementation dao = new FileImplementation();
      	//DatabaseImplementation dao = new DatabaseImplementation();
        dao.getOrder(O);
        
		} while (order != 0);
    log.info("Returning to main menu");    
	return subtotal;
	}
	
	public static int pizzas(){
		log.info("In Pizzas menu");
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		int pizzas[]= {230,280,270,280,290,320};
		int order, subtotal=0;
		String[] item = {"Margherita", "Quattro Stagioni", "Diavola", "Parmigiana", "Frutti Di Mare","Veggie Piccole"};
		Order O = new Order();
		String category = "Pizza";
		
		System.out.println("Sl.No\tItem\tPrice\n");
        System.out.println("1\tMargherita\t"+pizzas[0]);
        System.out.println("2\tQuattro Stagioni\t"+pizzas[1]);
        System.out.println("3\tDiavola\t"+pizzas[2]);
        System.out.println("4\tParmigiana\t"+pizzas[3]);
        System.out.println("5\tFrutti Di Mare\t"+pizzas[4]);
        System.out.println("6\tVeggie Piccole\t"+pizzas[5]+"\n");
        System.out.println("0\tGo Back to Main Menu\n");
        do {
        	System.out.println("Enter your choice\n");
        	order = scan.nextInt();
        	if (order == 0) break;
        	System.out.println("Enter the quantity\n");
        	int quantity = scan.nextInt();
        
        int price = quantity * pizzas[order - 1];
        subtotal = subtotal + price;
        System.out.println("Subtotal of Pizzas: "+subtotal);
        
        O.setCategory(category);
        O.setItem(item[order-1]);
        O.setPrice(pizzas[order-1]);
        O.setQuantity(quantity);
        O.setSerialNum(order);
        
        //Invoking the Data operation for customer
      	FileImplementation dao = new FileImplementation();
      	//DatabaseImplementation dao = new DatabaseImplementation();
        dao.getOrder(O);
        
		} while (order != 0);
        log.info("Returning to main menu");   
	return subtotal;
	}

	public static int pastas(){
		log.info("In Pastas menu");
		@SuppressWarnings("all")
		Scanner scan = new Scanner(System.in);
		int pastas[]= {130,80,70,80,90,120};
		int order, subtotal=0;
		String[] item = {"Spinacch Stuffed Ravioli", "Veg Conquelioni", "Spaghetti Bolognese", "Dark Pasta", "Tortellini with tomatoes","Pappardelle"};
		Order O = new Order();
		String category = "Pasta";
		
		System.out.println("Sl.No\tItem\tPrice\n");
        System.out.println("1\tSpinacch Stuffed Ravioli\t"+pastas[0]);
        System.out.println("2\tVeg Conquelioni\t"+pastas[1]);
        System.out.println("3\tSpaghetti Bolognese\t"+pastas[2]);
        System.out.println("4\tDark Pasta\t"+pastas[3]);
        System.out.println("5\tTortellini with tomatoes\t"+pastas[4]);
        System.out.println("6\tPappardelle\t"+pastas[5]+"\n");
        System.out.println("0\tGo Back to Main Menu\n");
        do {
        	System.out.println("Enter your choice\n");
        	order = scan.nextInt();
        	if (order == 0) break;
        	System.out.println("Enter the quantity\n");
        	int quantity = scan.nextInt();
        
        int price = quantity * pastas[order - 1];
        subtotal = subtotal + price;
        System.out.println("Subtotal of Pastas: "+subtotal);
        
        O.setCategory(category);
        O.setItem(item[order-1]);
        O.setPrice(pastas[order-1]);
        O.setQuantity(quantity);
        O.setSerialNum(order);
        
        //Invoking the Data operation for customer
      	FileImplementation dao = new FileImplementation();
      	//DatabaseImplementation dao = new DatabaseImplementation();
        dao.getOrder(O);
        
		} while (order != 0);
        log.info("Returning to main menu");
	return subtotal;

	}
	
	public static void display(int count) {
		
		FileImplementation dao = new FileImplementation();
      	//DatabaseImplementation dao = new DatabaseImplementation();
        dao.displayOrder(count);
	}

}
