package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Customer;

public class CustomerConcreteDAO implements CustomerDAO{

	@Override
	public ArrayList<Customer> read() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		try (Connection con = Database.getConnection()){
			PreparedStatement ps = con.prepareStatement("SELECT name, address, zipcode, city, phone, business FROM dbo.customers");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
		        String address = rs.getString("address");
		        int zipcode = rs.getInt("zipcode");
		        String city = rs.getString("city");
		        int phone = rs.getInt("phone");
		        boolean business = rs.getBoolean("business");
				customers.add(new Customer(name, address, zipcode, city, phone, business));
			}
			return customers;
		}
		catch (SQLException e) {
			System.out.println("error");
		}
		
		return customers;
	}

	@Override
	public Customer read(int id) {
		String query = "SELECT name, address, zipcode, city, phone, business FROM dbo.customer";
		Customer result = null;
		
	    try (Connection con = Database.getConnection(); Statement stmt = con.createStatement()) {
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) {
	        String name = rs.getString("name");
	        String address = rs.getString("address");
	        int zipcode = rs.getInt("zipcode");
	        String city = rs.getString("city");
	        int phone = rs.getInt("phone");
	        boolean business = rs.getBoolean("business");
	        result = new Customer(name, address, zipcode, city, phone, business);
	      }
	    } catch (SQLException e) {
	    	
	    }
	    
	    return result;
	}

	@Override
	public void create(Customer customer) {
		try (Connection con = Database.getConnection()){
			PreparedStatement ps = con.prepareStatement("USE CSD-CSC-S212_10407570 "
					+ "INSERT INTO dbo.customer (name, address, zipcode, city, phone, busines)"
					+ "VALUES (?,?,?,?,?,?)");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setInt(3, customer.getZipCode());
			ps.setString(4, customer.getCity());
			ps.setInt(5, customer.getPhoneNumber());
			ps.setBoolean(6, customer.isBussiness());
		}
		catch (SQLException e) {
			System.out.println("error");
		}
	}

	@Override
	public void update(Customer customer) {
		try (Connection con = Database.getConnection()){
			PreparedStatement ps = con.prepareStatement("USE CSD-CSC-S212_10407570 "
					+ "update dbo.customer SET name=?, SET address=?, SET zipcode=?, SET city=?, SET phone=?, SET business=?"
					+ "WHERE id=?");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setInt(3, customer.getZipCode());
			ps.setString(4, customer.getCity());
			ps.setInt(5, customer.getPhoneNumber());
			ps.setBoolean(6, customer.isBussiness());
			ps.setInt(7, customer.getId());
		}
		catch (SQLException e) {
			System.out.println("error");
		}
	}

	@Override
	public void delete(Customer customer) {
		try (Connection con = Database.getConnection()){
			PreparedStatement ps = con.prepareStatement("USE CSD-CSC-S212_10407570 "
					+ "DELETE FROM dbo.customer WHERE id=?");
			ps.setInt(1, customer.getId());
		}
		catch (SQLException e) {
			System.out.println("error");
		}
	}
	
	
}
