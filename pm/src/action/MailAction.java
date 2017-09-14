package action;

import java.util.Date;
import java.util.List;

import util.MyJson;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import entity.Mail;
import entity.User;
import entity.Workrecord;
import biz.CommBiz;

public class MailAction {
	private static final String TOSEND = "tosend";
	private static final String TORECEIVE = "toreceive";
	private static final String TODASHBIN = "todashbin";
	private static final String TOMAILDETAIL = "tomaildetail";
	private CommBiz commonBiz;
	private Mail mail;
	private Integer mailid;
	
	public Integer getMailid() {
		return mailid;
	}
	public void setMailid(Integer mailid) {
		this.mailid = mailid;
	}
	public CommBiz getCommonBiz() {
		return commonBiz;
	}
	public void setCommonBiz(CommBiz commonBiz) {
		this.commonBiz = commonBiz;
	}
	public Mail getMail() {
		return mail;
	}
	public void setMail(Mail mail) {
		this.mail = mail;
	}
	/**
	 * 跳转收件箱
	 * @return
	 */
	public String toReceive(){
		return TORECEIVE;
	}
	
	/**
	 * 跳转发件箱
	 * @return
	 */
	public String toSend(){
		return TOSEND;
	}
	
	/**
	 * 跳转发件箱
	 * @return
	 */
	public String toDashbin(){
		return TODASHBIN;
	}
	
	/**
	 * 查询当前用户的收件列表
	 * @return
	 */
	public String findMailList(){
		// 获取当前登录用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		// 获取当前用户的收件列表
		List<Mail> mailList=commonBiz.getMailDAO().getHibernateTemplate().find("from Mail where userByRid.uid=? and receivceDel=0 order by state asc,sendDate desc",user.getUid());
		String msg = "{totalCount:" + mailList.size() + ",result:";
		//msg += MyJson.toJsonStr(mailList, "oaRole");
		//msg += "}";
		//ActionContext.getContext().put("msg", msg);
		ActionContext.getContext().put("mailreceivces", mailList);
		return Action.SUCCESS;
	}
	
	/**
	 * 查询当前用户的发件列表
	 * @return
	 */
	public String findSendMailList(){
		// 获取当前登录用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		// 获取当前用户的发件列表
		List<Mail> mailList=commonBiz.getMailDAO().getHibernateTemplate().find("from Mail where userBySid.uid=? and sendDel=0",user.getUid());
		//String msg = "{totalCount:" + mailList.size() + ",result:";
		//msg += MyJson.toJsonStr(mailList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("mailsends",mailList);
		return Action.SUCCESS;
	}
	
	/**
	 * 查询当前用户的垃圾箱列表
	 * @return
	 */
	public String findJunkMailList(){
		// 获取当前登录用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		// 获取当前用户的垃圾箱列表
		List<Mail> mailList=commonBiz.getMailDAO().getHibernateTemplate().find("from Mail where (sendDel=1 and userBySid.uid=?) or (receivceDel=1 and userByRid.uid=?)",new Object[]{user.getUid(),user.getUid()});
		//String msg = "{totalCount:" + mailList.size() + ",result:";
		//msg += MyJson.toJsonStr(mailList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("maildust", mailList);
		return Action.SUCCESS;
	}
	
	/**
	 * 添加新邮件
	 * @return
	 */
	public String addMail(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		mail.setSendDate(new Date());
		//设置邮件未读
		mail.setState(0);
		mail.setSendDel(0);
		mail.setReceivceDel(0);
		mail.setUserBySid(user);
		commonBiz.getMailDAO().save(mail);
		ActionContext.getContext().put("msg", "{success:true,msg:'发送成功'}");
		return Action.SUCCESS;
	}
	/**
	 * 查询所有收件
	 * @return
	 */
	public String getAllMail(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<Mail> mailList = commonBiz.getMailDAO().getHibernateTemplate().find("from Mail where userByRid.uid=? and state = 0",new Object[]{user.getUid()});
		ActionContext.getContext().put("mails", mailList);
		return TORECEIVE;
	}
	
	/**
	 * 读取未读邮件，修改其状态
	 * @return
	 */
	public String readMail(){
		System.out.println(mailid);
		mail=commonBiz.getMailDAO().findById(mailid);
		mail.setState(1);
		commonBiz.getMailDAO().merge(mail);
		ActionContext.getContext().getSession().put("mail", mail);
		return TOMAILDETAIL;
	}
	/**
	 * 查询所有已阅读收件
	 * @return
	 */
	public String getReadMail(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<Mail> mailList = commonBiz.getMailDAO().getHibernateTemplate().find("from Mail where userByRid.uid=? and state = 1",new Object[]{user.getUid()});
		ActionContext.getContext().put("mails", mailList);
		return TODASHBIN;
	}
	
	
	/**
	 * 临时删除邮件(修改发件状态)   
	 * @return
	 */
	public String sendDeleteMail(){
		mail=commonBiz.getMailDAO().findById(mail.getMid());
		mail.setSendDel(1);
		commonBiz.getMailDAO().merge(mail);
		ActionContext.getContext().put("msg", "{success:true,msg:'删除成功'}");
		return Action.SUCCESS;
	}
	
	/** 
	 * 临时删除邮件(修改收件状态)
	 * @return
	 */
	public String receiveDeleteMail(){
		mail=commonBiz.getMailDAO().findById(mail.getMid());
		mail.setReceivceDel(1);
		commonBiz.getMailDAO().merge(mail);
		ActionContext.getContext().put("msg", "{success:true,msg:'删除成功'}");
		return Action.SUCCESS;
	}
	
	/**
	 * 彻底删除邮件
	 * @return
	 */
	public String deleteMailSure(){
		// 获取当前登录用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		// 获取一条邮件
		mail=commonBiz.getMailDAO().findById(mail.getMid());
		// 如果删除的为收件
		if (user.getName().equals(mail.getUserByRid().getName())) {
			/*
			 * 判断发件状态是否为彻底删除
			 * 如果彻底删除，就将该条数据彻底删除
			 * 否则修改收件状态为2
			 */ 
			if (mail.getSendDel()==2) {
				commonBiz.getMailDAO().delete(mail);
			}else{
				mail.setReceivceDel(2);
				commonBiz.getMailDAO().merge(mail);
			}
		}
		// 如果删除的为发件
		if (user.getName().equals(mail.getUserBySid().getName())) {
			/*
			 * 判断收件状态是否为彻底删除
			 * 如果彻底删除，就将该条数据彻底删除
			 * 否则修改发件状态为2
			 */
			if (mail.getReceivceDel()==2) {
				commonBiz.getMailDAO().delete(mail);
			}else{
				mail.setSendDel(2);
				commonBiz.getMailDAO().merge(mail);
			}
		}
		ActionContext.getContext().put("msg", "{success:true,msg:'删除成功'}");
		return Action.SUCCESS;
	}
}
