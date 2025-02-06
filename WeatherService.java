package com.csc340.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "5808144557c9cb0d4dbf8b0692519ece"; // Your actual API key

    public WeatherResponse getWeather(String city) {
        // Build the URL dynamically using UriComponentsBuilder to handle URL encoding
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("q", city)
                .queryParam("appid", API_KEY)
                .queryParam("units", "metric")  // Ensure temperature is in Celsius
                .toUriString();

        // Create a RestTemplate object to make the API call
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Make the GET request and map the response to WeatherResponse class
            WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
            return weatherResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;  // In case of error, return null (you can improve this with custom error handling)
        }
    }
}
