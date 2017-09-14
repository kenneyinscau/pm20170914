package entity;

import java.util.Date;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */

public class Task implements java.io.Serializable {

	// Fields

	private Integer tid;
	private Tasktype tasktype;
	private User user;
	private String outline;
	private Date taskDate;
	private Date createDate;
	private String taskContent;

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** full constructor */
	public Task(Tasktype tasktype, User user, String outline, Date taskDate,
			Date createDate, String taskContent) {
		this.tasktype = tasktype;
		this.user = user;
		this.outline = outline;
		this.taskDate = taskDate;
		this.createDate = createDate;
		this.taskContent = taskContent;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Tasktype getTasktype() {
		return this.tasktype;
	}

	public void setTasktype(Tasktype tasktype) {
		this.tasktype = tasktype;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOutline() {
		return this.outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public Date getTaskDate() {
		return this.taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getTaskContent() {
		return this.taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

}