package ru.bellintegrator.practice.soldier.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.soldier.model.Soldier;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class SoldierDaoImpl implements SoldierDao {

    private final EntityManager em;

    @Autowired
    public SoldierDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Soldier> all() {
        TypedQuery<Soldier> query = em.createQuery("SELECT p FROM Person p", Soldier.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Soldier loadById(Long id) {
        return em.find(Soldier.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Soldier loadByName(String name) {
        CriteriaQuery<Soldier> criteria = buildCriteria(name);
        TypedQuery<Soldier> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Soldier soldier) {
        em.persist(soldier);
    }

    private CriteriaQuery<Soldier> buildCriteria(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Soldier> criteria = builder.createQuery(Soldier.class);

        Root<Soldier> person = criteria.from(Soldier.class);
        criteria.where(builder.equal(person.get("name"), name));

        return criteria;
    }
}
