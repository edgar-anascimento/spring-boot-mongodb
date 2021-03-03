package com.example.springbootmongodb.controller;

import com.example.springbootmongodb.service.PersonService;
import com.example.springbootmongodb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/person")
    public List<Person> list() throws Exception {

        return service.listAll();
    }

    @GetMapping(value = "/person/{id}", produces = "application/json")
    Person getPerson(@PathVariable String id) {
        try {
            return service.getPerson(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }

    @PostMapping(value = "/person", consumes = "application/json")
    public void createPerson(@RequestBody Person person) throws Exception {
        service.save(person);
    }

    @PutMapping(value = "/person/{id}", consumes = "application/json")
    public void modifyPerson(@PathVariable String id, @RequestBody Person person) throws
            HttpClientErrorException.NotFound {
        person.setId(id);
        service.save(person);
    }

    @DeleteMapping(value = "/person/{id}")
    public void delete(@PathVariable String id) throws
            HttpClientErrorException.NotFound {
        service.delete(id);
    }
}
