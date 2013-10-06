package com.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.entity.Category;

public class CategoryDao extends BaseDao<Category> {

	@SuppressWarnings("unchecked")
	public List<Category> findAll(final boolean countOnly, final int off, final int max, final String[] key, final int[] dir) {
		return (List<Category>) new HibernateTemplate().execute(new HibernateCallback<Category>() {
			public Category doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder hql = new StringBuilder();
				hql.append(getHQLQuerySelect(countOnly, "c"));
				hql.append("Category c ");
				if (!countOnly && key != null && key.length > 0) {
					hql.append("ORDER BY ");
					for (int i = 0; i < key.length; i++) {
						if (i < key.length - 1) {
							hql.append(key[i] + (dir[i] == 0 ? " ASC ," : " DESC ,"));
						} else {
							hql.append(key[i] + (dir[i] == 0 ? " ASC " : " DESC "));
						}
					}
				}
				Query query = session.createQuery(hql.toString());
				if (!countOnly && max > 0) {
					query.setFirstResult(off);
					query.setMaxResults(max);
				}
				return (Category) query.list();
			}
		});
	}

	public Category get(int id) {
		return super.loadByUniqueAttribute("categoryId", id);
	}

	// TODO
	public List<Map<Object, Object>> getCategoryByFatherId(Integer id) {
		StringBuilder hql = new StringBuilder();
		Map map = new HashMap();
		hql.append("SELECT o.id as categoryId,o.name as name,o.categoryFather as categoryFather");
		hql.append(",o.createOn as createOn ,o.isDisabled as isDisabled ");
		hql.append("FROM " + getClassName() + " as o ");
		hql.append("WHERE o.categoryFather.id = :fid");
		map.put("fid", id);
		return super.getListMap(hql.toString(), map);
	}
}
