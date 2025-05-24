package com.fintracker.user_profile_service.controller;

import com.fintracker.user_profile_service.dto.UserProfileDTO;
import com.fintracker.user_profile_service.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/profiles")
public class UserProfileController {

    private UserProfileService service;

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfileDTO> getProfile(@PathVariable UUID userId) {
        UserProfileDTO profile = service.getProfile(userId);
        return ResponseEntity.ok(profile);
    }

    @PostMapping
    public ResponseEntity<UserProfileDTO> createProfile(@RequestBody @Valid UserProfileDTO profile) {
        UserProfileDTO created = service.createProfile(profile);
        return ResponseEntity.ok(created);
    }

}
