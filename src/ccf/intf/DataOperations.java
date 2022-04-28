package ccf.intf;

import java.sql.SQLException;

import ccf.vO.*;

public interface DataOperations {
	
	//Collect Customer Data
	void customerData(Customer C) throws ClassNotFoundException, SQLException;
	//Take the order from the customer
	void getOrder(Order O);
}
