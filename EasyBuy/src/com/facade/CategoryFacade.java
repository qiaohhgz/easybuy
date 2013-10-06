package com.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bean.CategoryBean;
import com.dao.CategoryDao;
import com.entity.Category;

public class CategoryFacade {
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// TODO addCategory
	public Category addCategory(Category entity) {
		return categoryDao.save(entity);
	}

	// TODO getCategoryById
	public Category getCategoryById(int id) {
		return categoryDao.get(id);
	}

	// TODO getAllCategory
	public List<CategoryBean> getAllCategory() {
		List<CategoryBean> list = new ArrayList<CategoryBean>();
		List<Category> cs = categoryDao.findAll(false, 0, 0, null, null);
		if (cs == null || cs.size() == 0) {
			return null;
		}
		for (Category c : cs) {
			list.add(buildByCategory(c));
		}
		return list;
	}

	public CategoryBean buildByCategory(Category entity) {
		return new CategoryBean(entity.getId(), entity.getName(), buildByCategory(entity));
	}

	public List<Map<Object, Object>> getCategoryByFatherId(Integer id) {
		return categoryDao.getCategoryByFatherId(id);
	}

	// TODO Auto-generated method stub
	public Category update(Category entity) {
		return categoryDao.update(entity);
	}

}
