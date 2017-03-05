package com.yc.biz;

import java.util.Map;

import com.yc.model.AppointmentInfoModel;
import com.yc.model.OrderModel;


public interface AppointmentBiz {
	/**
	 * 插入预约订单
	 * @param orderBean
	 * @param session
	 * @return
	 */
	public int appointmentOrder(OrderModel orderModel,Map<String,Object> session);
	/**
	 * 生成orderBean
	 */
	public OrderModel createOrderModel(AppointmentInfoModel appointmentInfoModel);

}
