package com.yc.model;

import java.util.List;

import com.yc.bean.Order;
import com.yc.bean.OrderItem;
import com.yc.bean.Worker;


public class OrderDetailModel {
	private Order order;
	private List<OrderItem> item;
	private Worker worker;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderDetailBean [order=" + order + ", item=" + item + ", worker=" + worker + "]";
	}

	public List<OrderItem> getItem() {
		return item;
	}

	public void setItem(List<OrderItem> item) {
		this.item = item;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

}
