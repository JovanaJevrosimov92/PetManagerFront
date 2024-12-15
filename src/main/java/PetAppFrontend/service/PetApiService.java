package PetAppFrontend.service;

import PetAppFrontend.model.AddPetDTO;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PetApiService {
    @Autowired
    private UserApiService userApiService;

    @Autowired
    private RestTemplate restTemplate;


    private final String API_BASE_URL = "http://localhost:8081/api/pets";

    public List<AddPetDTO> getAllPets() {

        ResponseEntity<AddPetDTO[]> response = restTemplate.getForEntity(API_BASE_URL, AddPetDTO[].class);
        return Arrays.asList(response.getBody());
    }

    public AddPetDTO addPet(AddPetDTO addPetDTO) {
        return restTemplate.postForObject(API_BASE_URL, addPetDTO, AddPetDTO.class);
    }
    public void deletePet(Long id) {
        restTemplate.delete(API_BASE_URL + "/" + id);
    }


}
