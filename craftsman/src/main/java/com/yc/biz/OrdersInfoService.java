package com.yc.biz;

import com.yc.bean.User;
import com.yc.model.ShowOrdersModel;

public interface OrdersInfoService {
	public ShowOrdersModel getShowOrdersBean(User user);

}
