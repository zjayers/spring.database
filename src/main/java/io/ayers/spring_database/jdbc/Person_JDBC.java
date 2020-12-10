package io.ayers.spring_database.jdbc;

import java.util.Date;

public class Person_JDBC {
    private int id;
    private String name;
    private String location;
    private Date birthDate;

    public Person_JDBC() {
    }

    public Person_JDBC(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("\nPerson{id=%d, name='%s', location='%s', birthDate=%s}", id, name, location, birthDate);
    }
}
