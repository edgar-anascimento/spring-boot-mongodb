package com.example.springbootmongodb.controller;

import com.example.springbootmongodb.entity.Person;
import com.example.springbootmongodb.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;


    @Test
    void list() throws Exception {
        List<Person> personList = new ArrayList<>();
        when(personService.listAll()).thenReturn(personList);
        this.mockMvc.perform(get("/person")).andExpect(status().isOk());
    }

    @Test
    void getPerson() {
    }

    @Test
    void createPerson() throws Exception {
        Person person = new Person();

        person.setId("1");
        person.setName("Tomas");
        person.setLastname("Edison");
        person.setAge(10);

        ObjectMapper objectMapper = new ObjectMapper();

        String inputJson = objectMapper.writeValueAsString(objectMapper.writeValueAsString(person));
//        String inputJson = "{\"id\":\"1\",\"name\":\"Tomas\",\"lastname\":\"Edison\",\"age\":10}";
        when(personService.save()).thenReturn();
        this.mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andExpect(status().isOk());;
    }
}