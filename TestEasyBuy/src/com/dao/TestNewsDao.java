package com.dao;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.AbstractSpringTest;
import com.bean.NewsBean;
import com.entity.News;

public class TestNewsDao extends AbstractSpringTest {
	@Test
	public void testFind() {
		newsDao.getNewsById(4);
	}

	@Test
	public void testAddNews() {
		News n = new News();
		n.setCreateOn(new Date());
		n.setContent("content");
		n.setTitle("title");
		newsDao.addNews(n);
	}

	@Test
	public void testUpdateNews() {
		News n = new News();
		n.setId(4);
		n.setCreateOn(new Date());
		n.setContent("content");
		n.setTitle("title");
		newsDao.update(n);
	}

	@Test
	public void testGetListMap() {
		newsDao.getListMap();
	}

	@Test
	public void testGetListMapByFilter() {
		newsDao.getListMapByFilter(0, 2, null, null);
	}

	@Test
	public void testGetListBeanOrCount() {
		int count = ((Long) newsDao.getListBeanOrCount(true, 0, 10, "a", "a", "title", 1).get(0)).intValue();
		System.out.println(count);
		List<NewsBean> list = newsDao.getListBeanOrCount(false, 0, 10, "a", "a", "title", 1);
		for (NewsBean bean : list) {
			System.out.println(MessageFormat.format("id:{0} title:{1} content:{2} createOn:{3} isDisabled:{4}", new Object[] { bean.getId(), bean.getTitle(),
					bean.getContent(), bean.getCreateOn(), bean.getIsDisabled() }));
		}
	}

	@Test
	public void testMessageFormat() {
		String str = MessageFormat.format("SELECT {0}.* FROM {0} WHERE {1} like {2}", new Object[] { "News", "title",
				"%a%" });
		System.out.println(str);
	}
}
