package com.example.mobilefix.controller;

import com.example.mobilefix.dto.LoginRequest;
import com.example.mobilefix.dto.RegisterRequestDTO;
import com.example.mobilefix.model.User;
import com.example.mobilefix.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthViewController {

    private final UserRepository userRepo;

    public AuthViewController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/welcome")
    public String dashboard() {
        return "welcome";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") LoginRequest loginDto, Model model){
        User user = userRepo.findByUsername(loginDto.getUsername());
        if (user == null || !user.getPassword().equals(loginDto.getPassword())){
            model.addAttribute("error","Credenciales inválidas");
            return "login";
        }
        return "redirect:/welcome";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new RegisterRequestDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") RegisterRequestDTO dto, Model model) {

        if (userRepo.findByUsername(dto.getUsername()) != null) {
            model.addAttribute("error", "El usuario ya existe");
            return "register";
        }

        User newUser = new User();
        newUser.setUsername(dto.getUsername());
        newUser.setPassword(dto.getPassword());
        newUser.setRole("USER");
        newUser.setFullname(dto.getFullname());
        newUser.setEmail(dto.getEmail());
        newUser.setEnabled(true);

        userRepo.save(newUser);

        model.addAttribute("success", "Usuario registrado exitosamente");
        return "register";
    }
}