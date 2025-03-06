package com.integrador.summary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.integrador.summary.model.Person;
import com.integrador.summary.service.SwapiService;

@SpringBootApplication
public class SummaryApplication implements CommandLineRunner {

    @Autowired
    private SwapiService swapiService;

    public static void main(String[] args) {
        SpringApplication.run(SummaryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (Person sr : swapiService.getAllData().getResults()) {
            System.out.println(sr);
            swapiService.saveAllData(sr);
        }
    }

}
