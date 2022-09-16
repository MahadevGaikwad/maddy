package ecommerce.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	private Date orderDate;
	@ManyToOne
	@JoinColumn(name="customerId")
	private Consumer consumer;
	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;
	@ManyToOne
	@JoinColumn(name="paymentId")
	private Payment payment;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Consumer getCustomer() {
		return consumer;
	}
	public void setCustomer(Consumer consumer) {
		this.consumer = consumer;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderDate=" + orderDate + ", customer=" + consumer + "]";
	}
	
	
}
