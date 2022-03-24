package Runner;

import java.util.Calendar;

import controller.OrderController;
import controller.ProductController;
import model.Order;
import model.Product;
import persistence.Database;

public class Runner {
	public static void main(String[] args) {
		ProductController pc = new ProductController();
		Product a = new Product("key", "smth", 20, 30, 40, "Netherlands", 10, 15, 20);
		pc.createProduct(a);
	}

}
