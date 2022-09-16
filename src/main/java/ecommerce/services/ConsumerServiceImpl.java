package ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.entities.Consumer;
import ecommerce.repository.ConsumerRepository;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	
	@Autowired private ConsumerRepository dao;

	@Override
	public void registerConsumer(Consumer cust) {
		
		dao.save(cust);
	}

	@Override
	public List<Consumer> allCustomers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Consumer findById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public Consumer validate(String email, String pwd) {
		Consumer cc=dao.findByEmail(email);
		if(cc!=null && cc.getPwd().equals(pwd)) {
			return cc;
		}
		return null;
	}
	
	@Override
	public boolean verifyUserId(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email)!=null;
	}

	@Override
	public void updateProfile(Consumer cust) {
		// TODO Auto-generated method stub
		if(cust.getPwd().equals("") || cust.getPwd()==null) {
			cust.setPwd(findById(cust.getId()).getPwd());
		}
		dao.save(cust);	
	}
	
}
