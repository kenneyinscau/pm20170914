package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Task;

/**
 * A data access object (DAO) providing persistence and search support for Task
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see entity.Task
 * @author MyEclipse Persistence Tools
 */

public class TaskDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TaskDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Task transientInstance) {
		log.debug("saving Task instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Task persistentInstance) {
		log.debug("deleting Task instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Task findById(java.lang.Integer id) {
		log.debug("getting Task instance with id: " + id);
		try {
			Task instance = (Task) getHibernateTemplate()
					.get("entity.Task", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Task instance) {
		log.debug("finding Task instance by example");
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
		log.debug("finding Task instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Task as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Task instances");
		try {
			String queryString = "from Task";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Task merge(Task detachedInstance) {
		log.debug("merging Task instance");
		try {
			Task result = (Task) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Task instance) {
		log.debug("attaching dirty Task instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Task instance) {
		log.debug("attaching clean Task instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TaskDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TaskDAO) ctx.getBean("TaskDAO");
	}
}