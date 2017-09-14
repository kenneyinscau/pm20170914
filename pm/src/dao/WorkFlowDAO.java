package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Workflow;

/**
 * A data access object (DAO) providing persistence and search support for
 * WorkFlow entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.WorkFlow
 * @author MyEclipse Persistence Tools
 */

public class WorkFlowDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(WorkFlowDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Workflow transientInstance) {
		log.debug("saving WorkFlow instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Workflow persistentInstance) {
		log.debug("deleting WorkFlow instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Workflow findById(java.lang.Integer id) {
		log.debug("getting WorkFlow instance with id: " + id);
		try {
			Workflow instance = (Workflow) getHibernateTemplate().get(
					"entity.Workflow", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Workflow instance) {
		log.debug("finding WorkFlow instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding WorkFlow instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Workflow as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all WorkFlow instances");
		try {
			String queryString = "from Workflow";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Workflow merge(Workflow detachedInstance) {
		log.debug("merging WorkFlow instance");
		try {
			Workflow result = (Workflow) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Workflow instance) {
		log.debug("attaching dirty WorkFlow instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Workflow instance) {
		log.debug("attaching clean WorkFlow instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WorkFlowDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WorkFlowDAO) ctx.getBean("WorkFlowDAO");
	}
}