package action;

import java.util.Date;
import java.util.List;

import util.MyJson;

import biz.CommBiz;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import entity.User;
import entity.Workflow;
import entity.Workorder;
import entity.Workrecord;
import entity.Workresult;
import entity.Worktype;

public class WorkAction {
	private static final String TOCREATE = "tocreate";
	private static final String TOSUBMIT = "tosubmit";
	private static final String TOCONTINUE = "tocontinue";
	private static final String TOSEE = "tosee";
	private static final String TOSEERESULT = "toseeResult";
	private CommBiz commonBiz;
	private List<Worktype> typeList;
	private Worktype workType;
	private Workorder workOrder;
	private List<User> userList;
	private Workrecord workRecord;
	private Workresult workResult;
	private Integer workRecordid;
	private List<Workflow> workFlowList;
	private Workflow workFlow;

	public List<Workflow> getWorkFlowList() {
		return workFlowList;
	}

	public void setWorkFlowList(List<Workflow> workFlowList) {
		this.workFlowList = workFlowList;
	}

	public Workflow getWorkFlow() {
		return workFlow;
	}

	public void setWorkFlow(Workflow workFlow) {
		this.workFlow = workFlow;
	}

	public Integer getWorkRecordid() {
		return workRecordid;
	}

	public void setWorkRecordid(Integer workRecordid) {
		this.workRecordid = workRecordid;
	}

	public Workresult getWorkResult() {
		return workResult;
	}

	public void setWorkResult(Workresult workResult) {
		this.workResult = workResult;
	}

	public Workrecord getWorkRecord() {
		return workRecord;
	}

	public void setWorkRecord(Workrecord workRecord) {
		this.workRecord = workRecord;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Workorder getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(Workorder workOrder) {
		this.workOrder = workOrder;
	}

	public Worktype getWorkType() {
		return workType;
	}

	public void setWorkType(Worktype workType) {
		this.workType = workType;
	}

	public List<Worktype> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Worktype> typeList) {
		this.typeList = typeList;
	}

	public CommBiz getCommonBiz() {
		return commonBiz;
	}

	public void setCommonBiz(CommBiz commonBiz) {
		this.commonBiz = commonBiz;
	}

