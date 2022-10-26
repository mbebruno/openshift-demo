package com.training.openshift.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonDaoImplTest {

    @Autowired
    @Qualifier("personDaoImpl")
    PersoneDAO personeDAO;



    @BeforeEach
    public void init(){

    }

    @Test
    void getAllPersonsTest() {
        List<String> expected= Arrays.asList("KENGNE","MBE","DANG");
        List<String> l=this.personeDAO.getAllPersons();
        Assertions.assertThat(l).isNotEmpty().hasSize(3);
        Assertions.assertThat(l.containsAll(expected));

    }

    @Test
    void addPerson() {
        String value="NGONO";
        String r=this.personeDAO.addPerson(value);
        Assertions.assertThat(r).isEqualTo(value);
    }
}