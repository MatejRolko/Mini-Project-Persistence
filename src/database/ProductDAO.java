package database;

import java.util.ArrayList;
import model.Product;

public interface ProductDAO {
	
	ArrayList<Product> read();
	Product read(int id);
	void create(Product	product);
	void update(Product product);
	void delete(Product product);
	
}