	/**
	 * 跳的选择工作流页面
	 * 
	 * @return
	 */
	public String toContinue() {
		typeList = commonBiz.getWorkTypeDAO().findAll();
		return TOCONTINUE;
	}
	
	
	/**
	 * 跳到创建工作流页面
	 * 
	 * @return
	 */
	public String toCreate(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user.getRole().getRoleId()==1||user.getRole().getRoleId()==5)
		return TOCREATE;
		else
		return Action.SUCCESS;
	}
	
	/**
	 * 跳到查看完成工作流页面
	 * 
	 * @return
	 */
	public String toSubmit(){
		return TOSUBMIT;
	}
	

	/**
	 * 跳的新建工作了页面
	 * 
	 * @return
	 */
	/*public String toCreate() {
		workOrder = (Workorder) commonBiz.getWorkOrderDAO()
				.getHibernateTemplate().find(
						"from WorkOrder where workType.wtid=? and flowStart=1",
						new Object[] { workOrder.getWorktype().getWtid() }).get(0);
		ActionContext.getContext().put(
				"msg",
				"{success:true,msg:'work/toCreate.jsp',currFlow:'"
						+ workOrder.getWorkflowByWorkFlowByFlowCurrent().getFlowname()
						+ "',nextFlow:'"
						+ workOrder.getWorkflowByWorkFlowByFlowNext().getFlowname()
						+ "',workTypeId:'" + workType.getWtid() + "',workTypeName:'"+workOrder.getWorktype().getWorkflowName()+"'}");
		return Action.SUCCESS;
	}
*/
	/**
	 * 获取所有用户
	 * 
	 * @return
	 */
	public String findUserList() {
		List<User>userList = commonBiz.getUserDAO().findAll();
		String msg = "{result:[";
		for (int i = 0; i < userList.size(); i++) {
			User u = userList.get(i);
			msg += "{id:'" + u.getUid() + "',name:'" + u.getName() + "'}";
			if (i < userList.size() - 1) {
				msg += ",";
			}
		}
		msg += "]}";
		ActionContext.getContext().put("msg", msg);
		return Action.SUCCESS;
	}

	/**
	 * 执行创建工作流
	 * 
	 * @return
	 */
	public String create() {
		// 获取当前登录用户
		System.out.println("标题是："+workRecord.getTitle()+"内容是："+workRecord.getContent());
		User user = (User) ActionContext.getContext().getSession().get("user");
		Workorder order = (Workorder) commonBiz.getWorkOrderDAO()
				.getHibernateTemplate().find(
						"from Workorder  where worktype.wtid=? and flowStart=1",
						new Object[] { workRecord.getWorktype().getWtid()}).get(
						0);
		// 设置创建人
		workRecord.setUserByUserByAuthorid(user);
		// 设置创建时间
		workRecord.setCreateDates(new Date());
		// 设置创建状态
		workRecord.setStatus(0);
		// 设置当前办理流程
		workRecord.setWorkflowByWfidByFlowCurrent(order.getWorkflowByWorkFlowByFlowCurrent());
		// 设置下一办理流程
		workRecord.setWorkflowByWfidByFlowNext(order.getWorkflowByWorkFlowByFlowNext());
		System.out.println("workRecordcode"+workRecord.getTitle()+workRecord.getContent());
		// 保存该流程记录
		commonBiz.getWorkRecordDAO().save(workRecord);

		ActionContext.getContext().put("msg", "{success:true,msg:'创建成功'}");
		return Action.SUCCESS;
	}



	/**
	 * 查询下一办理
	 * @return
	 */
	public String findNextTransact() {
		// 通过id查询一条流程记录
		Workrecord record = commonBiz.getWorkRecordDAO().findById(
				workRecord.getWrid());
		// 根据当前流程记录的下一办理流程，查询流程顺序列表
		Workorder workOrder = (Workorder) commonBiz
				.getWorkOrderDAO()
				.getHibernateTemplate()
				.find("from WorkOrder where workflowByWorkFlowByFlowCurrent.id=?",
						new Object[] { record.getWorkflowByWfidByFlowNext().getWfid() })
				.get(0);
		ActionContext.getContext().put(
				"msg",
				"{result:[{id:0,name:'"
						+ workOrder.getWorkflowByWorkFlowByFlowNext().getFlowname()
						+ "'},{id:1,name:'回绝'}]}");
		return Action.SUCCESS;
	}

	/**
	 * 查询当前用户的待办件
	 * 
	 * @return
	 */
	public String findWaitWork() {
		// 获取当前登录用户
		User user = (User) ActionContext.getContext().getSession().get(
				"user");
		// 查询对应该用户所有的流程记录
		List<Workrecord> recordList = commonBiz.getWorkRecordDAO().getHibernateTemplate().find("from Workrecord where userByUserByTransactorId.uid=? and status in (0,4)",new Object[] { user.getUid() });
		//String msg = "{totalCount:" + recordList.size() + ",result:";
		//msg += MyJson.toJsonStr(recordList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("workrecords", recordList);
		
		return TOCONTINUE;
	}
	
	/**
	 * 查询当前用户办件信息
	 * 
	 * @return
	 */
	public String doWaitWork() {
		// 获取当前登录用户
		User user = (User) ActionContext.getContext().getSession().get(
				"user");
		//通过id查询一条流程记
		Workrecord record=commonBiz.getWorkRecordDAO().findById(workRecordid);
		// 查询对应该用户所有的流程记录
		//Workrecord recordList = (Workrecord)commonBiz.getWorkRecordDAO().getHibernateTemplate().find("from Workrecord where wrid=?",workRecordid);
		//String msg = "{totalCount:" + recordList.size() + ",result:";
		//msg += MyJson.toJsonStr(recordList, "oaRole");
		//msg += "}";
		//ActionContext.getContext().put("workRecord", record);
		ActionContext.getContext().getSession().put("workRecord", record);
		return TOSEE;
	}
	
	/**
	 * 办理提交
	 * @return
	 */
	public String submit(){
		//获取当前登录用户
		User user=(User) ActionContext.getContext().getSession().get("user");
		Workrecord workRecorda=(Workrecord) ActionContext.getContext().getSession().get("workRecord");
		//Workrecord workRecorda=(Workrecord) ActionContext.getContext().get("workRecord");
		Workrecord workRecordnew=new Workrecord();
		//通过id查询一条流程记
		Workrecord record=commonBiz.getWorkRecordDAO().findById(workRecorda.getWrid());
		//根据当前流程记录的下一办理流程，查询流程顺序列表
		Workorder workOrder=(Workorder) commonBiz.getWorkOrderDAO().getHibernateTemplate().find("from Workorder where workflowByWorkFlowByFlowCurrent.wfid=?",new Object[]{record.getWorkflowByWfidByFlowNext().getWfid()}).get(0);		
		//设置流程记录的当前办理流程为下一办理流程
		workRecordnew.setWorkflowByWfidByFlowCurrent(record.getWorkflowByWfidByFlowNext());
		//设置流程记录的下一办理流程为上面获取流程顺序的下一办理流程
		workRecordnew.setWorkflowByWfidByFlowNext(workOrder.getWorkflowByWorkFlowByFlowNext());
		//如果被回绝
		if (workResult.getStatus()==1) {
			//设置流程记录状态为4,代表回绝
			record.setStatus(4);
			Integer usertemp = record.getUserByUserByAuthorid().getUid();
			User u = new User();
			u.setUid(usertemp);
			record.setUserByUserByAuthorid(user);
			record.setUserByUserByTransactorId(u);
			//更新该流程记录	
			commonBiz.getWorkRecordDAO().merge(record);
			//设置办理结果的办理人
			workResult.setUser(user);
			//设置办理结果的办理时间
			workResult.setTransactDate(new Date());
			//设置办理结果的流程记录
			workResult.setWorkrecord(record);
			//ActionContext.getContext().put("workRecord", record);
			ActionContext.getContext().getSession().put("workRecord", record);
		}else{
			//设置该流程记录的办理人
			record.setStatus(1);
			workRecordnew.setUserByUserByTransactorId(workResult.getUser());
			workRecordnew.setUserByUserByAuthorid(user);
			workRecordnew.setCreateDates(new Date());
			workRecordnew.setTitle(record.getTitle());
			workRecordnew.setContent(workResult.getTransactContent());
			workRecordnew.setWorktype(record.getWorktype());
			//如果流程顺序已结束
			if (workOrder.getFlowStart()==3) {
				//设置流程记录状态为1,代表已办理
				workRecordnew.setStatus(1);
			}else{
				workRecordnew.setStatus(0);
			}
			commonBiz.getWorkRecordDAO().merge(record);
			commonBiz.getWorkRecordDAO().save(workRecordnew);
			//设置办理结果的办理人
			workResult.setUser(user);
			//设置办理结果的办理时间
			workResult.setTransactDate(new Date());
			//设置办理结果的流程记录
			workResult.setWorkrecord(workRecordnew);
			//ActionContext.getContext().put("workRecord", workRecordnew);
			ActionContext.getContext().getSession().put("workRecord", workRecordnew);
		}
			
		//保存该办理结果
		commonBiz.getWorkResultDAO().getHibernateTemplate().save(workResult);
		//ActionContext.getContext().put("msg", "{success:true,msg:'办理成功'}");
		
		return Action.SUCCESS;
	}
	
	
	/**
	 * 查询交办件
	 * @return
	 */
	public String findMyWork(){
		//获取当前登录用户
		User user=(User) ActionContext.getContext().getSession().get("user");
		//查询对应该用户所有的流程记录
		List<Workrecord> recordList=commonBiz.getWorkRecordDAO().getHibernateTemplate().find("from Workrecord where userByUserByAuthorid.uid=? or userByUserByTransactorId.uid=? ",new Object[]{user.getUid(),user.getUid()});
		//String msg = "{totalCount:" + recordList.size() + ",result:";
		//msg += MyJson.toJsonStr(recordList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("workrecords", recordList);
		return TOSUBMIT;
	}
	
	/**
	 * 查询某条记录的审批结果
	 * @return
	 */
	public String findWorkResult(){
		// 获取当前登录用户
				User user = (User) ActionContext.getContext().getSession().get(
						"user");
				//通过id查询一条流程记
				Workrecord record=commonBiz.getWorkRecordDAO().findById(workRecordid);
				/*Workresult result = new Workresult();
				result.setWorkrecord(record);
				result=(Workresult)commonBiz.getWorkResultDAO().findByExample(result).get(0);*/
				Workresult result=(Workresult)commonBiz.getWorkResultDAO().getHibernateTemplate().find("from Workresult where workrecord.wrid=?",new Object[]{workRecordid}).get(0);
				ActionContext.getContext().getSession().put("workRecord", record);
				/*ActionContext.getContext().getSession().put("workResult", result);*/
				ActionContext.getContext().getSession().put("workResult", result);
				return TOSEERESULT;
	}
	
	

}
