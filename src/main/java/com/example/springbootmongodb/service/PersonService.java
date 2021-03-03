package com.example.springbootmongodb.service;

import com.example.springbootmongodb.entity.Person;
import com.example.springbootmongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repo;

    public List<Person> listAll() {

        return repo.findAll();
    }

    public void save(Person person) {

        repo.save(person);
    }

    public Person getPerson(String id) {

        return repo.findById(id).get();
    }

    public void delete(String id) {

        repo.deleteById(id);
    }

}
