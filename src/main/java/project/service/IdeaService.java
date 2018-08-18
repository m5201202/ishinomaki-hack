package project.service;

import project.model.IdeaEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class IdeaService extends AbstractService<IdeaEntity>{

    @PersistenceContext(name = "Webtrial-persistence-unit")
    private EntityManager entityManager;
    public IdeaService() {super(IdeaEntity.class);}

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
