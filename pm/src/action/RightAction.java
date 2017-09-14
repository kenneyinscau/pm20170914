package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import util.MyJson;
import util.MyRight;
import biz.CommBiz;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import entity.Right;
import entity.Role;
import entity.User;

public class RightAction {
	
	private static final String TOMENU = "tomenu";
	private static final String TOROLEMANAGE = "torolemanage";
	private CommBiz commonBiz;
	private List<MyRight> myRights;
	private Role role;
	private String rightIds;
	private Integer userid;
	private Integer roleid;
	private String newroleid;

	public String getNewroleid() {
		return newroleid;
	}

	public void setNewroleid(String newroleid) {
		this.newroleid = newroleid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getRightIds() {
		return rightIds;
	}

	public void setRightIds(String rightIds) {
		this.rightIds = rightIds;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<MyRight> getMyRights() {
		return myRights;
	}

	public void setMyRights(List<MyRight> myRights) {
		this.myRights = myRights;
	}

	public CommBiz getCommonBiz() {
		return commonBiz;
	}

	public void setCommonBiz(CommBiz commonBiz) {
		this.commonBiz = commonBiz;
	}
	
	/**
	 * 获取当前用户的权限
	 * @return
	 */
	public String getRightList(){
		User user=(User) ActionContext.getContext().getSession().get("user");
		Set<Right> rights=user.getRole().getRights();
		myRights=new ArrayList<MyRight>();
		for (Right right : rights) {
			if (right.getPid()==0) {
				MyRight myRight=new MyRight();
				myRight.setRight(right);
				for (Right right2 : rights) {
					if (right2.getPid().toString().equals(right.getRightId())) {
						myRight.getRightSubs().add(right2);
					}		
				}
				myRights.add(myRight);
			}
		}
		return TOMENU;
	}
	
	/**
	 * 跳转到角色管理页面
	 * @return
	 */
	public String toRoleManage(){
		return TOROLEMANAGE;
	}
	
	/**
	 * 查询所有角色
	 * @return
	 */
	public String findRoleList(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user.getRole().getRoleId()==1||user.getRole().getRoleId()==5)
			{
			//仅可获得除管理员的所有角色并修改
			List<User> userList=commonBiz.getUserDAO().getHibernateTemplate().find("from User where role.roleId <=4 ");
			ActionContext.getContext().put("users",userList);
			return TOROLEMANAGE;
			}
		else
		return Action.SUCCESS;
		
	}

	/**
	 * 添加角色
	 * @return
	 */
	public String addRole(){
		commonBiz.getRoleDAO().save(role);
		ActionContext.getContext().put("msg", "{success:true,msg:'添加成功'}");
		return Action.SUCCESS;
	}
	
	/**
	 * 修改角色
	 * @return
	 */
	public String updateRole(){
		System.out.println("用户编号是："+userid);
		System.out.println("用户新角色是："+newroleid);
		User user=commonBiz.getUserDAO().findById(userid);
		Role role = new Role();
		
		role.setRoleId(Integer.parseInt(newroleid));
		user.setRole(role);
		commonBiz.getUserDAO().merge(user);
		ActionContext.getContext().put("msg", "{success:true,msg:'修改成功'}");
		return Action.SUCCESS;
	}
	

	/**
	 * 删除角色
	 * @return
	 */
	public String deleteRole(){
		commonBiz.getRoleDAO().delete(role);
		ActionContext.getContext().put("msg", "{success:true,msg:'删除成功'}");
		return Action.SUCCESS;
	}
	
	/**
	 * 查询角色已有权限和可分配权限
	 * @return
	 */
	public String findRightsByRoleId(){
		//全部权限
		List<Right> rightList=commonBiz.getRightDAO().findAll();
		//获取当前角色
		role=commonBiz.getRoleDAO().findById(role.getRoleId());
		//已有的权限
		Set<Right> hasRights=role.getRights();
		//可分配的权限
		List<Right> notRights=new ArrayList<Right>();
		for (Right right : rightList) {
			boolean flag=true;
			for (Right r : hasRights) {
				if (right.getRightId().equals(r.getRightId())) {
					flag=false;
				}
			}
			if (flag) {
				notRights.add(right);
			}
		}
		String msg = "{hasRights:";
		msg += MyJson.toJsonStr(hasRights, new String[]{"oaRoles","url"});
		msg += ",notRights:"+MyJson.toJsonStr(notRights, new String[]{"oaRoles","url"});
		msg += "}";
		ActionContext.getContext().put("msg", msg);
		return Action.SUCCESS;
	}
	
	/**
	 * 执行权限更改
	 * @return
	 */
	public String doUpdateRight(){
		//获取当前角色
		role=commonBiz.getRoleDAO().findById(role.getRoleId());
		String[] ids=rightIds.split(",");
		//清空原有权限
		role.getRights().removeAll(role.getRights());
		if (rightIds!=null&&!rightIds.equals("")) {
			for (String id : ids) {
				Right right=commonBiz.getRightDAO().findById(id);
				role.getRights().add(right);
				right.getRoles().add(role);
			}
		}
		commonBiz.getRoleDAO().merge(role);
		ActionContext.getContext().put("msg", "{success:true,msg:'分配成功'}");
		return Action.SUCCESS;
	}
	
}
