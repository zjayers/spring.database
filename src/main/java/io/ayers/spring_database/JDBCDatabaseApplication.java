package io.ayers.spring_database;

import io.ayers.spring_database.jdbc.Person_JDBC;
import io.ayers.spring_database.jdbc.PersonDAO_JDBC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JDBCDatabaseApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonDAO_JDBC personDAO_jdbc;

    public static void main(String[] args) {
        SpringApplication.run(JDBCDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", personDAO_jdbc.fetchMany());
        logger.info("Single user -> {}", personDAO_jdbc.findById(10001));
        logger.info("Inserting User 10004 -> {}", personDAO_jdbc.insert(new Person_JDBC(10004, "Tara", "Berlin", new Date())));
        logger.info("Updating User 10003 -> {}", personDAO_jdbc.update(new Person_JDBC(10003, "Peter", "America", new Date())));
        logger.info("Delete User, Number of rows deleted -> {}", personDAO_jdbc.deleteById(10002));
    }
}
