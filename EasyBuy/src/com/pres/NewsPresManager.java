package com.pres;

import java.util.Date;
import java.util.List;

import com.bean.NewsBean;
import com.bean.page.State;
import com.entity.News;
import com.facade.NewsFacade;

public class NewsPresManager {
	private NewsFacade newsFacade;

	public void setNewsFacade(NewsFacade newsFacade) {
		this.newsFacade = newsFacade;
	}

	// TODO getNews
	public List<NewsBean> getNews(State state) {
		return null;
	}

	public int addNews(NewsBean bean) {
		News n = new News();
		n.setTitle(bean.getTitle());
		n.setIsDisabled(false);
		n.setCreateOn(new Date());
		n.setContent(bean.getContent());
		News addNews = newsFacade.add(n);
		if (addNews != null) {
			return addNews.getId();
		}
		return -1;
	}
}
