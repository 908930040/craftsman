package com.yc.model;

import com.yc.bean.Order;
import com.yc.bean.OrderContent;

public class OrderModel {
	private OrderContent orderContent;
	private Order order;
	public OrderContent getOrderContent() {
		return orderContent;
	}
	public void setOrderContent(OrderContent orderContent) {
		this.orderContent = orderContent;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderBean1 [orderContent=" + orderContent + ", order=" + order + "]";
	}
		
}
