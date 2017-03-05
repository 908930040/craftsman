package com.yc.biz.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Order;
import com.yc.bean.OrderContent;
import com.yc.bean.OrderItem;
import com.yc.bean.Reservation;
import com.yc.biz.AppointmentBiz;
import com.yc.dao.BaseDao;
import com.yc.model.AppointmentInfoModel;
import com.yc.model.OrderModel;

@Service
@Transactional(readOnly = true)
public class AppointmentBizImpl implements AppointmentBiz {
	private BaseDao baseDao;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public int appointmentOrder(OrderModel orderModel, Map<String, Object> session) {
		Order order=orderModel.getOrder();
		
		this.baseDao.add(order, "insert");
		
		OrderContent orderContent=orderModel.getOrderContent();
		orderContent.setOrdertbId(order.getOrdertbId());
		session.put("orderid", order.getOrdertbId());
		
		this.baseDao.add(orderContent, "insert");
		
		session.put("ordercontenttbId", orderContent.getOrdercontenttbId());
		Reservation reservation=new Reservation();
		List<Integer> orderItemIds=new ArrayList<Integer>();
		
		for(OrderItem oi:orderContent.getOrderitem()){
			oi.setOrdercontenttbId(orderContent.getOrdercontenttbId());
			Integer reservationtbPeriod=oi.getServiceTime();
			reservation.setOrdertbId(order.getOrdertbId());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = oi.getServiceDate();
			Date date;
			try {
				date = sdf.parse(strDate);
				reservation.setReservationtbDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			reservation.setReservationtbPeriod(reservationtbPeriod);
			reservation.setWorkertbId(order.getWorkertbId());
			
			this.baseDao.add(oi, "insertSelective");
			orderItemIds.add(oi.getOrderitemtbId());
			
		}
		session.put("orderItemIds", orderItemIds);
		
		this.baseDao.add(reservation, "insertSelective");
		
		return 1;
	}

	@Override
	public OrderModel createOrderModel(AppointmentInfoModel appointmentInfoModel) {
		Order order=createOrder(appointmentInfoModel);
		List<OrderItem> orderItems=createListOfOrderItem(appointmentInfoModel);
		OrderContent orderContent=new OrderContent();
		orderContent.setOrderitem(orderItems);
		OrderModel orderModel=new OrderModel();
		orderModel.setOrder(order);
		orderModel.setOrderContent(orderContent);
		return orderModel;
	}

	private Order createOrder(AppointmentInfoModel appointmentInfoModel) {
		Order order=new Order();
		order.setOrdertbStarttime(new Date());
		order.setOrdertbMoney(appointmentInfoModel.getServiceSearchTotalPrice());
		order.setOrdertbStatus(1);
		order.setOrdertbEvalstate(1);
		order.setOrdertbPaystatus(0);
		order.setUsertbId(appointmentInfoModel.getUserId());
		order.setWorkertbId(appointmentInfoModel.getWorkerId());
		return order;
	}
	private List<OrderItem> createListOfOrderItem(AppointmentInfoModel appointmentInfoModel) {
		List<OrderItem> orderItems=new ArrayList<OrderItem>();
		String content;
		OrderItem orderItem1=new OrderItem();
		orderItem1.setOrderitemtbName("服务项目");
		content=appointmentInfoModel.getServiceSearchInput();
		orderItem1.setOrderitemtbContent(content);
		orderItem1.setServiceTime(reservationperiodToInteger(appointmentInfoModel.getServiceTime()));
		orderItem1.setServiceDate(appointmentInfoModel.getServiceDate());
		orderItems.add(orderItem1);
		OrderItem orderItem2=new OrderItem();
		orderItem2.setOrderitemtbName("数量");
		content=appointmentInfoModel.getServiceNum().toString();
		orderItem2.setOrderitemtbContent(content);
		orderItem2.setServiceTime(reservationperiodToInteger(appointmentInfoModel.getServiceTime()));
		orderItem2.setServiceDate(appointmentInfoModel.getServiceDate());
		orderItems.add(orderItem2);
		OrderItem orderItem3=new OrderItem();
		orderItem3.setOrderitemtbName("价格");
		content=appointmentInfoModel.getSelectPrice();
		orderItem3.setOrderitemtbContent(content);
		orderItem3.setServiceTime(reservationperiodToInteger(appointmentInfoModel.getServiceTime()));
		orderItem3.setServiceDate(appointmentInfoModel.getServiceDate());
		orderItems.add(orderItem3);
		OrderItem orderItem4=new OrderItem();
		orderItem4.setOrderitemtbName("总价");
		content=appointmentInfoModel.getServiceSearchTotalPrice().toString();
		orderItem4.setOrderitemtbContent(content);
		orderItem4.setServiceTime(reservationperiodToInteger(appointmentInfoModel.getServiceTime()));
		orderItem4.setServiceDate(appointmentInfoModel.getServiceDate());
		orderItems.add(orderItem4);
		OrderItem orderItem5=new OrderItem();
		orderItem5.setOrderitemtbName("订单联系人");
		content=appointmentInfoModel.getUserName();
		orderItem5.setOrderitemtbContent(content);
		orderItem5.setServiceTime(reservationperiodToInteger(appointmentInfoModel.getServiceTime()));
		orderItem5.setServiceDate(appointmentInfoModel.getServiceDate());
		orderItems.add(orderItem5);
		OrderItem orderItem6=new OrderItem();
		orderItem6.setOrderitemtbName("服务地址");
		content=appointmentInfoModel.getUserAddress();
		orderItem6.setOrderitemtbContent(content);
		orderItem6.setServiceTime(reservationperiodToInteger(appointmentInfoModel.getServiceTime()));
		orderItem6.setServiceDate(appointmentInfoModel.getServiceDate());
		orderItems.add(orderItem6);
		OrderItem orderItem7=new OrderItem();
		orderItem7.setOrderitemtbName("服务时间");
		content=appointmentInfoModel.getServiceDate()+"-"+appointmentInfoModel.getServiceTime();
		orderItem7.setOrderitemtbContent(content);
		orderItem7.setServiceTime(reservationperiodToInteger(appointmentInfoModel.getServiceTime()));
		orderItem7.setServiceDate(appointmentInfoModel.getServiceDate());
		orderItems.add(orderItem7);
		OrderItem orderItem8=new OrderItem();
		orderItem8.setOrderitemtbName("联系方式");
		content=appointmentInfoModel.getUserTelephone();
		orderItem8.setOrderitemtbContent(content);
		orderItem8.setServiceTime(reservationperiodToInteger(appointmentInfoModel.getServiceTime()));
		orderItem8.setServiceDate(appointmentInfoModel.getServiceDate());
		orderItems.add(orderItem8);
		
		return orderItems;
	}
	private Integer reservationperiodToInteger(String reservationperiod) {
		if("早上".equals(reservationperiod)||"上午".equals(reservationperiod)){
			return 1;
		}else if("下午".equals(reservationperiod)){
			return 2;
		}else if("晚上".equals(reservationperiod)){
			return 3;
		}
		return 0;
	}
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	
}
