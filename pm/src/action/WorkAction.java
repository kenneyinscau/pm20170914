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
	 * ����ѡ������ҳ��
	 * 
	 * @return
	 */
	public String toContinue() {
		typeList = commonBiz.getWorkTypeDAO().findAll();
		return TOCONTINUE;
	}
	
	
	/**
	 * ��������������ҳ��
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
	 * �����鿴��ɹ�����ҳ��
	 * 
	 * @return
	 */
	public String toSubmit(){
		return TOSUBMIT;
	}
	

	/**
	 * �����½�������ҳ��
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
	 * ��ȡ�����û�
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
	 * ִ�д���������
	 * 
	 * @return
	 */
	public String create() {
		// ��ȡ��ǰ��¼�û�
		System.out.println("�����ǣ�"+workRecord.getTitle()+"�����ǣ�"+workRecord.getContent());
		User user = (User) ActionContext.getContext().getSession().get("user");
		Workorder order = (Workorder) commonBiz.getWorkOrderDAO()
				.getHibernateTemplate().find(
						"from Workorder  where worktype.wtid=? and flowStart=1",
						new Object[] { workRecord.getWorktype().getWtid()}).get(
						0);
		// ���ô�����
		workRecord.setUserByUserByAuthorid(user);
		// ���ô���ʱ��
		workRecord.setCreateDates(new Date());
		// ���ô���״̬
		workRecord.setStatus(0);
		// ���õ�ǰ��������
		workRecord.setWorkflowByWfidByFlowCurrent(order.getWorkflowByWorkFlowByFlowCurrent());
		// ������һ��������
		workRecord.setWorkflowByWfidByFlowNext(order.getWorkflowByWorkFlowByFlowNext());
		System.out.println("workRecordcode"+workRecord.getTitle()+workRecord.getContent());
		// ��������̼�¼
		commonBiz.getWorkRecordDAO().save(workRecord);

		ActionContext.getContext().put("msg", "{success:true,msg:'�����ɹ�'}");
		return Action.SUCCESS;
	}



	/**
	 * ��ѯ��һ����
	 * @return
	 */
	public String findNextTransact() {
		// ͨ��id��ѯһ�����̼�¼
		Workrecord record = commonBiz.getWorkRecordDAO().findById(
				workRecord.getWrid());
		// ���ݵ�ǰ���̼�¼����һ�������̣���ѯ����˳���б�
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
						+ "'},{id:1,name:'�ؾ�'}]}");
		return Action.SUCCESS;
	}

	/**
	 * ��ѯ��ǰ�û��Ĵ����
	 * 
	 * @return
	 */
	public String findWaitWork() {
		// ��ȡ��ǰ��¼�û�
		User user = (User) ActionContext.getContext().getSession().get(
				"user");
		// ��ѯ��Ӧ���û����е����̼�¼
		List<Workrecord> recordList = commonBiz.getWorkRecordDAO().getHibernateTemplate().find("from Workrecord where userByUserByTransactorId.uid=? and status in (0,4)",new Object[] { user.getUid() });
		//String msg = "{totalCount:" + recordList.size() + ",result:";
		//msg += MyJson.toJsonStr(recordList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("workrecords", recordList);
		
		return TOCONTINUE;
	}
	
	/**
	 * ��ѯ��ǰ�û������Ϣ
	 * 
	 * @return
	 */
	public String doWaitWork() {
		// ��ȡ��ǰ��¼�û�
		User user = (User) ActionContext.getContext().getSession().get(
				"user");
		//ͨ��id��ѯһ�����̼�
		Workrecord record=commonBiz.getWorkRecordDAO().findById(workRecordid);
		// ��ѯ��Ӧ���û����е����̼�¼
		//Workrecord recordList = (Workrecord)commonBiz.getWorkRecordDAO().getHibernateTemplate().find("from Workrecord where wrid=?",workRecordid);
		//String msg = "{totalCount:" + recordList.size() + ",result:";
		//msg += MyJson.toJsonStr(recordList, "oaRole");
		//msg += "}";
		//ActionContext.getContext().put("workRecord", record);
		ActionContext.getContext().getSession().put("workRecord", record);
		return TOSEE;
	}
	
	/**
	 * �����ύ
	 * @return
	 */
	public String submit(){
		//��ȡ��ǰ��¼�û�
		User user=(User) ActionContext.getContext().getSession().get("user");
		Workrecord workRecorda=(Workrecord) ActionContext.getContext().getSession().get("workRecord");
		//Workrecord workRecorda=(Workrecord) ActionContext.getContext().get("workRecord");
		Workrecord workRecordnew=new Workrecord();
		//ͨ��id��ѯһ�����̼�
		Workrecord record=commonBiz.getWorkRecordDAO().findById(workRecorda.getWrid());
		//���ݵ�ǰ���̼�¼����һ�������̣���ѯ����˳���б�
		Workorder workOrder=(Workorder) commonBiz.getWorkOrderDAO().getHibernateTemplate().find("from Workorder where workflowByWorkFlowByFlowCurrent.wfid=?",new Object[]{record.getWorkflowByWfidByFlowNext().getWfid()}).get(0);		
		//�������̼�¼�ĵ�ǰ��������Ϊ��һ��������
		workRecordnew.setWorkflowByWfidByFlowCurrent(record.getWorkflowByWfidByFlowNext());
		//�������̼�¼����һ��������Ϊ�����ȡ����˳�����һ��������
		workRecordnew.setWorkflowByWfidByFlowNext(workOrder.getWorkflowByWorkFlowByFlowNext());
		//������ؾ�
		if (workResult.getStatus()==1) {
			//�������̼�¼״̬Ϊ4,����ؾ�
			record.setStatus(4);
			Integer usertemp = record.getUserByUserByAuthorid().getUid();
			User u = new User();
			u.setUid(usertemp);
			record.setUserByUserByAuthorid(user);
			record.setUserByUserByTransactorId(u);
			//���¸����̼�¼	
			commonBiz.getWorkRecordDAO().merge(record);
			//���ð������İ�����
			workResult.setUser(user);
			//���ð������İ���ʱ��
			workResult.setTransactDate(new Date());
			//���ð����������̼�¼
			workResult.setWorkrecord(record);
			//ActionContext.getContext().put("workRecord", record);
			ActionContext.getContext().getSession().put("workRecord", record);
		}else{
			//���ø����̼�¼�İ�����
			record.setStatus(1);
			workRecordnew.setUserByUserByTransactorId(workResult.getUser());
			workRecordnew.setUserByUserByAuthorid(user);
			workRecordnew.setCreateDates(new Date());
			workRecordnew.setTitle(record.getTitle());
			workRecordnew.setContent(workResult.getTransactContent());
			workRecordnew.setWorktype(record.getWorktype());
			//�������˳���ѽ���
			if (workOrder.getFlowStart()==3) {
				//�������̼�¼״̬Ϊ1,�����Ѱ���
				workRecordnew.setStatus(1);
			}else{
				workRecordnew.setStatus(0);
			}
			commonBiz.getWorkRecordDAO().merge(record);
			commonBiz.getWorkRecordDAO().save(workRecordnew);
			//���ð������İ�����
			workResult.setUser(user);
			//���ð������İ���ʱ��
			workResult.setTransactDate(new Date());
			//���ð����������̼�¼
			workResult.setWorkrecord(workRecordnew);
			//ActionContext.getContext().put("workRecord", workRecordnew);
			ActionContext.getContext().getSession().put("workRecord", workRecordnew);
		}
			
		//����ð�����
		commonBiz.getWorkResultDAO().getHibernateTemplate().save(workResult);
		//ActionContext.getContext().put("msg", "{success:true,msg:'����ɹ�'}");
		
		return Action.SUCCESS;
	}
	
	
	/**
	 * ��ѯ�����
	 * @return
	 */
	public String findMyWork(){
		//��ȡ��ǰ��¼�û�
		User user=(User) ActionContext.getContext().getSession().get("user");
		//��ѯ��Ӧ���û����е����̼�¼
		List<Workrecord> recordList=commonBiz.getWorkRecordDAO().getHibernateTemplate().find("from Workrecord where userByUserByAuthorid.uid=? or userByUserByTransactorId.uid=? ",new Object[]{user.getUid(),user.getUid()});
		//String msg = "{totalCount:" + recordList.size() + ",result:";
		//msg += MyJson.toJsonStr(recordList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("workrecords", recordList);
		return TOSUBMIT;
	}
	
	/**
	 * ��ѯĳ����¼���������
	 * @return
	 */
	public String findWorkResult(){
		// ��ȡ��ǰ��¼�û�
				User user = (User) ActionContext.getContext().getSession().get(
						"user");
				//ͨ��id��ѯһ�����̼�
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
