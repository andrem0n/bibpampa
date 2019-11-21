package edu.unipampa.bibpampaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BibpampaApiApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(BibpampaApiApplication.class, args);
    }

    

}
