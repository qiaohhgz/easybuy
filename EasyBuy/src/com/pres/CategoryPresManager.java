package com.pres;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bean.CategoryBean;
import com.entity.Category;
import com.facade.CategoryFacade;

public class CategoryPresManager {
	private CategoryFacade categoryFacade;

	// TODO getCategory
	public List<CategoryBean> getCategroy() {
		return categoryFacade.getAllCategory();
	}

	public void addCategory(CategoryBean bean) {
		String name = bean.getName();
		if (null == name || name.trim().length() == 0) {
			throw new NullPointerException("Error bean.name");
		}
		Category category = new Category();
		category.setName(name);
		category.setCreateOn(new Date());
		category.setIsDisabled(bean.getIsDisabled());
		CategoryBean categoryFather = bean.getCategoryFather();
		if (null != categoryFather && categoryFather.getId() != null) {
			Category father = categoryFacade.getCategoryById(categoryFather.getId());
			category.setCategoryFather(father);
		}
		categoryFacade.addCategory(category);
	}

	// TODO update Category
	public void updateCategory(CategoryBean bean) {
		Integer id = bean.getId();
		if (null == id) {
			throw new NullPointerException("Error bean.id");
		}
	}

	// TODO
	public List<Map<Object, Object>> getCategoryByFatherId(Integer id) {
		return categoryFacade.getCategoryByFatherId(id);
	}

	public void setCategoryFacade(CategoryFacade categoryFacade) {
		this.categoryFacade = categoryFacade;
	}
}
