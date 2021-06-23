/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;

/**
 * @author Diego
 *
 */
@Service
public class OrderDetailServiceImp implements IOrderDetailService {
	@Autowired
	IOrderDetailRepository orderDetailRepository;
	
	@Autowired
	OrderDetail orderDetail;
	
	@Override
	public OrderDetail getOrderDetail() {
		// TODO Auto-generated method stub
		return orderDetail;
	}

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		orderDetailRepository.save(orderDetail);
	}

	@Override
	public void deleteOrderDetail(Long id) {
		// TODO Auto-generated method stub
		orderDetailRepository.deleteById(id);
	}

	@Override
	public Optional<OrderDetail> getOrderDetail(Long id) {
		// TODO Auto-generated method stub
		return orderDetailRepository.findById(id);
	}

	@Override
	public List<OrderDetail> getOrderDetails() {
		// TODO Auto-generated method stub
		return orderDetailRepository.findAll();
	}

}
