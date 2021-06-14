package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;

public interface IOrderDetailService{
	public OrderDetail getOrderDetail();
	public void addOrderDetail(OrderDetail orderDetail);
	public void deleteOrderDetail(Long orderNumber);
	public Optional<OrderDetail> getOrderDetail(Long orderNumber);
	public List<OrderDetail> getOrderDetails();
}
