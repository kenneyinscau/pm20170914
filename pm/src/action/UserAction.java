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
	 * ��¼����
	 * @return
	 */
	public String login(){
		try {
			List list=commonBiz.getUserDAO().getHibernateTemplate().find("from User where name=? and password=? and userState=1",new Object[]{user.getName(),user.getPassword()});
			if (list.size()>0) {
				ActionContext.getContext().getSession().put("user", list.get(0));
				ActionContext.getContext().put("msg", "{success:true,msg:'��¼�ɹ�'}");
				return TOMENU;
			}
			else{
				ActionContext.getContext().put("msg", "{success:false,msg:'�û��������벻��ȷ'}");
				return TOUSER;
				}
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("msg", "{success:false,msg:'ϵͳ�쳣����¼ʧ��'}");
		}
		return TOMENU;
		
	}
	
	/**
	 * ע������
	 * @return
	 */
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		return Action.LOGIN;
	}
	
	
	
	/**
	 * ��ת�û�����ҳ��
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
	 * ��ѯȫ���û���Ϣ
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
	 * ����û�
	 * @return
	 */
	public String addUser(){
		Role role=new Role();
		//����Ĭ�Ͻ�ɫΪ������Ա
		role.setRoleId(3);
		user.setRole(role);
		//����Ĭ�Ͻ�ɫ״̬Ϊ������
		user.setUserState(1);
		commonBiz.getUserDAO().save(user);
		ActionContext.getContext().put("msg", "{success:true,msg:'��ӳɹ�'}");
		return TOMENU;
	}
	
	/**
	 * �޸��û�
	 * @return
	 */
	public String updateUser(){
		commonBiz.getUserDAO().merge(user);
		System.out.println(user.getRole().getRoleId());
		ActionContext.getContext().put("msg", "{success:true,msg:'�޸ĳɹ�'}");
		return TOMENU;
	}
	
	public String updateRole(){
		Role role = new Role();
		role.setRoleId(roleid);
		user.setRole(role);
		commonBiz.getUserDAO().merge(user);
		System.out.println(user.getRole().getRoleId());
		ActionContext.getContext().put("msg", "{success:true,msg:'�޸ĳɹ�'}");
		return TOMENU;
	}
	
	
	/**
	 * ɾ���û�
	 * @return
	 */
	public String deleteUser(){
		System.out.println(userid);
		user=commonBiz.getUserDAO().findById(userid);
		stateid=user.getUserState();
		//���Ϊ����״̬������Ϊδ����
		if(stateid==1){
		user.setUserState(0);
		commonBiz.getUserDAO().merge(user);
		}
		//���Ϊδ����״̬��ɾ���û�
		else
		commonBiz.getUserDAO().delete(user);
		ActionContext.getContext().put("msg", "{success:true,msg:'ɾ���ɹ�'}");
		return TOMENU;
	}
	
	/**
	 * �����û�
	 * @return
	 */
	public String doActive(){
		user=commonBiz.getUserDAO().findById(userid);
		user.setUserState(1);
		commonBiz.getUserDAO().merge(user);
		ActionContext.getContext().put("msg", "{success:true,msg:'����ɹ�'}");
		return TOMENU;
	}
	
	
	public String checkRename(){
		String msg; 
		System.out.println("firstname"+nameFirst+";secondname"+nameSecond);
		if(nameFirst==null||nameSecond==null){
			msg = "���벻Ϊ��";
			ActionContext.getContext().put("msg", msg);
		}
		else if(!nameFirst.equals(nameSecond))
			{msg = "�������벻һ��";
		ActionContext.getContext().put("msg", msg);
			}
			else
				{msg = "����ע��";
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
			ActionContext.getContext().put("msg", "�û����ظ�");
		}
		else{
			ActionContext.getContext().put("msg", "�û�������ʹ��");
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
			ActionContext.getContext().put("msg", "�û����Ϊ"+u.getUid());
		}
		else{
			ActionContext.getContext().put("msg", "�û���������");
			}
		System.out.println(msg);  
		return "success";
	}
}
