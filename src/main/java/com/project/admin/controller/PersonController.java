package com.project.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.admin.Dao.PersonDAO;
import com.project.admin.model.Person;
@Controller
@RequestMapping(value = "/person")
public class PersonController {
   
	
	@Autowired
    private PersonDAO personDao;
	
    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Person person = new Person();
            person.setId(id);
            personDao.delete(person);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully deleted!";
    }
    @PostMapping("/save")
    @ResponseBody
    public String create(@RequestBody Person persons) {
        try {
            Person person = new Person();
            person.setName(persons.getName());
            person.setCity(persons.getCity());
            personDao.savePerson(person);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }
    @GetMapping("/allPersons")
    @ResponseBody
    public List getAllPersons() {
      
    	try {
            return personDao.getAllPersons();
        } catch (Exception ex) {
            return null;
        }
    }
}