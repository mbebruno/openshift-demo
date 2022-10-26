package com.training.openshift.services;

import java.util.List;

public interface PersonService {

    List<String> getAllPersons();
    String addPerson(String person);
}
