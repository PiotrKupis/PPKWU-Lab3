package com.example.api;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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
                return getJson(text, restTemplate);
            case "XML":
                JSONObject jsoObject = new JSONObject(getJson(text, restTemplate));
                String xml = XML.toString(jsoObject);
                return "<analyze>" + xml + "</analyze>";
            case "CSV":
                Response response = restTemplate.exchange(API + text, HttpMethod.GET,
                    HttpEntity.EMPTY,
                    Response.class).getBody();
                return "uppercase,lowercase,number,specialChars,combination"
                    + response.getUppercase() + ","
                    + response.getLowercase() + ","
                    + response.getNumbers() + ","
                    + response.getSpecialChars() + ","
                    + response.getCombination();
            default:
                return "Incorrect format";
        }
    }

    private String getJson(String text, RestTemplate restTemplate) {
        return restTemplate.getForObject(API + text, String.class);
    }
}
