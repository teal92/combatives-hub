package com.combativeshub.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Autowired
    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    // 🔐 Signup endpoint
    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody AuthRequest request) {
        // Check if username already exists
        if (userRepository.findByUsername(request.getUsername()) != null) {
            return new AuthResponse("Username already taken");
        }



        // Create a new user with default placeholder data
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setName("Default Name");  // You can collect real info later
        newUser.setEmail("default@email.com");
        newUser.setRank("N/A");
        newUser.setUnit("N/A");
        newUser.setRole("User");
        newUser.setCertLevel("None");

        userRepository.save(newUser);

        return new AuthResponse("Signup successful");
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            return new AuthResponse("User not found");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthResponse("Invalid password");
        }

        // 🔐 Generate JWT token
        String token = jwtService.generateToken(user.getUsername());

        return new AuthResponse(token);  // return the token as the message
    }


}
