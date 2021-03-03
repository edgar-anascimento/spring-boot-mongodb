package com.example.springbootmongodb.entity;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Person {
    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private Integer age;

    public Person(String id, String name, String lastname, Integer age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public Person() {
    }

    public String getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getLastname() {

        return lastname;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setLastname(String lastname) {

        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
