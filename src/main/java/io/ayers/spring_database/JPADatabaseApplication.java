package io.ayers.spring_database;

import io.ayers.spring_database.jpa.PersonDAO_JPA;
import io.ayers.spring_database.jpa.Person_JPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JPADatabaseApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonDAO_JPA personDAO_jpa;

    public static void main(String[] args) {
        SpringApplication.run(JPADatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", personDAO_jpa.fetchMany());
        logger.info("Single user -> {}", personDAO_jpa.findById(10001));
        logger.info("Inserting User 10004 -> {}", personDAO_jpa.insert(new Person_JPA("Tara", "Berlin", new Date())));
        logger.info("Updating User 10003 -> {}", personDAO_jpa.update(new Person_JPA("Peter", "America", new Date())));
        personDAO_jpa.deleteById(10002);
    }
}
