package com.yc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.dao.BaseDao;

@Repository
public class BaseDaoMybatisImpl extends SqlSessionDaoSupport implements BaseDao{
	private String mapperLocation = "com.yc.mapper.";
	
	private <T> String getMapperId(T t,String sqlId){
		return mapperLocation+t.getClass().getSimpleName()+"Mapper."+sqlId ;
	}
	
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    	super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public <T> List<T> findAll(T t,String sqlId) {
		return super.getSqlSession().selectList(getMapperId(t, sqlId) , t );
	}
	
	@Override
	public <T> List<T> findAll(T t, Map map, String sqlId) {
		return super.getSqlSession().selectList(getMapperId(t, sqlId) , map );
	}
	
	@Override
	public <T> void add(T t, String sqlId) {
		super.getSqlSession().insert(getMapperId(t, sqlId) , t );
	}
	
	@Override
	public <T> void add(T t, Map map, String sqlId) {
		super.getSqlSession().insert(getMapperId(t, sqlId) , map );
	}
	
	@Override
	public <T> void addMany(T t, List list, String sqlId) {
		super.getSqlSession().insert(getMapperId(t, sqlId) , list );
	}
	
	@Override
	public <T> void update(T t, String sqlId) {
		super.getSqlSession().update(getMapperId(t, sqlId) , t );
	}
	
	@Override
	public <T> void update(T t, Map map, String sqlId) {
		super.getSqlSession().update(getMapperId(t, sqlId) , map );
	}
	
	@Override
	public <T> void updateMany(T t, List list, String sqlId) {
		super.getSqlSession().update(getMapperId(t, sqlId) , list );
	}
	
	@Override
	public <T> void delete(T t, String sqlId) {
		super.getSqlSession().delete(getMapperId(t, sqlId) , t );
	}
	
	@Override
	public <T> void delete(T t, Map map, String sqlId) {
		super.getSqlSession().delete(getMapperId(t, sqlId) , map );
	}
	
	@Override
	public <T> void deleteMany(T t, List list, String sqlId) {
		super.getSqlSession().delete(getMapperId(t, sqlId) , list );
	}
	
	@Override
	public <T> double findFunc(T t, String sqlId) {
		return super.getSqlSession().selectOne(getMapperId(t, sqlId) , t );
	}
	
	@Override
	public <T> double findFunc(T t, Map map, String sqlId) {
		return super.getSqlSession().selectOne(getMapperId(t, sqlId) , map );
	}
}
