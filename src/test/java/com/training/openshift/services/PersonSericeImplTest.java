package com.training.openshift.services;

import com.training.openshift.dao.PersoneDAO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonSericeImplTest {

    @Mock
    PersoneDAO personeDAO;

    PersonService personService;

    @BeforeEach
    void  before(){
        this.personService=new PersonSericeImpl(this.personeDAO);
    }


    @Test
    void getAllPersonsTest() {
        List<String> expected= Arrays.asList("KENGNE","MBE","DANG");
        when(this.personeDAO.getAllPersons()).thenReturn((expected));

        List<String>l=this.personService.getAllPersons();

        verify(this.personeDAO,times(1)).getAllPersons();
        Assertions.assertThat(l).hasSize(3).containsAll(expected);
    }

    @Test
    void addPersonTest() {

        String name="test";
        when(this.personeDAO.addPerson(name)).thenReturn(name);

        String r=this.personService.addPerson(name);

        verify(this.personeDAO,times(1)).addPerson(name);
        Assertions.assertThat(r).isEqualTo(name);
    }
}