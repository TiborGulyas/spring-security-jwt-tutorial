package com.example.demo.controller;

import com.example.demo.model.VehicleAppUser;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
public class UserinfoController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/me")
    public String currentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Optional<VehicleAppUser> user = userRepository.findByUsername(authentication.getPrincipal().toString());
        //VehicleAppUser user = (VehicleAppUser) authentication.getPrincipal();

        return user.get().getUsername() + "\n" + user.get().getRoles();
    }
}
