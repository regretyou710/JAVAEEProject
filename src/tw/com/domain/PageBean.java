package tw.com.domain;

import java.util.List;

/**
 * 封裝每一頁的實體類
 * 
 * @author Administrator
 *
 */

public class PageBean<T> {

	private List<T> data;// 泛型的數據
	private int pageSize;// 每一頁多少條紀錄
	private int actualPageSize;// 真實每頁多少條紀錄
	private int page;// 當前是第幾頁
	private int totalPage;// 總共幾頁
	private int totalNum;// 總紀錄數

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getActualPageSize() {
		return actualPageSize;
	}

	public void setActualPageSize(int actualPageSize) {
		this.actualPageSize = actualPageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

}
