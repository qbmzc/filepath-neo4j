package com.cong.filepathneo4j.controller;

import com.cong.filepathneo4j.po.Person;
import com.cong.filepathneo4j.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/person/save")
    public String save() {
        Person person = new Person();
        person.setName("zhangsan");
        personRepository.save(person);
        return "Person saved";
    }

    @RequestMapping("/person/find")
    public List<Person> find() {
        Person persons = personRepository.findByName("Alice");
        List<Person> list = new ArrayList<>();
        list.add(persons);
        return list;
    }
}