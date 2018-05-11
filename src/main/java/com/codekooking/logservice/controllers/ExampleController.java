package com.codekooking.logservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codekooking.logservice.beans.Example;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping("/name/{name}/email/{email}")
    public Example showExample(@PathVariable String name, @PathVariable String email) {

    	Example example = new Example(name, email);

        return example;

    }
}
