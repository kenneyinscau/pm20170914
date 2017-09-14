package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Workrecord entity. @author MyEclipse Persistence Tools
 */

public class Workrecord implements java.io.Serializable {

	// Fields

	private Integer wrid;
	private Workflow workflowByWfidByFlowCurrent;
	private User userByUserByAuthorid;
	private Workflow workflowByWfidByFlowNext;
	private Worktype worktype;
	private User userByUserByTransactorId;
	private Date createDates;
	private Integer status;
	private String title;
	private String content;
	private String workResults;
	private Set workresults = new HashSet(0);

	// Constructors

	/** default constructor */
	public Workrecord() {
//		Worktype worktype = new Worktype();
//		User userByUserByAuthorid = new User();
//		User userByUserByTransactorId = new User();
		
	}

	/** full constructor */
	public Workrecord(Workflow workflowByWfidByFlowCurrent,
			User userByUserByAuthorid, Workflow workflowByWfidByFlowNext,
			Worktype worktype, User userByUserByTransactorId, Date createDates,
			Integer status, String title, String content, String workResults,
			Set workresults) {
		this.workflowByWfidByFlowCurrent = workflowByWfidByFlowCurrent;
		this.userByUserByAuthorid = userByUserByAuthorid;
		this.workflowByWfidByFlowNext = workflowByWfidByFlowNext;
		this.worktype = worktype;
		this.userByUserByTransactorId = userByUserByTransactorId;
		this.createDates = createDates;
		this.status = status;
		this.title = title;
		this.content = content;
		this.workResults = workResults;
		this.workresults = workresults;
	}

	// Property accessors

	public Integer getWrid() {
		return this.wrid;
	}

	public void setWrid(Integer wrid) {
		this.wrid = wrid;
	}

	public Workflow getWorkflowByWfidByFlowCurrent() {
		return this.workflowByWfidByFlowCurrent;
	}

	public void setWorkflowByWfidByFlowCurrent(
			Workflow workflowByWfidByFlowCurrent) {
		this.workflowByWfidByFlowCurrent = workflowByWfidByFlowCurrent;
	}

	public User getUserByUserByAuthorid() {
		return this.userByUserByAuthorid;
	}

	public void setUserByUserByAuthorid(User userByUserByAuthorid) {
		this.userByUserByAuthorid = userByUserByAuthorid;
	}

	public Workflow getWorkflowByWfidByFlowNext() {
		return this.workflowByWfidByFlowNext;
	}

	public void setWorkflowByWfidByFlowNext(Workflow workflowByWfidByFlowNext) {
		this.workflowByWfidByFlowNext = workflowByWfidByFlowNext;
	}

	public Worktype getWorktype() {
		return this.worktype;
	}

	public void setWorktype(Worktype worktype) {
		this.worktype = worktype;
	}

	public User getUserByUserByTransactorId() {
		return this.userByUserByTransactorId;
	}

	public void setUserByUserByTransactorId(User userByUserByTransactorId) {
		this.userByUserByTransactorId = userByUserByTransactorId;
	}

	public Date getCreateDates() {
		return this.createDates;
	}

	public void setCreateDates(Date createDates) {
		this.createDates = createDates;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getWorkResults() {
		return this.workResults;
	}

	public void setWorkResults(String workResults) {
		this.workResults = workResults;
	}

	public Set getWorkresults() {
		return this.workresults;
	}

	public void setWorkresults(Set workresults) {
		this.workresults = workresults;
	}

}