package com.example.demo.common;

import org.springframework.data.domain.Page;

public class PaginationMeta {
	
	private int totlaCount;
	private int pageSize;
	private int totalPae;
	private  int pageNo;
	private Boolean isLate;
	private Boolean isFirst;
	
	
	public PaginationMeta() {
		
	}
	
	public int getTotlaCount() {
		return totlaCount;
	}
	public void setTotlaCount(int totlaCount) {
		this.totlaCount = totlaCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPae() {
		return totalPae;
	}
	public void setTotalPage(int totalPae) {
		this.totalPae = totalPae;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public Boolean getIsLate() {
		return isLate;
	}
	public void setIsLate(Boolean isLate) {
		this.isLate = isLate;
	}
	public Boolean getIsFirst() {
		return isFirst;
	}
	public void setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
	}
	
	public static <T> PaginationMeta createPagination(Page<T> page ) {
		
		PaginationMeta paginationMeta=new PaginationMeta();
		
		paginationMeta.setIsFirst(page.isFirst());
		paginationMeta.setIsLate(page.isLast());
		paginationMeta.setPageNo(page.getNumber());
		paginationMeta.setPageSize(page.getSize());
		paginationMeta.setTotalPage(page.getTotalPages());
		paginationMeta.setTotlaCount((int) page.getTotalElements());
		
		return paginationMeta;
		
	}

}
