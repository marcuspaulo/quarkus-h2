package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PersonService {
    @Inject
    EntityManager em;

    public List<Person> findAll() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Transactional
    public void create(String name) {
        em.persist(new Person(name));
    }
}