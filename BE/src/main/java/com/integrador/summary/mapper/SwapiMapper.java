package com.integrador.summary.mapper;

import org.springframework.stereotype.Component;

import com.integrador.summary.model.Person;
import com.integrador.summary.swapiDTO.SwapiDTO;

@Component
public class SwapiMapper {

    public static SwapiDTO mapToSwapiDTO(Person person) {
        if (person == null) {
            return null;
        }

        return SwapiDTO.builder()
            .id(person.getId())
            .name(person.getName())
            .gender(person.getGender())
            .birth_year(person.getBirth_year())
            .build();}

    public static Person mapToPerson(SwapiDTO swapiDTO) {
        Person person = new Person();
        person.setName(swapiDTO.getName());
        person.setGender(swapiDTO.getGender());
        person.setBirth_year(swapiDTO.getBirth_year());
        return person;
    }

}
