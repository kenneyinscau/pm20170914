package action;

import java.util.List;

import util.MyJson;
import util.Page;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import entity.Affiche;
import entity.User;
import entity.Task;
import biz.CommBiz;
/**
 * change by dingxiaotao
 * @author dingxiaotao
 *
 */
public class AfficheAction {
	private static final String TOTEAMMAIL = "toteammail";
	private static final String TOMAILMANAGEMENT = "tomailmanagement";
	private CommBiz commonBiz;
	private Affiche affiche;
	private int start;
	private int limit;
	private String sort;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}



	private String dir;
	public CommBiz getCommonBiz() {
		return commonBiz;
	}
	public void setCommonBiz(CommBiz commonBiz) {
		this.commonBiz = commonBiz;
	}
	public Affiche getAffiche() {
		return affiche;
	}
	public void setAffiche(Affiche affiche) {
		this.affiche = affiche;
	}
	
	/**
	 * 跳转到公告页面
	 * @return
	 */
	public String toTeamMail(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user.getRole().getRoleId()==1||user.getRole().getRoleId()==5)
		return TOTEAMMAIL;
		else
		return Action.SUCCESS;
	}
	public String toMailMangement(){
		return TOMAILMANAGEMENT;
	}
	/**
	 * 查询公告
	 * @return
	 */
	public String findAfficheList(){
		// 获取当前用户的事务列表
		List<Affiche> afficheList=commonBiz.getAfficheDAO().findAll();
		//String msg = "{totalCount:" + afficheList.size() + ",result:";
		//msg += MyJson.toJsonStr(afficheList, "oaRole");
		//msg += "}";
		//ActionContext.getContext().put("msg", msg);
		ActionContext.getContext().put("affiches", afficheList);
		return TOMAILMANAGEMENT;
	}
	/**
	 * 添加公告
	 * @return
	 */
	public String addAffiche(){
		// 获取当前登录用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		affiche.setUser(user);
		commonBiz.getAfficheDAO().save(affiche);
		ActionContext.getContext().put("msg", "{success:true,msg:'添加成功'}");
		return Action.SUCCESS;
	}
	
	/**
	 * 修改公告
	 * @return
	 */
	public String updateAffiche(){
		commonBiz.getAfficheDAO().merge(affiche);
		ActionContext.getContext().put("msg", "{success:true,msg:'修改成功'}");
		return Action.SUCCESS;
	}
	
	/**
	 * 删除公告
	 * @return
	 */
	public String deleteAffiche(){
		commonBiz.getAfficheDAO().delete(affiche);
		ActionContext.getContext().put("msg", "{success:true,msg:'删除成功'}");
		return Action.SUCCESS;
	}
	
	
	
}
