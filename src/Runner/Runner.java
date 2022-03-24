package Runner;

import java.util.Calendar;

import controller.OrderController;
import model.Order;
import persistence.Database;

public class Runner {
	public static void main(String[] args) {
		OrderController cntrl = new OrderController();
		Database.getInstance().getConnection();
		System.out.println(cntrl.read());
	}

}
