package com.bean.page;

public class Page {
	private int rowsPerPage;
	private int totalRecords;
	private int recordOffset;

	public int getRecordOffset() {
		return recordOffset;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setRecordOffset(int recordOffset) {
		this.recordOffset = recordOffset;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
}
