package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;

public interface IOrderDetailService {
	public OrderDetail getOrderDetail();
	public void addOrderDetail(OrderDetail orderDetail);
	public void deleteOrderDetail(Long id);
	public Optional<OrderDetail> getOrderDetail(Long id);
	public List<OrderDetail> getOrderDetails();
}
