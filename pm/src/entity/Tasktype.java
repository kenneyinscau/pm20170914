package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tasktype entity. @author MyEclipse Persistence Tools
 */

public class Tasktype implements java.io.Serializable {

	// Fields

	private Integer ttid;
	private String taskname;
	private String tasks;
	private Set tasks_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tasktype() {
	}

	/** full constructor */
	public Tasktype(String taskname, String tasks, Set tasks_1) {
		this.taskname = taskname;
		this.tasks = tasks;
		this.tasks_1 = tasks_1;
	}

	// Property accessors

	public Integer getTtid() {
		return this.ttid;
	}

	public void setTtid(Integer ttid) {
		this.ttid = ttid;
	}

	public String getTaskname() {
		return this.taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTasks() {
		return this.tasks;
	}

	public void setTasks(String tasks) {
		this.tasks = tasks;
	}

	public Set getTasks_1() {
		return this.tasks_1;
	}

	public void setTasks_1(Set tasks_1) {
		this.tasks_1 = tasks_1;
	}

}