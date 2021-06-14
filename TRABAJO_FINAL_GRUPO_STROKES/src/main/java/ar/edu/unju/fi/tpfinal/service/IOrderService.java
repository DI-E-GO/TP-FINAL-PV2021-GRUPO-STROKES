package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderService {
	public Order getOrder();
	public void addOrder(Order order);
	public void deleteOrder(Long orderNumber);
	public Optional<Order> getOrder(Long orderNumber);
	public List<Order> getOrders();
}
