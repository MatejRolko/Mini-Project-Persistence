package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.CustomerController;
import model.Customer;

class TestCustomerClasses {
	
	CustomerController cntrl = new CustomerController();

	@Test
	void test() {
		
		String name = "Peter";
        String address = "Anna A Vej";
        int zipcode = 9200;
        String city = "Aalborg";
        int phone = 1234456;
        boolean business = false; 
        
        Customer testCustomer = new Customer(name, address, zipcode, city, phone, business);
		
		System.out.println(cntrl.getCustomerById(1).getName());
		
		

	}

}
