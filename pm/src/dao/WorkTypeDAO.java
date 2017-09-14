package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Worktype;

/**
 * A data access object (DAO) providing persistence and search support for
 * WorkType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.WorkType
 * @author MyEclipse Persistence Tools
 */

public class WorkTypeDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(WorkTypeDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Worktype transientInstance) {
		log.debug("saving WorkType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Worktype persistentInstance) {
		log.debug("deleting WorkType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Worktype findById(java.lang.Integer id) {
		log.debug("getting WorkType instance with id: " + id);
		try {
			Worktype instance = (Worktype) getHibernateTemplate().get(
					"entity.Worktype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Worktype instance) {
		log.debug("finding WorkType instance by example");
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
		log.debug("finding WorkType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Worktype as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all WorkType instances");
		try {
			String queryString = "from Worktype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Worktype merge(Worktype detachedInstance) {
		log.debug("merging WorkType instance");
		try {
			Worktype result = (Worktype) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Worktype instance) {
		log.debug("attaching dirty WorkType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Worktype instance) {
		log.debug("attaching clean WorkType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WorkTypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WorkTypeDAO) ctx.getBean("WorkTypeDAO");
	}
}