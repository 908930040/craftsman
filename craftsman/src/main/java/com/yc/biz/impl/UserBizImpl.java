package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Pagination;
import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.dao.BaseDao;
import com.yc.model.UserModel;

@Service
@Transactional(readOnly=true)
public class UserBizImpl implements UserBiz{
	
	private BaseDao baseDao;
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public UserModel listUser(Pagination pagination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User login(User user) {
		List<User> list= baseDao.findAll( user, "findUserByUser");
	   return list!=null && list.size()>0?list.get(0):null;
	}

	@Override
	public boolean check(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePwd(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User changeInfo(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
