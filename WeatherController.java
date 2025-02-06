package com.csc340.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city) {
        // Call the WeatherService to get the actual weather for the city
        WeatherResponse weatherResponse = weatherService.getWeather(city);

        // Check if the response is null (in case of error)
        if (weatherResponse == null) {
            // Return a custom error message or status
            return new WeatherResponse();  // Return an empty response or error object
        }

        return weatherResponse;  // Return the weather response from the API
    }
}
