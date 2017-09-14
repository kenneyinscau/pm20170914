package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Role role;
	private String name;
	private String password;
	private Integer userState;
	private Set tasks = new HashSet(0);
	private Set mailsForSid = new HashSet(0);
	private Set workrecordsForUserByTransactorId = new HashSet(0);
	private Set mailsForRid = new HashSet(0);
	private Set workrecordsForUserByAuthorid = new HashSet(0);
	private Set workresults = new HashSet(0);
	private Set affiches = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Role role, String name, String password, Integer userState,
			Set tasks, Set mailsForSid, Set workrecordsForUserByTransactorId,
			Set mailsForRid, Set workrecordsForUserByAuthorid, Set workresults,
			Set affiches) {
		this.role = role;
		this.name = name;
		this.password = password;
		this.userState = userState;
		this.tasks = tasks;
		this.mailsForSid = mailsForSid;
		this.workrecordsForUserByTransactorId = workrecordsForUserByTransactorId;
		this.mailsForRid = mailsForRid;
		this.workrecordsForUserByAuthorid = workrecordsForUserByAuthorid;
		this.workresults = workresults;
		this.affiches = affiches;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserState() {
		return this.userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public Set getTasks() {
		return this.tasks;
	}

	public void setTasks(Set tasks) {
		this.tasks = tasks;
	}

	public Set getMailsForSid() {
		return this.mailsForSid;
	}

	public void setMailsForSid(Set mailsForSid) {
		this.mailsForSid = mailsForSid;
	}

	public Set getWorkrecordsForUserByTransactorId() {
		return this.workrecordsForUserByTransactorId;
	}

	public void setWorkrecordsForUserByTransactorId(
			Set workrecordsForUserByTransactorId) {
		this.workrecordsForUserByTransactorId = workrecordsForUserByTransactorId;
	}

	public Set getMailsForRid() {
		return this.mailsForRid;
	}

	public void setMailsForRid(Set mailsForRid) {
		this.mailsForRid = mailsForRid;
	}

	public Set getWorkrecordsForUserByAuthorid() {
		return this.workrecordsForUserByAuthorid;
	}

	public void setWorkrecordsForUserByAuthorid(Set workrecordsForUserByAuthorid) {
		this.workrecordsForUserByAuthorid = workrecordsForUserByAuthorid;
	}

	public Set getWorkresults() {
		return this.workresults;
	}

	public void setWorkresults(Set workresults) {
		this.workresults = workresults;
	}

	public Set getAffiches() {
		return this.affiches;
	}

	public void setAffiches(Set affiches) {
		this.affiches = affiches;
	}

}