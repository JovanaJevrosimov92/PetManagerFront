package PetAppFrontend.controller;

import PetAppFrontend.model.LoginUserDTO;
import PetAppFrontend.model.RegisterUserDTO;
import PetAppFrontend.service.UserApiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserApiService userApiService;


    @GetMapping("/login")
    public String getLoginPage(Model model) {
        if (!model.containsAttribute("loginUserDTO")) {
            model.addAttribute("loginUserDTO", new LoginUserDTO());

        }
        System.out.println("LoginUserDTO added to model.");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("loginUserDTO") LoginUserDTO loginUserDTO,BindingResult bindingResult, Model model,  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginUserDTO", loginUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginUserDTO", bindingResult);

            return "redirect:/login";
        }


        String loginResponse = userApiService.loginUser(loginUserDTO);

        if (loginResponse.equals("Login successful")) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", loginResponse);
            return "login";
        }
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUserDTO", new RegisterUserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("registerUserDTO") RegisterUserDTO registerUserDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {


            if (bindingResult.hasErrors()) {
                model.addAttribute("registerUserDTO", registerUserDTO);
                model.addAttribute("org.springframework.validation.BindingResult.registerUserDTO", bindingResult);
                return "register";
            }
            boolean registrationSuccessful = userApiService.registerUser(registerUserDTO,model);

            if (registrationSuccessful) {
                return "redirect:/login";
            } else {
                redirectAttributes.addFlashAttribute("error", model.getAttribute("error"));
                return "redirect:/register";
            }

        }
    }

