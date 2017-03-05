package com.yc.biz;

import java.util.List;

import com.yc.bean.Pagination;
import com.yc.bean.Worker;
import com.yc.bean.WorkerType;
import com.yc.model.WorkerModel;

public interface WorkerBiz {
	/*
	 * @param rows每页的行数
	 * 
	 * @param page查询的页数
	 */
	public WorkerModel listWorker(Pagination pagination);

	public int getCount();

	List<Worker> findWorkerByWorkerType(WorkerType workerType);

	int insertOne(Worker worker);
	
	int updateOne(Worker worker);
	
	int deleteOne(Integer workertbId);
	
	public Worker getWorkerInfoById(Integer workerId);

}
