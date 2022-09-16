package ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.entities.Order;
import ecommerce.entities.OrderDetails;
import ecommerce.entities.Product;
import ecommerce.repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderdetailService {

	@Autowired OrderDetailsRepository dao;
	@Override
	public void saveOrderDetails(OrderDetails od) {
		// TODO Auto-generated method stub
		dao.save(od);
	}

	@Override
	public OrderDetails findById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public List<OrderDetails> findByOrder(Order order) {
		// TODO Auto-generated method stub
		return dao.findByOrder(order);
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		OrderDetails d=dao.getById(id);
		dao.delete(d);
	}

	@Override
	public void updateProduct(OrderDetails p) {
		OrderDetails pp=dao.getById(p.getId());
	    dao.save(p);
		
	}

	

}
