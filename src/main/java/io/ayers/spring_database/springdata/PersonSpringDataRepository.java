package io.ayers.spring_database.springdata;

import io.ayers.spring_database.jpa.Person_JPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person_JPA, Integer> { }
