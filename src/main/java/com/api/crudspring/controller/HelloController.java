package com.api.crudspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public int hello() {
        int a, b, c;
        a = 2;
        b = 6;
        c = 1;
        if (a < b) {
            return (a + b - c);
        } else {
            return (a - b - c);
        }
    }
}
