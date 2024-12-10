package PetAppFrontend.controller;

import PetAppFrontend.model.AddPetDTO;
import PetAppFrontend.service.PetApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private  PetApiService petApiService;


    @GetMapping
    public String getAllPets(Model model) {
        model.addAttribute("pets", petApiService.getAllPets());
        return "pets"; // pets.html
    }

    @GetMapping("/add")
    public String showAddPetForm(Model model) {
        model.addAttribute("addPetDTO", new AddPetDTO());
        model.addAttribute("types", Arrays.asList("Dog", "Cat", "Parrot", "Fish", "Rabbit", "Turtle"));
        return "add-pet";
    }
}
