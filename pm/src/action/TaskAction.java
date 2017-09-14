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
	 * 跳转到事务页面
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
	 * 查询自己的事务
	 * @return
	 */
	public String findTaskList(){
		// 获取当前登录用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		// 获取当前用户的事务列表
		List<Task> taskList=commonBiz.getTaskDAO().getHibernateTemplate().find("from Task where user.uid=?",user.getUid());
		//String msg = "{totalCount:" + taskList.size() + ",result:";
		//msg += MyJson.toJsonStr(taskList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("tasks", taskList);
		return Action.SUCCESS;
	}
	
	/**
	 * 查询事务类型
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
	 * 添加事务
	 * @return
	 */
	public String addTask(){
		commonBiz.getTaskDAO().save(task);
		ActionContext.getContext().put("msg", "{success:true,msg:'添加成功'}");
		return Action.SUCCESS;
	}
	
	/**
	 * 修改事务
	 * @return
	 */
	public String updateTask(){
		commonBiz.getTaskDAO().merge(task);
		ActionContext.getContext().put("msg", "{success:true,msg:'修改成功'}");
		return Action.SUCCESS;
	}
	
	/**
	 * 删除事务
	 * @return
	 */
	public String deleteTask(){
		commonBiz.getTaskDAO().delete(task);
		ActionContext.getContext().put("msg", "{success:true,msg:'删除成功'}");
		return Action.SUCCESS;
	}
	
	
	/**
	 * 查询已完成及未完成数量
	 * @return
	 */
	public String findWorkCount(){
		//获取当前登录用户
		User user=(User) ActionContext.getContext().getSession().get("user");
		//查询项目进行中任务数量
		List<Workrecord> nonfinishList=commonBiz.getWorkRecordDAO().getHibernateTemplate().find("from Workrecord where status = 0");
		int nonfinishCount = nonfinishList.size();
		//查询项目完结的任务数量
		List<Workrecord> finishList=commonBiz.getWorkRecordDAO().getHibernateTemplate().find("from Workrecord where status = 1");
		int finishCount = finishList.size();
		ActionContext.getContext().put("nonfinishCount", nonfinishCount);
		ActionContext.getContext().put("finishCount", finishCount);
		return TOPERSONTASK;
	}
}
