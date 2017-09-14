package action;

import java.util.List;



import org.apache.struts2.json.annotations.JSON;


import util.MyJson;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import biz.CommBiz;
import entity.Role;
import entity.User;


public class UserAction {
	private static final String TOUSERMANAGE = "tousermanage";
	private static final String TOUSER = "touser";
	private static final String TOMENU = "tomenu";
	private static final String TOUSERINFO = "touserinfo";
	private static final String TOROLEINFO = "toroleinfo";
	private static final String TONEWUSER = "tonewuser";
	private CommBiz commonBiz;
	private User user;
	private Integer userid;
	private Integer stateid;
	private Integer roleid;
	private String name;
	private String nameFirst;
	private String nameSecond;
	@JSON(serialize=false)
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JSON(serialize=false)
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	@JSON(serialize=false)
	public String getNameFirst() {
		return nameFirst;
	}
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}
	@JSON(serialize=false)
	public String getNameSecond() {
		return nameSecond;
	}
	public void setNameSecond(String nameSecond) {
		this.nameSecond = nameSecond;
	}
	@JSON(serialize=false)
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	@JSON(serialize=false)
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	@JSON(serialize=false)
	public CommBiz getCommonBiz() {
		return commonBiz;
	}
	public void setCommonBiz(CommBiz commonBiz) {
		this.commonBiz = commonBiz;
	}
	@JSON(serialize=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 登录方法
	 * @return
	 */
	public String login(){
		try {
			List list=commonBiz.getUserDAO().getHibernateTemplate().find("from User where name=? and password=? and userState=1",new Object[]{user.getName(),user.getPassword()});
			if (list.size()>0) {
				ActionContext.getContext().getSession().put("user", list.get(0));
				ActionContext.getContext().put("msg", "{success:true,msg:'登录成功'}");
				return TOMENU;
			}
			else{
				ActionContext.getContext().put("msg", "{success:false,msg:'用户名或密码不正确'}");
				return TOUSER;
				}
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("msg", "{success:false,msg:'系统异常，登录失败'}");
		}
		return TOMENU;
		
	}
	
	/**
	 * 注销方法
	 * @return
	 */
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		return Action.LOGIN;
	}
	
	
	
	/**
	 * 跳转用户管理页面
	 * @return
	 */
	public String toUserManage(){
		return TOUSERMANAGE;
	}
	
	public String toUser(){
		return TOUSER;
	}
	
	public String toMenu(){
		return TOMENU;
	}
	
	public String toNewUser(){
		return TONEWUSER;
	}
	
	public String toUserInfo(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		ActionContext.getContext().put("user",user);
		return TOUSERINFO;
	}
	
	public String toRoleInfo(){
		user=commonBiz.getUserDAO().findById(userid);
		ActionContext.getContext().put("user",user);
		return TOROLEINFO;
	}
	
	public String toChangeInfo(){
		user=commonBiz.getUserDAO().findById(userid);
		ActionContext.getContext().put("user",user);
		return TOUSERINFO;
	}
	
	/**
	 * 查询全部用户信息
	 * @return
	 */
	public String findUserList(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user.getRole().getRoleId()==5)
			{
			List<User> userList=commonBiz.getUserDAO().findAll();
			ActionContext.getContext().put("users",userList);
			return TOUSERMANAGE;
			}
		else
		return TOMENU;
	}
	
	
	/**
	 * 添加用户
	 * @return
	 */
	public String addUser(){
		Role role=new Role();
		//设置默认角色为开发人员
		role.setRoleId(3);
		user.setRole(role);
		//设置默认角色状态为激活中
		user.setUserState(1);
		commonBiz.getUserDAO().save(user);
		ActionContext.getContext().put("msg", "{success:true,msg:'添加成功'}");
		return TOMENU;
	}
	
	/**
	 * 修改用户
	 * @return
	 */
	public String updateUser(){
		commonBiz.getUserDAO().merge(user);
		System.out.println(user.getRole().getRoleId());
		ActionContext.getContext().put("msg", "{success:true,msg:'修改成功'}");
		return TOMENU;
	}
	
	public String updateRole(){
		Role role = new Role();
		role.setRoleId(roleid);
		user.setRole(role);
		commonBiz.getUserDAO().merge(user);
		System.out.println(user.getRole().getRoleId());
		ActionContext.getContext().put("msg", "{success:true,msg:'修改成功'}");
		return TOMENU;
	}
	
	
	/**
	 * 删除用户
	 * @return
	 */
	public String deleteUser(){
		System.out.println(userid);
		user=commonBiz.getUserDAO().findById(userid);
		stateid=user.getUserState();
		//如果为激活状态，设置为未激活
		if(stateid==1){
		user.setUserState(0);
		commonBiz.getUserDAO().merge(user);
		}
		//如果为未激活状态，删除用户
		else
		commonBiz.getUserDAO().delete(user);
		ActionContext.getContext().put("msg", "{success:true,msg:'删除成功'}");
		return TOMENU;
	}
	
	/**
	 * 激活用户
	 * @return
	 */
	public String doActive(){
		user=commonBiz.getUserDAO().findById(userid);
		user.setUserState(1);
		commonBiz.getUserDAO().merge(user);
		ActionContext.getContext().put("msg", "{success:true,msg:'激活成功'}");
		return TOMENU;
	}
	
	
	public String checkRename(){
		String msg; 
		System.out.println("firstname"+nameFirst+";secondname"+nameSecond);
		if(nameFirst==null||nameSecond==null){
			msg = "密码不为空";
			ActionContext.getContext().put("msg", msg);
		}
		else if(!nameFirst.equals(nameSecond))
			{msg = "两次输入不一致";
		ActionContext.getContext().put("msg", msg);
			}
			else
				{msg = "可以注册";
		ActionContext.getContext().put("msg", msg);
				}
				System.out.println(msg);			
				return "success";	
	}
	
	public String checkName(){
		String msg="null"; 
		System.out.println("name="+name);
		List list=commonBiz.getUserDAO().getHibernateTemplate().find("from User where name=?",new Object[]{name});
		if (list.size()>0) {
			ActionContext.getContext().put("msg", "用户名重复");
		}
		else{
			ActionContext.getContext().put("msg", "用户名可以使用");
			}
				System.out.println(msg);			
				return "success";	
	}
	
	public String findNo(){
		String msg=null;
		User example = new User();
		example.setName(name);
		System.out.println(name);
		List<User> userList = commonBiz.getUserDAO().findByExample(example);
		if(userList.size()>0){
		User u = userList.get(0);
		/*User u = commonBiz.getUserDAO().findByName(name);*/
		System.out.println(u.getUid());
/*		Integer rid = u.getRole().getRoleId();
		Role role = commonBiz.getRoleDAO().findById(rid);
		System.out.println(role.getRoleName());*/
			ActionContext.getContext().put("msg", "用户编号为"+u.getUid());
		}
		else{
			ActionContext.getContext().put("msg", "用户名不存在");
			}
		System.out.println(msg);  
		return "success";
	}
}
