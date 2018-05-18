package com.codekooking.logservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codekooking.logservice.beans.Example;

@RestController
@RequestMapping("/secured")
public class SecuredController {

    @PostMapping("/name/{name}/email/{email}")
    public Example storeExample(@PathVariable String name, @PathVariable String email) {

    	Example example = new Example(name, email);

        return example;

    }
}
