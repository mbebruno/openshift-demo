package com.training.openshift.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDaoImpl2 implements PersoneDAO{

    private List<String> persons;

    public PersonDaoImpl2(){
        persons=new ArrayList<>(PERSON_LIST);
        persons.add("HUGUES");
        //persons=PERSON_LIST.;
    }


    @Override
    public List<String> getAllPersons() {
        return this.persons;
    }

    @Override
    public String addPerson(String person) {
        persons.add(person);
        return person;
    }
}
