package ru.netology.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import ru.netology.entity.Persons;

import java.util.List;

@Repository

public class PersonsRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Persons> getPersonsByCity(String city){
        var query = entityManager.createQuery("select p from Persons p where lower(p.cityOfLiving) = lower(:city)", Persons.class);
        query.setParameter("city",city);
        return query.getResultList();

    }
}