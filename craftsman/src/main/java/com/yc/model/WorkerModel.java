package com.yc.model;

import java.util.List;

import com.yc.bean.Worker;


public class WorkerModel {
	private List<Worker> rows;
	private int total;

	public List<Worker> getRows() {
		return rows;
	}

	public void setRows(List<Worker> rows) {
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
		return "UserBean [rows=" + rows + ", total=" + total + "]";
	}

}
