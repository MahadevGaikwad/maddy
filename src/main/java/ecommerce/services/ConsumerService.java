package ecommerce.services;

import java.util.List;

import ecommerce.entities.Consumer;

public interface ConsumerService {
	void registerConsumer(Consumer cust);
	
	List<Consumer> allCustomers();
	
	Consumer findById(int id);
	
	Consumer validate(String email,String pwd);
	
	boolean verifyUserId(String email);
	
	void updateProfile(Consumer cust);
}
