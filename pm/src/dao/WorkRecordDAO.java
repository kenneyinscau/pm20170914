package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Workrecord;

/**
 * A data access object (DAO) providing persistence and search support for
 * WorkRecord entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.WorkRecord
 * @author MyEclipse Persistence Tools
 */

public class WorkRecordDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(WorkRecordDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Workrecord transientInstance) {
		log.debug("saving WorkRecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Workrecord persistentInstance) {
		log.debug("deleting WorkRecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Workrecord findById(java.lang.Integer id) {
		log.debug("getting WorkRecord instance with id: " + id);
		try {
			Workrecord instance = (Workrecord) getHibernateTemplate().get(
					"entity.Workrecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Workrecord instance) {
		log.debug("finding WorkRecord instance by example");
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
		log.debug("finding WorkRecord instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Workrecord as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all WorkRecord instances");
		try {
			String queryString = "from Workrecord";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Workrecord merge(Workrecord detachedInstance) {
		log.debug("merging Workrecord instance");
		try {
			Workrecord result = (Workrecord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Workrecord instance) {
		log.debug("attaching dirty WorkRecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Workrecord instance) {
		log.debug("attaching clean WorkRecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WorkRecordDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WorkRecordDAO) ctx.getBean("WorkRecordDAO");
	}
}