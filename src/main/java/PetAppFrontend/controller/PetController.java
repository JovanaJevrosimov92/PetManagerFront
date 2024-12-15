package PetAppFrontend.controller;

import PetAppFrontend.model.AddPetDTO;
import PetAppFrontend.service.PetApiService;
import PetAppFrontend.service.PetTypeApiService;
//import PetAppFrontend.service.UserSessionStore;
import PetAppFrontend.service.UserSessionStore;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.internal.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private  PetApiService petApiService;
    @Autowired
    private PetTypeApiService petTypeApiService;



    @GetMapping
    public String getAllPets(Model model) {
        model.addAttribute("pets", petApiService.getAllPets());
        return "pets"; // pets.html
    }

    @GetMapping("/add")
    public String showAddPetForm(Model model) {
        List<String>petTypes = petTypeApiService.getAllPetTypes();
        model.addAttribute("addPetDTO", new AddPetDTO());
        model.addAttribute("petTypes", petTypeApiService.getAllPetTypes());
        return "add-pet";
    }

    @PostMapping("/add")
    public String addPet(@Valid @ModelAttribute AddPetDTO addPetDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addPetDTO", addPetDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addPetDTO", bindingResult);
//            List<String> petTypes = petTypeApiService.getAllPetTypes();
//            model.addAttribute("petTypes",petTypes);
            return "add-pet";
        }

        try {

            String sessionId = UserSessionStore.getSessionId();
            System.out.println("JSESSION pre slanja: "+ sessionId);

            if (sessionId == null) {
                System.out.println("JSESSIONID nije pronađen u kolačićima.");
                redirectAttributes.addFlashAttribute("errorMessage", "Session not found. Please log in.");
                return "redirect:/login";
            }

            System.out.println("JSESSIONID: " + sessionId);

            // Pozovi API servis sa JSESSIONID
            petApiService.addPet(addPetDTO);
            return "redirect:/pets";
        } catch (HttpClientErrorException e) {
            String errorResponse = e.getResponseBodyAsString();
            System.out.println("Http Client greska: " + e.getStatusCode());
            System.out.println("Error response: " + errorResponse);
            redirectAttributes.addFlashAttribute("errorMessage", errorResponse);
            return "redirect:/pets/add";
        }
    }



}
