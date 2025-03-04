package com.integrador.summary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.summary.model.Person;

@Repository
public interface SwapiRepository extends JpaRepository<Person, Long> {

}
