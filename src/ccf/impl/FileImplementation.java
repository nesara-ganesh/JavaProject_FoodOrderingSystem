package ccf.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

//import java.util.Scanner;
import ccf.intf.*;
import ccf.vO.*;
import org.apache.log4j.Logger;

public class FileImplementation implements DataOperations{
	
	static Logger log = Logger.getLogger(FileImplementation.class.getName());
	@SuppressWarnings("all")
	@Override
	public void customerData(Customer C) {
		
		//System.out.println("Creating a file.");
		  try {
		      File myObj1 = new File("E://Eclipse/File/Cheesecake_Customer_Management.txt"); //Creating a new file at the specified path
		      log.info("File Created");
		      if (myObj1.createNewFile()) {
		        //System.out.println("File created: " + myObj1.getName()); //confirmation of file creation
		      //Writing to a file
			    try {
			        FileWriter myWriter1 = new FileWriter("E://Eclipse/File/Cheesecake_Customer_Management.txt"); //Setting the file to write 
			        
			        myWriter1.write("Customer Phone\tCustomer Name#\n"); //Writing to file
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
		
		System.out.println("\n\nCustomer Phone:\t"+C.getPhone());
		System.out.println("Customer name:\t"+C.getName());
		
		File file1 = new File("E://Eclipse/File/Cheesecake_Customer_Management.txt"); //Creating a new variable of type File with the desired file
        FileWriter fr1 = null; //Initializing the file writer
        try {
            fr1 = new FileWriter(file1, true); //Initializing Writing to the desired file
            fr1.write(C.getPhone()+"\t$"+C.getName()+"#\n"); //Appending the file
            
            log.info("Written to file successfully");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            log.info("Writing to file failed");
        }
        //in case of error closing the file
        finally
        {
            try
            {
                fr1.close();
                log.info("File closed");
            }
            catch (IOException e)
            {
                e.printStackTrace();
                log.info("Failed to close File");
            }
        }
		
	}
	@Override
	public void getOrder(Order O) {
		
		int price = O.getPrice() * O.getQuantity();
		File file1 = new File("E://Eclipse/File/Cheesecake_Management.txt"); //Creating a new variable of type File with the desired file
        FileWriter fr1 = null; //Initializing the file writer
        try {
            fr1 = new FileWriter(file1, true); //Initializing Writing to the desired file
            fr1.write(O.getCategory()+"\t$"+O.getItem()+"\t$"+O.getPrice()+"\t$"+O.getQuantity()+"\t\t$"+price+"#\n"); //Appending the file
            
            log.info("Written to file successfully");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            log.info("Writing to file failed");
        }
        //in case of error closing the file
        finally
        {
            try
            {
                fr1.close();
                log.info("File closed");
            }
            catch (IOException e)
            {
                e.printStackTrace();
                log.info("Failed to close File");
            }
        }
		
	}
	
	public void displayOrder(int count) {
		
		File file = new File("E://Eclipse/File/Cheesecake_Management.txt");
		int lines = count;
		int readLines = 0;
		  StringBuilder builder = new StringBuilder();
		  RandomAccessFile randomAccessFile = null;
		  try {
		    randomAccessFile = new RandomAccessFile(file, "r");
		    long fileLength = file.length() - 1;
		    // Set the pointer at the last of the file
		    randomAccessFile.seek(fileLength);
		    for(long pointer = fileLength; pointer >= 0; pointer--){
		      randomAccessFile.seek(pointer);
		      char c;
		      // read from the last one char at the time
		      c = (char)randomAccessFile.read(); 
		      // break when end of the line
		      if(c == '\n'){
		        readLines++;
		        if(readLines == lines)
		         break;
		      }
		      builder.append(c);
		    }
		    // Since line is read from the last so it 
		    // is in reverse so use reverse method to make it right
		    builder.reverse();
		    System.out.println("Order is\n"+builder.toString());
		  } catch (FileNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		  }
		  catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		  }finally{
		    if(randomAccessFile != null){
		      try {
		        randomAccessFile.close();
		      } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      }
		    }
		  }
		
		
	}
	
}

