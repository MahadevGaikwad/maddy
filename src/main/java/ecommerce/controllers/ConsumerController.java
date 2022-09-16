package ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.DTO.LoginDTO;
import ecommerce.DTO.Response;
import ecommerce.entities.Consumer;
import ecommerce.services.ConsumerService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class ConsumerController {
	
	@Autowired 
	private ConsumerService customerService;
	
	@PostMapping
	@ApiOperation(value="Save a customer details",response = Consumer.class)
	public ResponseEntity<?> save(@RequestBody Consumer cust) {		
	try {	customerService.registerConsumer(cust);
		return Response.success(cust);
	}
	
	catch(Exception e) {
		
		return Response.error(e);
	}
	}
	
	@GetMapping
	@ApiOperation(value="List all customers",response=Iterable.class)
	public ResponseEntity<?> findAllCustomers() {
		List<Consumer> result = customerService.allCustomers();
		return Response.success(result);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Display the details of a customer")
	public ResponseEntity<?> findCustomerById(@PathVariable("id") int id) {
		Consumer result = customerService.findById(id);
		return Response.success(result);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Consumer user=customerService.validate(dto.getEmail(),dto.getPwd());
		if(user!=null)
			return Response.success(user);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateProfile(@RequestBody Consumer cust,@PathVariable("id") int id) {
		customerService.updateProfile(cust);
		return Response.status(HttpStatus.OK);
	}

}
