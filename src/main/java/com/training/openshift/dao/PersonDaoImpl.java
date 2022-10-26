package com.training.openshift.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDaoImpl implements PersoneDAO{

    private List<String> persons;

    public  PersonDaoImpl(){
        persons=new ArrayList<>(PERSON_LIST);
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
