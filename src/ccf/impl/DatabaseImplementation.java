package ccf.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ccf.intf.DataOperations;
import ccf.vO.Customer;
import ccf.vO.Order;

public class DatabaseImplementation implements DataOperations{

	String url = "jdbc:mysql://127.0.0.1:3306/cheesecake_database";
	
	public void customerData(Customer C)
	{
		
	    String phone1=C.getPhone(),name1=C.getName();
		@SuppressWarnings("unused")
		int rowsAffected;
		
		try {
			//Establish connection object	
			Connection conn = DriverManager.getConnection(url,"root","ShadeEragon@28");
		
		    //Create a statement object to send to database
			//Statement statement = conn.createStatement();
			PreparedStatement stmt=conn.prepareStatement("insert into cheesecake_customer_tbl values(?,?)");

			stmt.setString(1,phone1);
			stmt.setString(2,name1);

			@SuppressWarnings("unused")
			int i = stmt.executeUpdate();
			
			System.out.println("Inserted rows to customer table\n\n");
			
		/*
            ResultSet resultSet2 = stmt.executeQuery("select * from cheesecake_customer_tbl");
			
			//Print result
			System.out.println("   Name 	     	Phone");
			System.out.println("===============================\n");
			
			/*while (resultSet2.next()) {
	            String name = resultSet2.getString("Name");
	            String phone = resultSet2.getString("Phone");
	      
	            System.out.println(name+"   "+phone);
	         }*/
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Error while insertion");
		}
	}
	
	
	@SuppressWarnings("unused")
	public void getOrder(Order O)
	{

	    String category = O.getCategory();
	    String item = O.getItem();
	    int price = O.getPrice();
	    int quantity = O.getQuantity();
	    int amount = price*quantity;
	    
		try {
			//Establish connection object	
			Connection conn = DriverManager.getConnection(url,"root","ShadeEragon@28");
		
		    //Create a statement object to send to database
			//Statement statement = conn.createStatement();
			PreparedStatement stmt=conn.prepareStatement("insert into cheesecake_management_tbl values(?,?,?,?,?)");

			stmt.setString(1,category);
			stmt.setString(2,item);
			stmt.setInt(3,price);
			stmt.setInt(4, quantity);
			stmt.setInt(5, amount);
			
			int i = stmt.executeUpdate();
			
			System.out.println("Inserted rows to order mgmt table\n\n");
			
		/*
            ResultSet resultSet2 = stmt.executeQuery("select * from cheesecake_customer_tbl");
			
			//Print result
			System.out.println("   Name 	     	Phone");
			System.out.println("===============================\n");
			
			/*while (resultSet2.next()) {
	            String name = resultSet2.getString("Name");
	            String phone = resultSet2.getString("Phone");
	      
	            System.out.println(name+"   "+phone);
	         }*/
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Error while insertion");
		}
	}
	
	public void displayOrder(int count) {
		
		try {
			//Establish connection object	
			Connection conn = DriverManager.getConnection(url,"root","ShadeEragon@28");
		
		    //Create a statement object to send to database
			PreparedStatement stmt=conn.prepareStatement("SELECT * FROM `cheesecake_management_tbl` LIMIT ?;");
			//Statement statement = conn.createStatement();
			
			stmt.setInt(1,count);
			//stmt.executeQuery();
			//Execute statement object
			ResultSet resultSet = stmt.executeQuery();
			
			//Print result
			System.out.println("Category  Item  Price  Quantity Total");
			System.out.println("=====================================\n");
			
			while (resultSet.next()) {
	            String category = resultSet.getString("Category");
	            String item = resultSet.getString("Item");
	            int price = resultSet.getInt("Price");
	            int quant = resultSet.getInt("Quantity");
	            int total = resultSet.getInt("Total");
	      
	            System.out.println(category+"   "+item+"    "+price+"     "+quant+"      "+total);
	         }
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Error while insertion");
			}

	}}


