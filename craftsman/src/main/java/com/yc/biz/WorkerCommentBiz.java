package com.yc.biz;

import java.util.List;

import com.yc.bean.Pagination;
import com.yc.bean.WorkerComment;
import com.yc.model.CommentModel;



public interface WorkerCommentBiz {
	List<CommentModel> findPartComment(Pagination pagination);
	int findCommentCount(Pagination pagination);
	int addComment(WorkerComment workerComment);
	int findByOrderId(WorkerComment workerComment);
}
