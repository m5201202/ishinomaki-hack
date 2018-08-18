package project.service;

import project.model.UserEntity;
import project.model.UserEntity_;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserService extends AbstractService<UserEntity> {
    @PersistenceContext(name = "Webtrial-persistence-unit")
    private EntityManager entityManager;

    public UserService() {
        super(UserEntity.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public UserEntity findByLogin(String login) {
        baseQuery.where(baseBuilder.equal(baseModel.get(UserEntity_.login), login));
        return entityManager.createQuery(baseQuery).getSingleResult();
    }
}
