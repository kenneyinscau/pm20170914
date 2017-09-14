package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private Set rights;
	private String users;
	private Set users_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public Role(String roleName, Set rights, String users, Set users_1) {
		this.roleName = roleName;
		this.rights = rights;
		this.users = users;
		this.users_1 = users_1;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Right> getRights() {
		return this.rights;
	}

	public void setRights(Set rights) {
		this.rights = rights;
	}

	public String getUsers() {
		return this.users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public Set getUsers_1() {
		return this.users_1;
	}

	public void setUsers_1(Set users_1) {
		this.users_1 = users_1;
	}

}