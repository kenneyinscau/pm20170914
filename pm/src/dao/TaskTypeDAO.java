package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Tasktype;

/**
 * A data access object (DAO) providing persistence and search support for
 * TaskType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.TaskType
 * @author MyEclipse Persistence Tools
 */

public class TaskTypeDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TaskTypeDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Tasktype transientInstance) {
		log.debug("saving TaskType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tasktype persistentInstance) {
		log.debug("deleting TaskType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tasktype findById(java.lang.Integer id) {
		log.debug("getting TaskType instance with id: " + id);
		try {
			Tasktype instance = (Tasktype) getHibernateTemplate().get(
					"entity.Tasktype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tasktype instance) {
		log.debug("finding TaskType instance by example");
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
		log.debug("finding TaskType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Tasktype as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TaskType instances");
		try {
			String queryString = "from Tasktype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tasktype merge(Tasktype detachedInstance) {
		log.debug("merging TaskType instance");
		try {
			Tasktype result = (Tasktype) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tasktype instance) {
		log.debug("attaching dirty TaskType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tasktype instance) {
		log.debug("attaching clean TaskType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TaskTypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TaskTypeDAO) ctx.getBean("TaskTypeDAO");
	}
}