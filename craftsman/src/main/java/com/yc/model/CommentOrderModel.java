package com.yc.model;

import com.yc.bean.Order;
import com.yc.bean.WorkerComment;

public class CommentOrderModel {
	private WorkerComment workerComment;
	private Order order;
	public WorkerComment getWorkerComment() {
		return workerComment;
	}
	public void setWorkerComment(WorkerComment workerComment) {
		this.workerComment = workerComment;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "CommentOrderBean [workerComment=" + workerComment + ", order="
				+ order + "]";
	}
}
