package ecommerce.services;

import java.util.List;

import ecommerce.entities.Consumer;
import ecommerce.entities.Order;

public interface OrderService {

	Order saveOrder(Order order);
	List<Order> getAllOrders();
	List<Order> getCustomerOrders(Consumer customer);
	Order findById(int id);
	void deleteOrder(int id);
}
