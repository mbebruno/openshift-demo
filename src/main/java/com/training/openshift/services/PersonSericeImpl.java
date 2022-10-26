package com.training.openshift.services;

import com.training.openshift.dao.PersoneDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("person1")
public class PersonSericeImpl implements PersonService{

    private PersoneDAO personeDAO;

    public PersonSericeImpl(@Qualifier("personDaoImpl") PersoneDAO personeDAO){

        this.personeDAO=personeDAO;

    }
    @Override
    public List<String> getAllPersons() {
        return this.personeDAO.getAllPersons();
    }

    @Override
    public String addPerson(String person) {
        return this.personeDAO.addPerson(person);
    }
}
