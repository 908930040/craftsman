package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.BaseDao;
import com.yc.bean.Admin;
import com.yc.biz.AdminBiz;

@Service
@Transactional(readOnly = true)
public class AdminBizImpl implements AdminBiz {
	private BaseDao baseDao;
	
	@Override
	public Admin getAdmin(Admin admin) {
		List<Admin> list = this.baseDao.findAll(admin, "getAdminByAdmin");
		return list!=null&&list.size()>0 ? list.get(0) : null;
	}

	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
}
