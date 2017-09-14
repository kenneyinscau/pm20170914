package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Workresult;

/**
 * A data access object (DAO) providing persistence and search support for
 * WorkResult entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.WorkResult
 * @author MyEclipse Persistence Tools
 */

public class WorkResultDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(WorkResultDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Workresult transientInstance) {
		log.debug("saving WorkResult instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Workresult persistentInstance) {
		log.debug("deleting WorkResult instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Workresult findById(java.lang.Integer id) {
		log.debug("getting WorkResult instance with id: " + id);
		try {
			Workresult instance = (Workresult) getHibernateTemplate().get(
					"entity.Workresult", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Workresult instance) {
		log.debug("finding WorkResult instance by example");
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
		log.debug("finding WorkResult instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Workresult as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all WorkResult instances");
		try {
			String queryString = "from Workresult";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Workresult merge(Workresult detachedInstance) {
		log.debug("merging WorkResult instance");
		try {
			Workresult result = (Workresult) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Workresult instance) {
		log.debug("attaching dirty WorkResult instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Workresult instance) {
		log.debug("attaching clean WorkResult instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WorkResultDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WorkResultDAO) ctx.getBean("WorkResultDAO");
	}
}