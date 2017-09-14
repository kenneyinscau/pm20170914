package entity;

import java.util.Set;

/**
 * Right entity. @author MyEclipse Persistence Tools
 */

public class Right implements java.io.Serializable {

	// Fields

	private Integer rightId;
	private Integer pid;
	private String rightname;
	private String url;
	private Set roles;

	// Constructors

	/** default constructor */
	public Right() {
	}

	/** minimal constructor */
	public Right(Integer pid) {
		this.pid = pid;
	}

	/** full constructor */
	public Right(Integer pid, String rightname, String url, Set roles) {
		this.pid = pid;
		this.rightname = rightname;
		this.url = url;
		this.roles = roles;
	}

	// Property accessors

	public Integer getRightId() {
		return this.rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getRightname() {
		return this.rightname;
	}

	public void setRightname(String rightname) {
		this.rightname = rightname;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set getRoles() {
		return this.roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

}