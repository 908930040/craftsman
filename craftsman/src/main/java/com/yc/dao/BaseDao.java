package com.yc.dao;

import java.util.List;
import java.util.Map;


public interface BaseDao {
	public <T> List<T> findAll(T t,String sqlId);
	public <T> List<T> findAll(T t,Map map,String sqlId);
	
	public <T> void add(T t,String sqlId);
	public <T> void add(T t,Map map,String sqlId);
	public <T> void addMany(T t,List list,String sqlId);
	
	public <T> void update(T t,String sqlId);
	public <T> void update(T t,Map map,String sqlId);
	public <T> void updateMany(T t,List list,String sqlId);
	
	public <T> void delete(T t,String sqlId);
	public <T> void delete(T t,Map map,String sqlId);
	public <T> void deleteMany(T t,List list,String sqlId);
	
	public <T> double findFunc(T t,String sqlId);
	public <T> double findFunc(T t,Map map,String sqlId);
	
}
