package com.yc.biz;

import java.util.List;

import com.yc.bean.Pagination;
import com.yc.bean.WorkerType;
import com.yc.model.PaginationModel;
import com.yc.model.WorkerTypeModel;


public interface WorkerTypeBiz {

	WorkerTypeModel findWorkerType();

	/*
	 * 插入一条数据
	 */
	int insertOne(WorkerType workerType);

	/*
	 * 获取所有的记录
	 */
	PaginationModel<WorkerType> getAll();

	/*
	 * 分页查询
	 */
	WorkerTypeModel listBypagination(Pagination pagination);

	/*
	 * 更新一条数据
	 */
	int updateOne(WorkerType workerType);

	/*
	 * 删除一台数据
	 */
	int deleteOne(int workertypetbId);
	
	List<WorkerType> findWorkerTypes();

}
