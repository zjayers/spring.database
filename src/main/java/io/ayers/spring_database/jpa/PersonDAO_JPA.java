package io.ayers.spring_database.jpa;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDAO_JPA {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person_JPA> fetchMany() {
        TypedQuery<Person_JPA> find_all_persons = entityManager.createNamedQuery("find_all_persons", Person_JPA.class);
        return find_all_persons.getResultList();
    }

    public Person_JPA findById(int id) {
        return entityManager.find(Person_JPA.class, id);
    }

    public Person_JPA insert(Person_JPA person_jpa) {
        return entityManager.merge(person_jpa);
    }

    public Person_JPA update(Person_JPA person_jpa) {
        return entityManager.merge(person_jpa);
    }

    public void deleteById(int id) {
        Person_JPA person = findById(id);
        entityManager.remove(person);
    }

}
