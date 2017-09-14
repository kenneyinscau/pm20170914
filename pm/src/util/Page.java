package util;

import java.util.List;

public class Page {
	private List result;
	private int totalCount;
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public Page(List result,int totalCount) {
		this.result=result;
		this.totalCount=totalCount;
	}
}
