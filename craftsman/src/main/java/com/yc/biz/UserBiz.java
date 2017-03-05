package com.yc.biz;

import com.yc.bean.Pagination;
import com.yc.bean.User;
import com.yc.model.UserModel;

public interface UserBiz {
	/*
	 * @param rows每页的行数
	 * @param page查询的页数
	 */
	public  UserModel listUser(Pagination pagination);
	public int getCount();
	public int addUser(User user);
	public User login(User user);
	public boolean check(User user);

	public boolean changePwd( User user);
	public User changeInfo( User user);
	
}
