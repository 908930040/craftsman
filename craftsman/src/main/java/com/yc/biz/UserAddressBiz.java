package com.yc.biz;

import java.util.List;

import com.yc.bean.UserAddress;


public interface UserAddressBiz {
	
	
	public boolean changeAddress(List<UserAddress> list);
	public List<UserAddress> getAddressByUserTbId(Integer userId);
}
