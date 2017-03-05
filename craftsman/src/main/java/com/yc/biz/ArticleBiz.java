package com.yc.biz;

import com.yc.bean.Article;
import com.yc.bean.Pagination;
import com.yc.model.ArticlesModel;

public interface ArticleBiz {
	/*
	 * 分页查询
	 */
	public  ArticlesModel  list(Pagination pagination);
	
	/*
	 * 添加
	 */
	public int insertOne(Article article);
	/*
	 * 删除
	 */
	public int deleteOne(Integer  articletbId);
	/*
	 * 更新
	 */
	public int updateOne(Article article);
	
	
}
