package com.example.api;

import org.json.JSONObject;
import org.json.XML;
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

        RestTemplate restTemplate = new RestTemplate();

        switch (format) {
            case "JSON":
                return restTemplate.getForObject(API + text, String.class);
            case "XML":
                JSONObject jsoObject = new JSONObject(
                    restTemplate.getForObject(API + text, String.class));
                String xml = XML.toString(jsoObject);
                return "<analyze>" + xml + "</analyze>";
            default:
                return "Incorrect format";
        }
    }

}
