package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Right;

/**
 * A data access object (DAO) providing persistence and search support for
 * Right entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Right
 * @author MyEclipse Persistence Tools
 */

public class RightDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(RightDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Right transientInstance) {
		log.debug("saving Right instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Right persistentInstance) {
		log.debug("deleting Right instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Right findById(java.lang.String id) {
		log.debug("getting Right instance with id: " + id);
		try {
			Right instance = (Right) getHibernateTemplate().get(
					"entity.Right", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Right instance) {
		log.debug("finding Right instance by example");
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
		log.debug("finding Right instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Right as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Right instances");
		try {
			String queryString = "from Right";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Right merge(Right detachedInstance) {
		log.debug("merging Right instance");
		try {
			Right result = (Right) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Right instance) {
		log.debug("attaching dirty Right instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Right instance) {
		log.debug("attaching clean Right instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RightDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RightDAO) ctx.getBean("RightDAO");
	}
}