package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Workflow entity. @author MyEclipse Persistence Tools
 */

public class Workflow implements java.io.Serializable {

	// Fields

	private Integer wfid;
	private Worktype worktype;
	private String flowname;
	private String workOrdersForFlowCurrent;
	private String workRecordsForFlowCurrent;
	private String workOrdersForFlowNext;
	private String workRecordsForFlowNext;
	private Set workrecordsForWfidByFlowCurrent = new HashSet(0);
	private Set workordersForWorkFlowByFlowCurrent = new HashSet(0);
	private Set workordersForWorkFlowByFlowNext = new HashSet(0);
	private Set workrecordsForWfidByFlowNext = new HashSet(0);

	// Constructors

	/** default constructor */
	public Workflow() {
	}

	/** full constructor */
	public Workflow(Worktype worktype, String flowname,
			String workOrdersForFlowCurrent, String workRecordsForFlowCurrent,
			String workOrdersForFlowNext, String workRecordsForFlowNext,
			Set workrecordsForWfidByFlowCurrent,
			Set workordersForWorkFlowByFlowCurrent,
			Set workordersForWorkFlowByFlowNext,
			Set workrecordsForWfidByFlowNext) {
		this.worktype = worktype;
		this.flowname = flowname;
		this.workOrdersForFlowCurrent = workOrdersForFlowCurrent;
		this.workRecordsForFlowCurrent = workRecordsForFlowCurrent;
		this.workOrdersForFlowNext = workOrdersForFlowNext;
		this.workRecordsForFlowNext = workRecordsForFlowNext;
		this.workrecordsForWfidByFlowCurrent = workrecordsForWfidByFlowCurrent;
		this.workordersForWorkFlowByFlowCurrent = workordersForWorkFlowByFlowCurrent;
		this.workordersForWorkFlowByFlowNext = workordersForWorkFlowByFlowNext;
		this.workrecordsForWfidByFlowNext = workrecordsForWfidByFlowNext;
	}

	// Property accessors

	public Integer getWfid() {
		return this.wfid;
	}

	public void setWfid(Integer wfid) {
		this.wfid = wfid;
	}

	public Worktype getWorktype() {
		return this.worktype;
	}

	public void setWorktype(Worktype worktype) {
		this.worktype = worktype;
	}

	public String getFlowname() {
		return this.flowname;
	}

	public void setFlowname(String flowname) {
		this.flowname = flowname;
	}

	public String getWorkOrdersForFlowCurrent() {
		return this.workOrdersForFlowCurrent;
	}

	public void setWorkOrdersForFlowCurrent(String workOrdersForFlowCurrent) {
		this.workOrdersForFlowCurrent = workOrdersForFlowCurrent;
	}

	public String getWorkRecordsForFlowCurrent() {
		return this.workRecordsForFlowCurrent;
	}

	public void setWorkRecordsForFlowCurrent(String workRecordsForFlowCurrent) {
		this.workRecordsForFlowCurrent = workRecordsForFlowCurrent;
	}

	public String getWorkOrdersForFlowNext() {
		return this.workOrdersForFlowNext;
	}

	public void setWorkOrdersForFlowNext(String workOrdersForFlowNext) {
		this.workOrdersForFlowNext = workOrdersForFlowNext;
	}

	public String getWorkRecordsForFlowNext() {
		return this.workRecordsForFlowNext;
	}

	public void setWorkRecordsForFlowNext(String workRecordsForFlowNext) {
		this.workRecordsForFlowNext = workRecordsForFlowNext;
	}

	public Set getWorkrecordsForWfidByFlowCurrent() {
		return this.workrecordsForWfidByFlowCurrent;
	}

	public void setWorkrecordsForWfidByFlowCurrent(
			Set workrecordsForWfidByFlowCurrent) {
		this.workrecordsForWfidByFlowCurrent = workrecordsForWfidByFlowCurrent;
	}

	public Set getWorkordersForWorkFlowByFlowCurrent() {
		return this.workordersForWorkFlowByFlowCurrent;
	}

	public void setWorkordersForWorkFlowByFlowCurrent(
			Set workordersForWorkFlowByFlowCurrent) {
		this.workordersForWorkFlowByFlowCurrent = workordersForWorkFlowByFlowCurrent;
	}

	public Set getWorkordersForWorkFlowByFlowNext() {
		return this.workordersForWorkFlowByFlowNext;
	}

	public void setWorkordersForWorkFlowByFlowNext(
			Set workordersForWorkFlowByFlowNext) {
		this.workordersForWorkFlowByFlowNext = workordersForWorkFlowByFlowNext;
	}

	public Set getWorkrecordsForWfidByFlowNext() {
		return this.workrecordsForWfidByFlowNext;
	}

	public void setWorkrecordsForWfidByFlowNext(Set workrecordsForWfidByFlowNext) {
		this.workrecordsForWfidByFlowNext = workrecordsForWfidByFlowNext;
	}

}