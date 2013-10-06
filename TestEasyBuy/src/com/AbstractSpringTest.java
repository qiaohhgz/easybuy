package com;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.dao.NewsDao;
import com.facade.CategoryFacade;
import com.facade.NewsFacade;

@ContextConfiguration(locations = { "classpath:applicationContext-AnnotationSessionFactory.xml",
		"classpath:applicationContext-bean.xml", "classpath:applicationContext-jdbc.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public abstract class AbstractSpringTest extends AbstractTransactionalJUnit4SpringContextTests {
	protected NewsDao newsDao;

	protected NewsFacade newsFacade;
	protected CategoryFacade categoryFacade;

	@Autowired
	public void setCategoryFacade(CategoryFacade categoryFacade) {
		this.categoryFacade = categoryFacade;
	}

	@Resource(name = "newsDao")
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	@Autowired
	public void setNewsFacade(NewsFacade newsFacade) {
		this.newsFacade = newsFacade;
	}
}
