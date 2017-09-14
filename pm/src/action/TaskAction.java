package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import util.MyJson;
import biz.CommBiz;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import entity.User;
import entity.Task;
import entity.Tasktype;
import entity.Workrecord;

public class TaskAction {
	private static final String TOPERSONTASK = "topersontask";
	private CommBiz commonBiz;
	private Task task;
	public CommBiz getCommonBiz() {
		return commonBiz;
	}
	public void setCommonBiz(CommBiz commonBiz) {
		this.commonBiz = commonBiz;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	
	/**
	 * ��ת������ҳ��
	 * @return
	 */
	public String toPersonTask(){
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		GregorianCalendar g=new GregorianCalendar();
//		g.setTime(new Date());
//		g.add(g.SECOND, -1);
//		ActionContext.getContext().put("date", sdf.format(g.getTime()));
		return TOPERSONTASK;
	}
	
	/**
	 * ��ѯ�Լ�������
	 * @return
	 */
	public String findTaskList(){
		// ��ȡ��ǰ��¼�û�
		User user = (User) ActionContext.getContext().getSession().get("user");
		// ��ȡ��ǰ�û��������б�
		List<Task> taskList=commonBiz.getTaskDAO().getHibernateTemplate().find("from Task where user.uid=?",user.getUid());
		//String msg = "{totalCount:" + taskList.size() + ",result:";
		//msg += MyJson.toJsonStr(taskList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("tasks", taskList);
		return Action.SUCCESS;
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String findTaskType(){
		List<Tasktype> taskTypeList=commonBiz.getTaskTypeDAO().findAll();
		//String msg = "{totalCount:" + taskTypeList.size() + ",result:";
		//msg += MyJson.toJsonStr(taskTypeList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("tasktypes", taskTypeList);
		return Action.SUCCESS;
	}
	
	/**
	 * �������
	 * @return
	 */
	public String addTask(){
		commonBiz.getTaskDAO().save(task);
		ActionContext.getContext().put("msg", "{success:true,msg:'��ӳɹ�'}");
		return Action.SUCCESS;
	}
	
	/**
	 * �޸�����
	 * @return
	 */
	public String updateTask(){
		commonBiz.getTaskDAO().merge(task);
		ActionContext.getContext().put("msg", "{success:true,msg:'�޸ĳɹ�'}");
		return Action.SUCCESS;
	}
	
	/**
	 * ɾ������
	 * @return
	 */
	public String deleteTask(){
		commonBiz.getTaskDAO().delete(task);
		ActionContext.getContext().put("msg", "{success:true,msg:'ɾ���ɹ�'}");
		return Action.SUCCESS;
	}
	
	
	/**
	 * ��ѯ����ɼ�δ�������
	 * @return
	 */
	public String findWorkCount(){
		//��ȡ��ǰ��¼�û�
		User user=(User) ActionContext.getContext().getSession().get("user");
		//��ѯ��Ŀ��������������
		List<Workrecord> nonfinishList=commonBiz.getWorkRecordDAO().getHibernateTemplate().find("from Workrecord where status = 0");
		int nonfinishCount = nonfinishList.size();
		//��ѯ��Ŀ������������
		List<Workrecord> finishList=commonBiz.getWorkRecordDAO().getHibernateTemplate().find("from Workrecord where status = 1");
		int finishCount = finishList.size();
		ActionContext.getContext().put("nonfinishCount", nonfinishCount);
		ActionContext.getContext().put("finishCount", finishCount);
		return TOPERSONTASK;
	}
}
