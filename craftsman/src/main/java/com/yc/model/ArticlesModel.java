package com.yc.model;

import java.util.List;

import com.yc.bean.Article;




public class ArticlesModel {
	
	private List<Article> rows;
	private int total;
	public List<Article> getRows() {
		return rows;
	}
	public void setRows(List<Article> rows) {
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
