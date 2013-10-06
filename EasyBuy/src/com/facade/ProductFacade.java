package com.facade;

import com.dao.ProductDao;

public class ProductFacade {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
