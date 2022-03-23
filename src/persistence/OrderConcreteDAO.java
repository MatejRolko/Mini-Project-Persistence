package persistence;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Order;
import model.SalesLineItem;

public class OrderConcreteDAO implements OrderDAO {
	private static OrderConcreteDAO instance;
	
	private OrderConcreteDAO() {
	}
	
	public static OrderConcreteDAO getInstance() {
		if(instance == null) {
			instance = new OrderConcreteDAO();
		}
		return instance;
	}
	@Override
	public ArrayList<Order> read() {
		ArrayList<Order> list = new ArrayList<Order>();
		try(Connection con = Database.getConnection()){
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("use CSC-CSD-S212_10407574"
					+ " select * from dbo.saleOrder"); 
			while(rs.next()) {
				int id = rs.getInt("id");
				Date date = rs.getTimestamp("date");
				int price = rs.getInt("amount");
				Date deliveryDate = rs.getTimestamp("deliveryDate");
				String deliveryStatus = rs.getString("deliveryStatus");
				String delivery = rs.getString("delivery");
				int customerId = rs.getInt("customer_id");
				list.add(new Order(id, date, price, deliveryDate, deliveryStatus,
						delivery,customerId));
				}
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order read(int id) {
		Order order = null;
		try(Connection con = Database.getConnection()){
			PreparedStatement ps = (PreparedStatement) con.createStatement();
			ResultSet rs = ps.executeQuery("use CSC-CSD-S212_10407574"
					+" select * from dbo.saleOrder where id = ?");
			ps.setInt(1, id);
			while(rs.next()) {
				Date date = rs.getTimestamp("date");
				int price = rs.getInt("amount");
				Date deliveryDate = rs.getTimestamp("deliveryDate");
				String deliveryStatus = rs.getString("deliveryStatus");
				String delivery = rs.getString("delivery");
				int customerId = rs.getInt("customer_id");
				return new Order(id, date, price, deliveryDate, deliveryStatus,
						delivery,customerId);
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void create(Order order) {
		try(Connection con = Database.getConnection()){
			PreparedStatement ps = con.prepareStatement("use CSC-CSD-S212_10407574 "
					+ " insert into dbo.saleOrder(date, amount, deliveryDate, deliveryStatus"
					+ " delivery, customer_id) values (?,?,?,?,?,?) ");
			ps.setTimestamp(1, order.getSqlDate());
			ps.setDouble(2,order.getPrice());
			ps.setTimestamp(3, order.getSqlDeliveryDate());
			ps.setString(4, order.getDeliveryStatus());
			ps.setString(5, order.getDelivery());
			ps.setInt(6,order.getCustomerId());
			ps.execute();
			setItems(order);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Order order, int id) {
		try (Connection con = Database.getConnection()){
			PreparedStatement ps = con.prepareStatement("USE CSC-CSD-S212_10407574  "
					+ "update dbo.saleOrder SET date=?, SET amount=?, SET deliveryDate=?, "
					+ "SET deliveryStatus=?, SET delivery=?, SET customer_id=?"
					+ "WHERE id=?");
			ps.setTimestamp(1, order.getSqlDate());
			ps.setDouble(2,order.getPrice());
			ps.setTimestamp(3, order.getSqlDeliveryDate());
			ps.setString(4, order.getDeliveryStatus());
			ps.setString(5, order.getDelivery());
			ps.setInt(6,order.getCustomerId());
			ps.setInt(7, id);
			ps.execute();
		}
		catch (SQLException e) {
			System.out.println("error");
		}
		
	}

	@Override
	public void delete(int id) {
		try(Connection con = Database.getConnection()){
			PreparedStatement ps = con.prepareStatement("use CSC-CSD-S212_10407574 "
					+ " delete from dbo.saleOrder where id = ?");
			ps.setInt(1, id);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void setItems(Order order) {
		try(Connection con = Database.getConnection()){
			for(SalesLineItem i:order.getProducts()) {
				PreparedStatement ps = con.prepareStatement("use CSC-CSD-S212_10407574 "
						+ "insert into dbo.saleItems(amount, product_id) values("
						+ "?,?) where saleOrder_id = ? ");
				ps.setInt(1, i.getAmount());
				ps.setInt(2, i.getProduct().getId());
				ps.setInt(3, order.getId());
				ps.execute();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer getNextOrderId() {
		Integer id = null;
		try(Connection con = Database.getConnection()){
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("use CSC-CSD-S212_10407574"
					+ " SELECT TOP 1 id FROM dbo.saleOrder "
					+ "ORDER BY id DESC ");
			while(rs.next()) {
				id = rs.getInt("id") +1;
				}
			return id;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	

}
