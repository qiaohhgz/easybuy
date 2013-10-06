package com.dao;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

import com.AbstractSpringTest;
import com.entity.Category;

public class TestCategoryDao extends AbstractSpringTest {

	@Test
	public void testFindAllBooleanIntIntStringArrayIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		Category bean = new Category();
		bean.setCreateOn(new Date());
		bean.setIsDisabled(true);
		bean.setName("phone");
		int id = categoryFacade.addCategory(bean).getId();
		Category category = categoryFacade.getCategoryById(id);
		Assert.assertNotNull(category);
	}

	@Test
	public void testAddCategory() {
		Category bean = new Category();
		bean.setCreateOn(new Date());
		bean.setIsDisabled(true);
		bean.setName("phone");
		categoryFacade.addCategory(bean);
	}

	@Test
	public void testUpdate() {
		Category father = new Category();
		father.setCreateOn(new Date());
		father.setIsDisabled(true);
		father.setName("phone");
		int fid = categoryFacade.addCategory(father).getId();

		Category bean = new Category();
		bean.setCreateOn(new Date());
		bean.setIsDisabled(true);
		bean.setName("phone");
		int bid = categoryFacade.addCategory(bean).getId();

		Category findFatherBean = categoryFacade.getCategoryById(fid);
		Category findBean = categoryFacade.getCategoryById(bid);

		findBean.setCategoryFather(findFatherBean);
		categoryFacade.update(findBean);
	}

	@Test
	public void testGetCategoryByFatherId() {
		List<Map<Object,Object>> list = categoryFacade.getCategoryByFatherId(9);
		for (Map<Object, Object> map : list) {
			Set<Object> set = map.keySet();
			for (Object key : set) {
				Object o = map.get(key);
			}
		}
	}
}
