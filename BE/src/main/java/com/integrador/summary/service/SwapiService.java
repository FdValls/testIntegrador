package com.integrador.summary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.integrador.summary.model.Person;
import com.integrador.summary.model.SwapiResponse;
import com.integrador.summary.repository.SwapiRepository;
import com.integrador.summary.swapiDTO.SwapiDTO;

@Service
public class SwapiService {

    public static String URL = "https://swapi.dev/api";
    @Autowired
    private SwapiRepository swapiRepository;

    public SwapiResponse getAllData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL + "/people/", SwapiResponse.class);
    }

    public List<Person> getAllDataFromDB() {
        return swapiRepository.findAll();
    }

    public void saveAllData(Person person) {
        swapiRepository.save(person);
    }

    public SwapiDTO createNewPerson(Person person) {
        Person savedPerson = swapiRepository.save(person);
        return SwapiDTO.builder()
                .id(savedPerson.getId())
                .gender(savedPerson.getGender())
                .birth_year(savedPerson.getBirth_year())
                .name(savedPerson.getName())
                .build();
    }

    public void deletePerson(Long idPerson) {
        this.swapiRepository.delete(this.swapiRepository.findById(idPerson).get());
    }

}
