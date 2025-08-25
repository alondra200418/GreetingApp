package com.reyes.greetingapp; // Ensure this package matches your project's

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.*; // REMOVE this import as @RestController/@RequestMapping are removed

@SpringBootApplication // Change from @RestController and remove @EnableAutoConfiguration if present separately
public class Example {

    // REMOVE THE FOLLOWING METHOD ENTIRELY:
    /*
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
    */

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
}
