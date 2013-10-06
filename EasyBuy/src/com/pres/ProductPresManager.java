package com.pres;

import java.util.List;

import com.bean.ProductBean;
import com.facade.ProductFacade;

public class ProductPresManager {
	private ProductFacade productFacade;

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	// TODO getProductsByTime
	public List<ProductBean> getProductsByTime() {
		return null;
	}

	// TODO getProductsByPrice
	public List<ProductBean> getProductsByPrice() {
		return null;
	}
}
