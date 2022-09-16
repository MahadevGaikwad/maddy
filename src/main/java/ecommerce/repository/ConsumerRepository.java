package ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.entities.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
	
	Consumer findByEmail(String email);
}
