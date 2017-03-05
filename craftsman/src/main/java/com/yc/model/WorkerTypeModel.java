package com.yc.model;

import java.util.List;

import com.yc.bean.WorkerType;


public class WorkerTypeModel {
	
	private List<WorkerType> rows;
	private int total;
	public List<WorkerType> getRows() {
		return rows;
	}
	public void setRows(List<WorkerType> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "ArticlesBean [rows=" + rows + ", total=" + total + "]";
	}
	
	
}
