/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.repository.IOrderRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

/**
 * @author Diego
 *
 */
@Service
public class OrderServiceImp implements IOrderService {
	
	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	Order order;

	@Override
	public Order getOrder() {
		// TODO Auto-generated method stub
		return order;
	}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Long orderNumber) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(orderNumber);
	}

	@Override
	public Optional<Order> getOrder(Long orderNumber) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderNumber);
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public List<Order> buscarPorEstado(String status) {
		// TODO Auto-generated method stub
		return orderRepository.findByStatus(status);
	}

}
