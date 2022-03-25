package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;

public class ProductConcreteDAO implements ProductDAO {

	private static ProductConcreteDAO instance = new ProductConcreteDAO();

	public static ProductConcreteDAO getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Product> read() {
		ArrayList<Product> products = new ArrayList<Product>();

		try (Connection con = Database2.getConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM dbo.product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				float purchasePrice = rs.getFloat("purchasePrice");
				float salesPrice = rs.getFloat("salesPrice");
				float rentPrice = rs.getFloat("rentPrice");
				String country = rs.getString("countryOfOrigin");
				int minStock = rs.getInt("minStock");
				int stock = rs.getInt("stock");
				int id = rs.getInt("id");

				products.add(
						new Product(name, null, purchasePrice, salesPrice, rentPrice, country, minStock, stock, id));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product read(int id) {
		try (Connection con = Database2.getConnection()) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM dbo.product");
			while (rs.next()) {
				String name = rs.getString("name");
				float purchasePrice = rs.getFloat("purchasePrice");
				float salesPrice = rs.getFloat("salesPrice");
				float rentPrice = rs.getFloat("rentPrice");
				String country = rs.getString("countryOfOrigin");
				int minStock = rs.getInt("minStock");
				int stock = rs.getInt("stock");
				int cid = rs.getInt("id");

				return new Product(name, null, purchasePrice, salesPrice, rentPrice, country, minStock, stock, cid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void create(Product product) {
		try (Connection con = Database2.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO dbo.product (name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, stock)"
							+ "VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPurchasePrice());
			ps.setDouble(3, product.getSalesPrice());
			ps.setDouble(4, product.getRentPrice());
			ps.setString(5, product.getCountry());
			ps.setInt(6, product.getMinStock());
			ps.setInt(7, product.getStock());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Product product) {
		try (Connection con = Database2.getConnection()) {
			PreparedStatement ps = con.prepareStatement("USE CSD-CSC-S212_10407570 "
					+ "UPDATE dbo.product SET name=?, SET purchasePrice=?, SET salesPrice=?, SET rentPrice=?, "
					+ "SET countryOFOrigin=?, SET minstock=?, SET stock=?" + "WHERE id=?");
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPurchasePrice());
			ps.setDouble(3, product.getSalesPrice());
			ps.setDouble(4, product.getRentPrice());
			ps.setString(5, product.getCountry());
			ps.setInt(6, product.getMinStock());
			ps.setInt(7, product.getStock());
			ps.setInt(8, product.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Product product) {
		try (Connection con = Database2.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("USE CSD-CSC-S212_10407570 " + "DELETE FROM dbo.product WHERE id=?");
			ps.setInt(1, product.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
