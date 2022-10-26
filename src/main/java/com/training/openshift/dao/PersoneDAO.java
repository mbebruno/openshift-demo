package com.training.openshift.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


public interface PersoneDAO {

    List<String> PERSON_LIST= Arrays.asList("KENGNE","MBE","DANG");

    List<String> getAllPersons();
    String addPerson(String person);
}
