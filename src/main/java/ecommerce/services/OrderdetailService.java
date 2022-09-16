package ecommerce.services;

import java.util.List;

import ecommerce.entities.Order;
import ecommerce.entities.OrderDetails;
import ecommerce.entities.Product;

public interface OrderdetailService {

	void saveOrderDetails(OrderDetails od);
	OrderDetails findById(int id);
	void deleteOrder(int id);
	List<OrderDetails> findByOrder(Order order);
	void updateProduct(OrderDetails p);
}
