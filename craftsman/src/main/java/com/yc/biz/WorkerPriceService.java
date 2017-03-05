package com.yc.biz;

import java.util.List;

import com.yc.bean.Pagination;
import com.yc.bean.Workprice;
import com.yc.model.PaginationModel;


public interface WorkerPriceService {
	public  List<Workprice> selectPriceService(Pagination pagination);
	public   PaginationModel<Workprice> selectByPagination(Pagination pagination);
	public int deleteById(Integer workpricetbId);
	public int insertOne(Workprice workprice);
	public int updateOne(Workprice workprice);
}
