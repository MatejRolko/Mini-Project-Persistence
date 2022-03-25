package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Customer;

public class CustomerConcreteDAO implements CustomerDAO {

	private static CustomerConcreteDAO instance = new CustomerConcreteDAO();

	private CustomerConcreteDAO() {
	}

	public static CustomerConcreteDAO getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Customer> read() {
		ArrayList<Customer> customers = new ArrayList<Customer>();

		try (Connection con = Database.getInstance().getConnection()) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM dbo.customer");
			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				int zipcode = rs.getInt("zipcode");
				String city = rs.getString("city");
				int phone = rs.getInt("phone");
				boolean business = rs.getBoolean("business");
				Customer customer = new Customer(name, address, zipcode, city, phone, business);
				customer.setId(rs.getInt("id"));
				customers.add(customer);
			}

		} catch (SQLException e) {
			System.out.println("error");
		}
		return customers;
	}

	@Override
	public Customer read(int id) {
		try (Connection con = Database.getInstance().getConnection()) {
			PreparedStatement statement = (PreparedStatement) con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM dbo.customer WHERE id=?");
			statement.setInt(1, id);
			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				int zipcode = rs.getInt("zipcode");
				String city = rs.getString("city");
				int phone = rs.getInt("phone");
				boolean business = rs.getBoolean("business");
				Customer customer = new Customer(name, address, zipcode, city, phone, business);
				customer.setId(id);
				return customer;
			}
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public void create(Customer customer) {
		try (Connection con = Database.getInstance().getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO dbo.customer (name, address, zipcode, city, phone, business)"
							+ "VALUES (?,?,?,?,?,?)");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setInt(3, customer.getZipCode());
			ps.setString(4, customer.getCity());
			ps.setInt(5, customer.getPhoneNumber());
			ps.setBoolean(6, customer.isBusiness());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("error");
		}
	}

	@Override
	public void update(Customer customer) {
		try (Connection con = Database.getInstance().getConnection()) {
			PreparedStatement ps = con.prepareStatement("USE CSD-CSC-S212_10407570 "
					+ "update dbo.customer SET name=?, SET address=?, SET zipcode=?, SET city=?, SET phone=?, SET business=?"
					+ "WHERE id=?");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setInt(3, customer.getZipCode());
			ps.setString(4, customer.getCity());
			ps.setInt(5, customer.getPhoneNumber());
			ps.setBoolean(6, customer.isBusiness());
			ps.setInt(7, customer.getId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("error");
		}
	}

	@Override
	public void delete(Customer customer) {
		try (Connection con = Database.getInstance().getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("USE CSD-CSC-S212_10407570 DELETE FROM dbo.customer WHERE id=?");
			ps.setInt(1, customer.getId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("error");
		}
	}

}
