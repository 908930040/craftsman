package com.yc.biz;

import java.util.Map;

import com.yc.bean.Order;
import com.yc.bean.Pagination;
import com.yc.bean.Worker;
import com.yc.model.DemandInfoModel;
import com.yc.model.OrderDetailModel;
import com.yc.model.OrderModel;
import com.yc.model.PaginationModel;

public interface OrderService {
	/**
	 * 分页查询订单信息
	 */
	PaginationModel<Order> listByPagination(Pagination pagination);
	
	/**
	 * 查询订单详情
	 * 
	 */
	OrderDetailModel findDetailByOrderId(Integer orderid);
	/*
	 * 修改订单
	 */
	
	public int update(Order order);
	/*
	 * 删除订单
	 */
	int deleteByOrderid(int orderid);
	

	public int quickorder(OrderModel orderBean,Map<String,Object> session);
	/**
	 * 通过客户提交的需求信息匹配工人
	 * @param ddb
	 * @return
	 */
	public Worker selectWorkerByDemandInfo(DemandInfoModel ddb);
	/**
	 * 将响应的时间段转化为对应的标识符
	 */
	public Integer reservationperiodToInteger(String reservationperiod);
	/**
	 * 获取匹配服务的工人id
	 */
	public Integer getWorkerId(DemandInfoModel demandInfo);
	/**
	 * 生成orderBean
	 */
	public OrderModel createOrderBean(DemandInfoModel demandInfo);
}
