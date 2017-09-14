package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Worktype entity. @author MyEclipse Persistence Tools
 */

public class Worktype implements java.io.Serializable {

	// Fields

	private Integer wtid;
	private String workflowName;
	private String workOrders;
	private String workRecords;
	private String workFlows;
	private Set workflows = new HashSet(0);
	private Set workorders = new HashSet(0);
	private Set workrecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Worktype() {
	}

	/** full constructor */
	public Worktype(String workflowName, String workOrders, String workRecords,
			String workFlows, Set workflows, Set workorders, Set workrecords) {
		this.workflowName = workflowName;
		this.workOrders = workOrders;
		this.workRecords = workRecords;
		this.workFlows = workFlows;
		this.workflows = workflows;
		this.workorders = workorders;
		this.workrecords = workrecords;
	}

	// Property accessors

	public Integer getWtid() {
		return this.wtid;
	}

	public void setWtid(Integer wtid) {
		this.wtid = wtid;
	}

	public String getWorkflowName() {
		return this.workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getWorkOrders() {
		return this.workOrders;
	}

	public void setWorkOrders(String workOrders) {
		this.workOrders = workOrders;
	}

	public String getWorkRecords() {
		return this.workRecords;
	}

	public void setWorkRecords(String workRecords) {
		this.workRecords = workRecords;
	}

	public String getWorkFlows() {
		return this.workFlows;
	}

	public void setWorkFlows(String workFlows) {
		this.workFlows = workFlows;
	}

	public Set getWorkflows() {
		return this.workflows;
	}

	public void setWorkflows(Set workflows) {
		this.workflows = workflows;
	}

	public Set getWorkorders() {
		return this.workorders;
	}

	public void setWorkorders(Set workorders) {
		this.workorders = workorders;
	}

	public Set getWorkrecords() {
		return this.workrecords;
	}

	public void setWorkrecords(Set workrecords) {
		this.workrecords = workrecords;
	}

}