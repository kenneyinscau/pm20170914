package entity;

/**
 * Workorder entity. @author MyEclipse Persistence Tools
 */

public class Workorder implements java.io.Serializable {

	// Fields

	private Integer woid;
	private Worktype worktype;
	private Workflow workflowByWorkFlowByFlowCurrent;
	private Workflow workflowByWorkFlowByFlowNext;
	private Integer flowStart;

	// Constructors

	/** default constructor */
	public Workorder() {
		Worktype worktype = new Worktype();
	}

	/** full constructor */
	public Workorder(Worktype worktype,
			Workflow workflowByWorkFlowByFlowCurrent,
			Workflow workflowByWorkFlowByFlowNext, Integer flowStart) {
		this.worktype = worktype;
		this.workflowByWorkFlowByFlowCurrent = workflowByWorkFlowByFlowCurrent;
		this.workflowByWorkFlowByFlowNext = workflowByWorkFlowByFlowNext;
		this.flowStart = flowStart;
	}

	// Property accessors

	public Integer getWoid() {
		return this.woid;
	}

	public void setWoid(Integer woid) {
		this.woid = woid;
	}

	public Worktype getWorktype() {
		return this.worktype;
	}

	public void setWorktype(Worktype worktype) {
		this.worktype = worktype;
	}

	public Workflow getWorkflowByWorkFlowByFlowCurrent() {
		return this.workflowByWorkFlowByFlowCurrent;
	}

	public void setWorkflowByWorkFlowByFlowCurrent(
			Workflow workflowByWorkFlowByFlowCurrent) {
		this.workflowByWorkFlowByFlowCurrent = workflowByWorkFlowByFlowCurrent;
	}

	public Workflow getWorkflowByWorkFlowByFlowNext() {
		return this.workflowByWorkFlowByFlowNext;
	}

	public void setWorkflowByWorkFlowByFlowNext(
			Workflow workflowByWorkFlowByFlowNext) {
		this.workflowByWorkFlowByFlowNext = workflowByWorkFlowByFlowNext;
	}

	public Integer getFlowStart() {
		return this.flowStart;
	}

	public void setFlowStart(Integer flowStart) {
		this.flowStart = flowStart;
	}

}