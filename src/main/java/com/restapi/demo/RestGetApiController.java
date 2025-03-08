package com.restapi.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
public class RestGetApiController {
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + " Welcome to your first rest api!";
    }

    @GetMapping("/greet")
    public String meet(@RequestParam(defaultValue = "Guest") String name) {
        return "Hello, " + name + " I'm happy to meet you!";
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable long id,
                                                @RequestParam(value = "includeEmail",
                                                        defaultValue = "true") boolean includeEmail) {
        Person person = new Person("Jon Doe", 25, includeEmail ? "john@apple.com" : null,
                true, Arrays.asList("Maths", "Computer Science", "Physics"));

        return new ResponseEntity<>(person,HttpStatus.OK);
    }
}
