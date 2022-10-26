package com.training.openshift.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.openshift.services.PersonService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean //For integration test
    PersonService personService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllpersonsTest() throws Exception {
        List<String> expected= Arrays.asList("KENGNE","MBE","DANG");
        when(this.personService.getAllPersons()).thenReturn(expected);

        MvcResult mvcResult=mockMvc.perform(
                        MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        List<String> l = objectMapper.readValue( mvcResult.getResponse().getContentAsString(), ArrayList.class);
        verify(this.personService).getAllPersons();
        Assertions.assertThat(l).hasSize(3);
    }

    @Test
    void addperson() throws Exception {

        String name="tene";
        when(this.personService.addPerson(name)).thenReturn(name);
        MvcResult result=mockMvc.perform(post("/{name}",name))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        verify(this.personService).addPerson(name);
        Assertions.assertThat(result.getResponse().getContentAsString()).isEqualTo(name);
    }

    @Test
    void addperson2() throws Exception {
        String name="tene";
        when(this.personService.addPerson(name)).thenReturn(name);

       MvcResult result= mockMvc.perform(post("/")
                .param("name", "tene"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
       verify(this.personService).addPerson(name);
       Assertions.assertThat(result.getResponse().getContentAsString()).isEqualTo(name);
    }
}