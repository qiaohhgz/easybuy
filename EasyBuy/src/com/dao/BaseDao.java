package com.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class BaseDao<T> extends HibernateDaoSupport {

	public Logger log;
	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		log = Logger.getLogger(getPersistentClass());
		if (log.isInfoEnabled()) {
			log.info(getClassName());
		}
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public String getClassName() {
		return getPersistentClass().getName();
	}

	public List findAll(final String orderBy, final int pageNumber, final int itemsPerPage) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = MessageFormat.format("FROM {0} o ORDER BY {1}", new Object[] { getClassName(), orderBy });
				Query query = session.createQuery(hql);
				if (pageNumber >= 0 && itemsPerPage > 0) {
					query.setFirstResult(Math.max(0, pageNumber - 1) * itemsPerPage);
					query.setMaxResults(itemsPerPage);
				}
				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public T loadByUniqueAttribute(final String attributeName, final Object attributeValue) {
		return (T) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = MessageFormat.format("FROM {0} o WHERE {1} = :param", new Object[] { getClassName(),
						attributeName });
				Query query = session.createQuery(hql);
				query.setParameter("param", attributeValue);
				return query.uniqueResult();
			}
		});
	}

	/**
	 * Query a listing of rows by one field value
	 * 
	 * @param attributeName
	 * @param attributeValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByAttribute(final String attributeName, final Object attributeValue) {
		String queryString = MessageFormat.format("FROM {0} o WHERE {1} = :param", new Object[] { getClassName(),
				attributeName });
		return getHibernateTemplate().findByNamedParam(queryString, "param", attributeValue);
	}

	/**
	 * Find Items with the giving attribute matches any of the giving values
	 * 
	 * @param attributeName
	 * @param attributeValues
	 *            An array of values
	 * @return object loaded
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByAttributeWithMultiValues(final String attributeName, final Object[] attributeValues) {
		return (List<T>) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String queryString = "FROM {0} o WHERE {1} IN (:param)";
				queryString = queryString.replace("{0}", getClassName());
				queryString = queryString.replace("{1}", attributeName);
				Query query = session.createQuery(queryString);
				query.setParameterList("param", attributeValues);
				return query.list();
			}
		});
	}

	public List<T> findAll(Class<T> entityClass) {
		return findByCriteria(entityClass);
	}

	public T saveOrUpdate(final T obj) {
		getHibernateTemplate().execute(new HibernateCallback<T>() {
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				session.saveOrUpdate(obj);
				session.flush();
				session.refresh(obj);
				return obj;
			}
		});
		return obj;
	}

	public T update(final T obj) {
		getHibernateTemplate().execute(new HibernateCallback<T>() {
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				session.update(obj);
				session.flush();
				session.refresh(obj);
				return obj;
			}
		});
		return obj;
	}

	public T save(final T obj) {
		getHibernateTemplate().execute(new HibernateCallback<T>() {
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				session.save(obj);
				session.flush();
				session.refresh(obj);
				return obj;
			}
		});
		return obj;
	}

	public void delete(final Object obj) {
		getHibernateTemplate().execute(new HibernateCallback<T>() {
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				session.delete(obj);
				session.flush();
				return null;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Class<T> entityClass, Criterion... criterion) {
		Criteria crit = getSession().createCriteria(entityClass);
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(int firstResult, int maxResults, Class<T> entityClass, Criterion... criterion) {
		Criteria crit = getSession().createCriteria(entityClass);
		for (Criterion c : criterion) {
			crit.add(c);
		}
		crit.setFirstResult((firstResult - 1) * maxResults);
		crit.setMaxResults(maxResults);
		return crit.list();
	}

	public List<T> findAll(Class<T> entityClass, Integer currentIndex, Integer maxResult, Criterion... res) {
		return findAll(entityClass, currentIndex, maxResult, res, Order.asc("id"));
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(final Class<T> entityClass, final int currentIndex, final int maxResult,
			final Criterion[] res, final Order... order) {
		return (List<T>) getHibernateTemplate().execute(new HibernateCallback<T>() {
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(entityClass);
				if (null != res) {
					for (Criterion r : res) {
						crit.add(r);
					}
				}
				if (null != order) {
					for (Order o : order) {
						crit.addOrder(o);
					}
				}
				if (maxResult > 0) {
					crit.setFirstResult(currentIndex);
					crit.setMaxResults(maxResult);
				}
				return (T) crit.list();
			}
		});
	}

	public String getHQLQuerySelect(boolean countOnly, String select) {
		return countOnly ? ("SELECT COUNT(" + select + ") FROM ") : ("SELECT " + select + " FROM ");
	}

	public String getSQLQuerySelect(boolean countOnly, String select) {
		return countOnly ? ("SELECT COUNT(" + select + ".*) FROM ") : ("SELECT " + select + " FROM ");
	}

	public T makePersistent(final T entity) {
		getHibernateTemplate().execute(new HibernateCallback<T>() {
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				session.saveOrUpdate(entity);
				session.flush();
				session.refresh(entity);
				return entity;
			}
		});
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByAttribute(String name, String value) {
		return getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return null;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Map<Object, Object>> getListMap(final String hql, final Map params) {
		return getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String queryString = hql;
				Query query = session.createQuery(queryString);
				if (params != null) {
					query.setProperties(params);
				}
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				List<Map> list = query.list();
				return list;
			}
		});
	}
}
