package entity;

import java.util.Date;

/**
 * Mail entity. @author MyEclipse Persistence Tools
 */

public class Mail implements java.io.Serializable {

	// Fields

	private Integer mid;
	private User userBySid;
	private User userByRid;
	private String title;
	private String content;
	private Date sendDate;
	private Integer state;
	private Integer sendDel;
	private Integer receivceDel;


	/** default constructor */
	public Mail() {
	}

	/** full constructor */
	public Mail(User userBySid, User userByRid, String title, String content,
			Date sendDate, Integer state, Integer sendDel, Integer receivceDel) {
		this.userBySid = userBySid;
		this.userByRid = userByRid;
		this.title = title;
		this.content = content;
		this.sendDate = sendDate;
		this.state = state;
		this.sendDel = sendDel;
		this.receivceDel = receivceDel;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public User getUserBySid() {
		return this.userBySid;
	}

	public void setUserBySid(User userBySid) {
		this.userBySid = userBySid;
	}

	public User getUserByRid() {
		return this.userByRid;
	}

	public void setUserByRid(User userByRid) {
		this.userByRid = userByRid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendDate() {
		return this.sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSendDel() {
		return this.sendDel;
	}

	public void setSendDel(Integer sendDel) {
		this.sendDel = sendDel;
	}

	public Integer getReceivceDel() {
		return this.receivceDel;
	}

	public void setReceivceDel(Integer receivceDel) {
		this.receivceDel = receivceDel;
	}

}