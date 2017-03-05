package com.yc.biz;

import com.yc.bean.Order;
import com.yc.bean.OrderItem;

public interface OrderContentService {
	int quickorder(Order order,OrderItem orderItem2,
			OrderItem orderItem3,OrderItem orderItem4,OrderItem orderItem5);
}
