package project.service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractService<T> {
    private Class<T> entityClass;
    @PersistenceContext
    protected EntityManager entityManager;
    protected CriteriaBuilder baseBuilder;
    protected CriteriaQuery<T> baseQuery;
    protected Root<T> baseModel;
    protected Logger logger;

    public AbstractService(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    @PostConstruct
    public void init() {
        baseBuilder = entityManager.getCriteriaBuilder();
        resetBaseQuery();
        logger = Logger.getLogger(this.getClass().getName());
        logger.addHandler(new ConsoleHandler());
        logger.setLevel(Level.ALL);
    }

    protected void resetBaseQuery() {
        baseQuery = baseBuilder.createQuery(entityClass);
        baseModel = baseQuery.from(entityClass);
    }

    protected Query select() {
        CriteriaQuery<T> cq = entityManager.getCriteriaBuilder().createQuery(entityClass);
        cq.select(cq.from(entityClass));
        return entityManager.createQuery(cq);
    }

    protected CriteriaQuery criteriaQuery() {
        CriteriaQuery<T> cq = entityManager.getCriteriaBuilder().createQuery(entityClass);
        return cq.select(cq.from(entityClass));
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity){
        getEntityManager().persist(entity);
    }

    public void edit(T entity){
        getEntityManager().merge(entity);
    }

    public void remove(T entity){
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id){
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
