package com.bean.page;

import java.util.Map;

public class State {
	private Page page;
	private Sort order;
	private Grouping grouping;
	private Map<Object, Object> filter;

	public Map<Object, Object> getFilter() {
		return filter;
	}

	public Grouping getGrouping() {
		return grouping;
	}

	public Sort getOrder() {
		return order;
	}

	public Page getPage() {
		return page;
	}

	public void setFilter(Map<Object, Object> filter) {
		this.filter = filter;
	}

	public void setGrouping(Grouping grouping) {
		this.grouping = grouping;
	}

	public void setOrder(Sort order) {
		this.order = order;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
