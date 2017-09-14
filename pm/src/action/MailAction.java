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
	 * ��ת�ռ���
	 * @return
	 */
	public String toReceive(){
		return TORECEIVE;
	}
	
	/**
	 * ��ת������
	 * @return
	 */
	public String toSend(){
		return TOSEND;
	}
	
	/**
	 * ��ת������
	 * @return
	 */
	public String toDashbin(){
		return TODASHBIN;
	}
	
	/**
	 * ��ѯ��ǰ�û����ռ��б�
	 * @return
	 */
	public String findMailList(){
		// ��ȡ��ǰ��¼�û�
		User user = (User) ActionContext.getContext().getSession().get("user");
		// ��ȡ��ǰ�û����ռ��б�
		List<Mail> mailList=commonBiz.getMailDAO().getHibernateTemplate().find("from Mail where userByRid.uid=? and receivceDel=0 order by state asc,sendDate desc",user.getUid());
		String msg = "{totalCount:" + mailList.size() + ",result:";
		//msg += MyJson.toJsonStr(mailList, "oaRole");
		//msg += "}";
		//ActionContext.getContext().put("msg", msg);
		ActionContext.getContext().put("mailreceivces", mailList);
		return Action.SUCCESS;
	}
	
	/**
	 * ��ѯ��ǰ�û��ķ����б�
	 * @return
	 */
	public String findSendMailList(){
		// ��ȡ��ǰ��¼�û�
		User user = (User) ActionContext.getContext().getSession().get("user");
		// ��ȡ��ǰ�û��ķ����б�
		List<Mail> mailList=commonBiz.getMailDAO().getHibernateTemplate().find("from Mail where userBySid.uid=? and sendDel=0",user.getUid());
		//String msg = "{totalCount:" + mailList.size() + ",result:";
		//msg += MyJson.toJsonStr(mailList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("mailsends",mailList);
		return Action.SUCCESS;
	}
	
	/**
	 * ��ѯ��ǰ�û����������б�
	 * @return
	 */
	public String findJunkMailList(){
		// ��ȡ��ǰ��¼�û�
		User user = (User) ActionContext.getContext().getSession().get("user");
		// ��ȡ��ǰ�û����������б�
		List<Mail> mailList=commonBiz.getMailDAO().getHibernateTemplate().find("from Mail where (sendDel=1 and userBySid.uid=?) or (receivceDel=1 and userByRid.uid=?)",new Object[]{user.getUid(),user.getUid()});
		//String msg = "{totalCount:" + mailList.size() + ",result:";
		//msg += MyJson.toJsonStr(mailList, "oaRole");
		//msg += "}";
		ActionContext.getContext().put("maildust", mailList);
		return Action.SUCCESS;
	}
	
	/**
	 * ������ʼ�
	 * @return
	 */
	public String addMail(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		mail.setSendDate(new Date());
		//�����ʼ�δ��
		mail.setState(0);
		mail.setSendDel(0);
		mail.setReceivceDel(0);
		mail.setUserBySid(user);
		commonBiz.getMailDAO().save(mail);
		ActionContext.getContext().put("msg", "{success:true,msg:'���ͳɹ�'}");
		return Action.SUCCESS;
	}
	/**
	 * ��ѯ�����ռ�
	 * @return
	 */
	public String getAllMail(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<Mail> mailList = commonBiz.getMailDAO().getHibernateTemplate().find("from Mail where userByRid.uid=? and state = 0",new Object[]{user.getUid()});
		ActionContext.getContext().put("mails", mailList);
		return TORECEIVE;
	}
	
	/**
	 * ��ȡδ���ʼ����޸���״̬
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
	 * ��ѯ�������Ķ��ռ�
	 * @return
	 */
	public String getReadMail(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<Mail> mailList = commonBiz.getMailDAO().getHibernateTemplate().find("from Mail where userByRid.uid=? and state = 1",new Object[]{user.getUid()});
		ActionContext.getContext().put("mails", mailList);
		return TODASHBIN;
	}
	
	
	/**
	 * ��ʱɾ���ʼ�(�޸ķ���״̬)   
	 * @return
	 */
	public String sendDeleteMail(){
		mail=commonBiz.getMailDAO().findById(mail.getMid());
		mail.setSendDel(1);
		commonBiz.getMailDAO().merge(mail);
		ActionContext.getContext().put("msg", "{success:true,msg:'ɾ���ɹ�'}");
		return Action.SUCCESS;
	}
	
	/** 
	 * ��ʱɾ���ʼ�(�޸��ռ�״̬)
	 * @return
	 */
	public String receiveDeleteMail(){
		mail=commonBiz.getMailDAO().findById(mail.getMid());
		mail.setReceivceDel(1);
		commonBiz.getMailDAO().merge(mail);
		ActionContext.getContext().put("msg", "{success:true,msg:'ɾ���ɹ�'}");
		return Action.SUCCESS;
	}
	
	/**
	 * ����ɾ���ʼ�
	 * @return
	 */
	public String deleteMailSure(){
		// ��ȡ��ǰ��¼�û�
		User user = (User) ActionContext.getContext().getSession().get("user");
		// ��ȡһ���ʼ�
		mail=commonBiz.getMailDAO().findById(mail.getMid());
		// ���ɾ����Ϊ�ռ�
		if (user.getName().equals(mail.getUserByRid().getName())) {
			/*
			 * �жϷ���״̬�Ƿ�Ϊ����ɾ��
			 * �������ɾ�����ͽ��������ݳ���ɾ��
			 * �����޸��ռ�״̬Ϊ2
			 */ 
			if (mail.getSendDel()==2) {
				commonBiz.getMailDAO().delete(mail);
			}else{
				mail.setReceivceDel(2);
				commonBiz.getMailDAO().merge(mail);
			}
		}
		// ���ɾ����Ϊ����
		if (user.getName().equals(mail.getUserBySid().getName())) {
			/*
			 * �ж��ռ�״̬�Ƿ�Ϊ����ɾ��
			 * �������ɾ�����ͽ��������ݳ���ɾ��
			 * �����޸ķ���״̬Ϊ2
			 */
			if (mail.getReceivceDel()==2) {
				commonBiz.getMailDAO().delete(mail);
			}else{
				mail.setSendDel(2);
				commonBiz.getMailDAO().merge(mail);
			}
		}
		ActionContext.getContext().put("msg", "{success:true,msg:'ɾ���ɹ�'}");
		return Action.SUCCESS;
	}
}
