package com.yc.model;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class WorkerCommentModel {
	
	private List<CommentModel> rows;
	private int total;
	public List<CommentModel> getRows() {
		return rows;
	}
	public void setRows(List<CommentModel> rows) {
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
		return "WorkerCommentBean [rows=" + rows + ", total=" + total + "]";
	}
}
