package PetAppFrontend.service;

import PetAppFrontend.model.LoginUserDTO;
import PetAppFrontend.model.RegisterUserDTO;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserApiService {

    @Autowired
    private RestTemplate restTemplate;

    private final String API_BASE_URL = "http://localhost:8081/api/users";
    public boolean registerUser(RegisterUserDTO registerUserDTO, Model model) {

        try {
            String url = API_BASE_URL+"/register";
            restTemplate.postForEntity(url,registerUserDTO,Void.class);
            return true;
        } catch (HttpClientErrorException.BadRequest e) {
            model.addAttribute("error",e.getResponseBodyAsString());
            return false;
        }



    }

    public String loginUser(LoginUserDTO loginUserDTO) {
        try {
            restTemplate.postForEntity(API_BASE_URL + "/login", loginUserDTO, Void.class);
            return "Login successful";
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return "Invalid username or password";
            }
            // Vraćamo poruku greške iz back-enda
            return "An unexpected error occurred. Please try again.";
        }

    }

}
