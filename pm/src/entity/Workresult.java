package entity;

import java.util.Date;

/**
 * Workresult entity. @author MyEclipse Persistence Tools
 */

public class Workresult implements java.io.Serializable {

	// Fields

	private Integer wsid;
	private User user;
	private Workrecord workrecord;
	private String transactContent;
	private Date transactDate;
	private Integer status;

	// Constructors

	/** default constructor */
	public Workresult() {
	}

	/** full constructor */
	public Workresult(User user, Workrecord workrecord, String transactContent,
			Date transactDate, Integer status) {
		this.user = user;
		this.workrecord = workrecord;
		this.transactContent = transactContent;
		this.transactDate = transactDate;
		this.status = status;
	}

	// Property accessors

	public Integer getWsid() {
		return this.wsid;
	}

	public void setWsid(Integer wsid) {
		this.wsid = wsid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Workrecord getWorkrecord() {
		return this.workrecord;
	}

	public void setWorkrecord(Workrecord workrecord) {
		this.workrecord = workrecord;
	}

	public String getTransactContent() {
		return this.transactContent;
	}

	public void setTransactContent(String transactContent) {
		this.transactContent = transactContent;
	}

	public Date getTransactDate() {
		return this.transactDate;
	}

	public void setTransactDate(Date transactDate) {
		this.transactDate = transactDate;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}