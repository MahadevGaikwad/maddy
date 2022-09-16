package ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.entities.Consumer;
import ecommerce.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByConsumer(Consumer consumer);
}
