package io.ayers.spring_database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonDAO_JDBC {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Can use a custom row mapper - or a BeanPropertyRowMapper if column names match the entity property names
    static class PersonRowMapper implements RowMapper<Person_JDBC> {

        @Override
        public Person_JDBC mapRow(ResultSet resultSet, int i) throws SQLException {
            Person_JDBC personJDBC = new Person_JDBC();
            personJDBC.setId(resultSet.getInt("id"));
            personJDBC.setName(resultSet.getString("name"));
            personJDBC.setLocation(resultSet.getString("location"));
            personJDBC.setBirthDate(resultSet.getTimestamp("birth_date"));
            return personJDBC;
        }
    }

    public List<Person_JDBC> fetchMany() {
        return jdbcTemplate.query("SELECT * FROM person", new PersonRowMapper());
    }

    public Person_JDBC findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person_JDBC.class));
    }

    public int insert(Person_JDBC personJDBC) {
        return jdbcTemplate.update("INSERT INTO person (id, name, location, birth_date) " +
                "VALUES (?, ?, ?, ?)", personJDBC.getId(), personJDBC.getName(), personJDBC.getLocation(), new Timestamp(personJDBC.getBirthDate().getTime()));
    }

    public int update(Person_JDBC personJDBC) {
        return jdbcTemplate.update("UPDATE person set name = ?,location = ?, birth_date = ? where id = ?", personJDBC.getName(), personJDBC.getLocation(), new Timestamp(personJDBC.getBirthDate().getTime()), personJDBC.getId());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }
}
