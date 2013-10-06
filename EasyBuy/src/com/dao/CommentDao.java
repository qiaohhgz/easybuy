package com.dao;

import com.dao.BaseDao;
import com.entity.Comment;

public class CommentDao extends BaseDao<Comment> {

	public Comment find(int id) {
		return null;
	}

	public void addComment(Comment obj) {
		super.saveOrUpdate(obj);
	}
}
