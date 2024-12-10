package PetAppFrontend.service;

import PetAppFrontend.model.AddPetDTO;
import PetAppFrontend.model.PetDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PetApiService {

    @Autowired
    private RestTemplate restTemplate;


    private final String API_BASE_URL = "http://localhost:8081/api/pets";

    public List<PetDTO> getAllPets() {
        ResponseEntity<PetDTO[]> response = restTemplate.getForEntity(API_BASE_URL, PetDTO[].class);
        return Arrays.asList(response.getBody());
    }

    public PetDTO addPet(AddPetDTO addPetDTO) {
        return restTemplate.postForObject(API_BASE_URL, addPetDTO, PetDTO.class);
    }

    public void deletePet(Long id) {
        restTemplate.delete(API_BASE_URL + "/" + id);
    }
}
