package com.facade;

import java.util.List;

import com.bean.NewsBean;
import com.dao.NewsDao;
import com.entity.News;

public class NewsFacade {
	private NewsDao newsDao;

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public News add(News news) {
		return newsDao.addNews(news);
	}

	public News update(News news) {
		return newsDao.updateNews(news);
	}

	public List<NewsBean> getNewsBean() {
		return newsDao.getListByDTO(NewsBean.class);
	}
}
