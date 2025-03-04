package com.integrador.summary.model;

import java.util.List;

import lombok.Data;

@Data
public class SwapiResponse {

    private int count;
    private String next;
    private String previous;
    private List<Person> results;

  
}
