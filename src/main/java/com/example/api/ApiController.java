package com.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {

    private final String API = "http://localhost:8080/string/";

    @GetMapping("analyze/{text}/{format}")
    public String analyze(@PathVariable("text") String text,
        @PathVariable("format") String format) {

        switch (format) {
            case "JSON":
                RestTemplate restTemplate = new RestTemplate();
                return restTemplate.getForObject(API + text, String.class);
            default:
                return "Incorrect format";
        }
    }

}
