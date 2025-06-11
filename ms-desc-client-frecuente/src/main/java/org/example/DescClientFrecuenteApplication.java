package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@EnableEurekaClient
public class DescClientFrecuenteApplication {
    public static void main(String[] args) {
        SpringApplication.run(DescClientFrecuenteApplication.class, args);
    }
}
