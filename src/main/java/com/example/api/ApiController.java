package com.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final String API = "http://localhost:8080/string/";

    @GetMapping("analyze/{text}/{format}")
    public String analyze(@PathVariable("text") String text,
        @PathVariable("format") String format) {

        System.out.println(text);
        System.out.println(format);

        return null;
    }

}
