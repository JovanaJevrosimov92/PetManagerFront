package PetAppFrontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PetTypeApiService {

    @Autowired
    private RestTemplate restTemplate;

    private final String API_BASE_URL = "http://localhost:8081/api/pet-types";

    public List<String> getAllPetTypes() {
        ResponseEntity<String[]> response = restTemplate.getForEntity(API_BASE_URL, String[].class);
        return Arrays.asList(response.getBody());
    }
}
