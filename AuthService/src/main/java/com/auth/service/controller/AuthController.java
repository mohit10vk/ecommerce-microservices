package com.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.service.dto.LoginRequest;
import com.auth.service.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if ("mohit".equals(request.getUsername())
                && "1234".equals(request.getPassword())) {

            return jwtService.generateToken(request.getUsername());
        }

        return "Invalid Credentials";
    }
	
}
