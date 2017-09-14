package biz;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import util.Page;
import dao.AfficheDAO;
import dao.MailDAO;
import dao.RightDAO;
import dao.RoleDAO;
import dao.TaskDAO;
import dao.TaskTypeDAO;
import dao.UserDAO;
import dao.WorkFlowDAO;
import dao.WorkOrderDAO;
import dao.WorkRecordDAO;
import dao.WorkResultDAO;
import dao.WorkTypeDAO;

public class CommBiz {
	private UserDAO userDAO;
	private RightDAO rightDAO;
	private RoleDAO roleDAO;
	private WorkFlowDAO workFlowDAO;
	private WorkOrderDAO workOrderDAO;
	private WorkRecordDAO workRecordDAO;
	private WorkResultDAO workResultDAO;
	private WorkTypeDAO workTypeDAO;
	private TaskDAO taskDAO;
	private TaskTypeDAO taskTypeDAO;
	private MailDAO MailDAO;
	private AfficheDAO afficheDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public RightDAO getRightDAO() {
		return rightDAO;
	}
	public void setRightDAO(RightDAO rightDAO) {
		this.rightDAO = rightDAO;
	}
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	public WorkFlowDAO getWorkFlowDAO() {
		return workFlowDAO;
	}
	public void setWorkFlowDAO(WorkFlowDAO workFlowDAO) {
		this.workFlowDAO = workFlowDAO;
	}
	public WorkOrderDAO getWorkOrderDAO() {
		return workOrderDAO;
	}
	public void setWorkOrderDAO(WorkOrderDAO workOrderDAO) {
		this.workOrderDAO = workOrderDAO;
	}
	public WorkRecordDAO getWorkRecordDAO() {
		return workRecordDAO;
	}
	public void setWorkRecordDAO(WorkRecordDAO workRecordDAO) {
		this.workRecordDAO = workRecordDAO;
	}
	public WorkResultDAO getWorkResultDAO() {
		return workResultDAO;
	}
	public void setWorkResultDAO(WorkResultDAO workResultDAO) {
		this.workResultDAO = workResultDAO;
	}
	public WorkTypeDAO getWorkTypeDAO() {
		return workTypeDAO;
	}
	public void setWorkTypeDAO(WorkTypeDAO workTypeDAO) {
		this.workTypeDAO = workTypeDAO;
	}
	public TaskDAO getTaskDAO() {
		return taskDAO;
	}
	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}
	public TaskTypeDAO getTaskTypeDAO() {
		return taskTypeDAO;
	}
	public void setTaskTypeDAO(TaskTypeDAO taskTypeDAO) {
		this.taskTypeDAO = taskTypeDAO;
	}
	public MailDAO getMailDAO() {
		return MailDAO;
	}
	public void setMailDAO(MailDAO mailDAO) {
		MailDAO = mailDAO;
	}
	public AfficheDAO getAfficheDAO() {
		return afficheDAO;
	}
	public void setAfficheDAO(AfficheDAO afficheDAO) {
		this.afficheDAO = afficheDAO;
	}
	
	
	public Page findByPage(Class clazz,int start,int limit,String sort,String dir){
		DetachedCriteria criteria=DetachedCriteria.forClass(clazz);
		if("ASC".equals(dir))
			criteria.addOrder(Order.asc(sort));
		if("DESC".equals(dir))
			criteria.addOrder(Order.desc(sort));
		List result=workFlowDAO.getHibernateTemplate().findByCriteria(criteria, start, limit);
		
		int totalCount=Integer.parseInt(workFlowDAO.getHibernateTemplate().find("select count(*) from "+clazz.getSimpleName()).get(0).toString());
		Page page=new Page(result,totalCount);
		return page;
	}
	

	
}
