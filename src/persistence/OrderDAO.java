package persistence;

import java.util.ArrayList;

import model.Order;

public interface OrderDAO {
	ArrayList<Order> read();
	Order read(int id);
	void create(Order order);
	void update(Order order, int id);
	void delete(int id);
	void setItems(Order order);
	Integer getNextOrderId();
}
