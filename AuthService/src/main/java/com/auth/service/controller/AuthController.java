package com.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.auth.service.config.SecurityConfig;
import com.auth.service.entity.User;
import com.auth.service.repository.UserRepository;
import com.auth.service.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SecurityConfig securityConfig;

    private final UserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;

    AuthController(UserRepository userRepository, SecurityConfig securityConfig) {
        this.userRepository = userRepository;
        this.securityConfig = securityConfig;
    }
	
    
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = userRepository.findByUsername(user.getUsername());

        if(dbUser != null &&
           dbUser.getPassword().equals(user.getPassword())) {

            return jwtService.generateToken(user.getUsername());
        }

        return "Invalid Credentials";
    }
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {

	    return userRepository.save(user);
	}
	
	 @GetMapping("/validate")
	    public String validate(@RequestParam String token) {

	        if(jwtService.validateToken(token)) {
	            return "VALID TOKEN";
	        }

	        return "INVALID TOKEN";
	    }
}
