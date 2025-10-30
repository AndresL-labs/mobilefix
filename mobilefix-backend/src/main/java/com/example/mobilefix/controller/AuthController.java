package com.example.mobilefix.controller;

import com.example.mobilefix.dto.LoginRequest;
import com.example.mobilefix.dto.RegisterRequestDTO;
import com.example.mobilefix.model.User;
import com.example.mobilefix.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final UserRepository userRepo;

    public AuthController(UserRepository userRepo) { this.userRepo = userRepo; }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        User user = userRepo.findByUsername(request.getUsername());
        if (user == null || !user.getPassword().equals(request.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ivalid Credentials");
        }
        return ResponseEntity.ok("Login Succesful");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO newUserDto){

        if (userRepo.findByUsername(newUserDto.getUsername()) != null){
            return ResponseEntity.badRequest().body("User already exists");
        }

        User newUser = new User();
        newUser.setUsername(newUserDto.getUsername());
        newUser.setPassword(newUserDto.getPassword());
        newUser.setRole(newUserDto.getRole());
        newUser.setFullname(newUserDto.getFullname());
        newUser.setEmail(newUserDto.getEmail());
        newUser.setEnabled(newUserDto.isEnabled());

        userRepo.save(newUser);

        return ResponseEntity.ok("User registered succesfully");
    }
}
