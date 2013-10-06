package com.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.bean.NewsBean;
import com.entity.News;

public class NewsDao extends BaseDao<News> {

	public News getNewsById(int id) {
		return super.loadByUniqueAttribute("newsId", id);
	}

	public News addNews(News news) {
		return super.save(news);
	}

	public News updateNews(News news) {
		return super.update(news);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getListByDTO(final Class<T> dto) {
		return getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder queryString = new StringBuilder();
				queryString.append("SELECT id as id,title as title,content as content,createOn as createOn FROM "
						+ getClassName());
				Query query = session.createQuery(queryString.toString());
				query.setResultTransformer(Transformers.aliasToBean(dto));
				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getListMap() {
		return getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder queryString = new StringBuilder();
				queryString.append("SELECT title as title, createOn as createOn FROM " + getClassName());
				Query query = session.createQuery(queryString.toString());
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				List list = query.list();
				return list;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<NewsBean> getListMapByFilter(final int firstResult, final int maxResult, final String content,
			final String title) {
		return getHibernateTemplate().execute(new HibernateCallback<List<NewsBean>>() {
			public List<NewsBean> doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder queryString = new StringBuilder();
				Map params = new HashMap();
				queryString.append("SELECT id as id,title as title,content as content, ");
				queryString.append("createOn as createOn,isDisabled as isDisabled ");
				queryString.append("FROM News WHERE (1=1) ");
				if (title != null) {
					queryString.append("AND title like :title ");
					params.put("title", "%" + title + "%");
				}
				if (content != null) {
					queryString.append("AND content like :content ");
					params.put("content", "%" + content + "%");
				}
				Query query = session.createQuery(queryString.toString());
				query.setProperties(params);
				if (firstResult >= 0 && maxResult > 0) {
					query.setFirstResult(firstResult);
					query.setMaxResults(maxResult);
				}
				query.setResultTransformer(Transformers.aliasToBean(NewsBean.class));
				List<NewsBean> list = query.list();
				return list;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List getListBeanOrCount(final boolean countOnly, final int firstResult, final int maxResult,
			final String content, final String title, final String key, final int dir) {
		return getHibernateTemplate().execute(new HibernateCallback() {
			public List doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder queryString = new StringBuilder();
				Map params = new HashMap();
				if (countOnly) {
					queryString.append("SELECT COUNT(n) ");
				} else {
					queryString.append("SELECT n.id as id,n.title as title,n.content as content, ");
					queryString.append("n.createOn as createOn,n.isDisabled as isDisabled ");
				}
				queryString.append("FROM News n WHERE (1=1) ");
				if (title != null) {
					queryString.append("AND n.title like :title ");
					params.put("title", "%" + title + "%");
				}
				if (content != null) {
					queryString.append("AND n.content like :content ");
					params.put("content", "%" + content + "%");
				}
				if (!countOnly && key != null) {
					queryString.append("ORDER BY n." + key);
					if (dir == 0) {
						queryString.append(" ASC");
					} else {
						queryString.append(" DESC");
					}
				}
				Query query = session.createQuery(queryString.toString());
				query.setProperties(params);
				if (!countOnly && firstResult >= 0 && maxResult > 0) {
					query.setFirstResult(firstResult);
					query.setMaxResults(maxResult);
				}
				if(!countOnly){
					query.setResultTransformer(Transformers.aliasToBean(NewsBean.class));					
				}
				List list = query.list();
				return list;
			}
		});
	}

}
