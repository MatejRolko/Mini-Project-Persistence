package controller;

import java.util.ArrayList;

import model.Customer;
import persistence.CustomerConcreteDAO;

public class CustomerController {

	private CustomerConcreteDAO dao;

	public CustomerController() {
		dao = CustomerConcreteDAO.getInstance();
	}

	public Customer findByName(String name) {
		for (Customer customer : dao.read()) {
			if (customer.getName().equalsIgnoreCase(name)) {
				return customer;
			}
		}
		return null;
	}

	public Customer findById(int id) {
		for (Customer customer : dao.read()) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}

	public void createCustomer(Customer customer) {
		dao.create(customer);
	}
	
	public void updateCustomer(Customer customer) {
		dao.update(customer);
	}

	public void deleteCustomer(Customer customer) {
		dao.delete(customer);
	}

	public ArrayList<Customer> getAllCustomers() {
		return dao.read();
	}

	public boolean isBusiness(Customer customer) {
		return customer.isBussiness();
	}

}
