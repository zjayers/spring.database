package io.ayers.spring_database;

import io.ayers.spring_database.jpa.Person_JPA;
import io.ayers.spring_database.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonSpringDataRepository personSpringData;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", personSpringData.findAll());
        logger.info("Single user -> {}", personSpringData.findById(10001));
        logger.info("Inserting User 10004 -> {}", personSpringData.save(new Person_JPA("Tara", "Berlin", new Date())));
        logger.info("Updating User 10003 -> {}", personSpringData.save(new Person_JPA("Peter", "America", new Date())));
        personSpringData.deleteById(10001);
    }
}
