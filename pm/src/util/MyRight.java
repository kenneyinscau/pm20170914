package util;

import java.util.ArrayList;
import java.util.List;

import entity.Right;

public class MyRight {
	private Right right;
	private List<Right> rightSubs=new ArrayList<Right>();
	public Right getRight() {
		return right;
	}
	public void setRight(Right right) {
		this.right = right;
	}
	public List<Right> getRightSubs() {
		return rightSubs;
	}
	public void setRightSubs(List<Right> rightSubs) {
		this.rightSubs = rightSubs;
	}
}
