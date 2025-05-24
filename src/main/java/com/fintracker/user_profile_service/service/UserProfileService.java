package com.fintracker.user_profile_service.service;

import com.fintracker.user_profile_service.dto.UserProfileDTO;
import com.fintracker.user_profile_service.exception.EmailAlreadyExistsException;
import com.fintracker.user_profile_service.model.UserProfile;
import com.fintracker.user_profile_service.repository.UserProfileRepository;
import com.fintracker.user_profile_service.util.UserProfileMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileDTO getProfile(UUID userId) {
        UserProfile userProfile = userProfileRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User profile with not found"));
        return UserProfileMapper.mapToUserProfileDTO(userProfile);
    }

    @Transactional
    public UserProfileDTO createProfile(UserProfileDTO profile) {
        if (userProfileRepository.findByEmail(profile.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email " + profile.getEmail() + " is already registered");
        }
        UserProfile userProfile = UserProfileMapper.mapToUserProfile(profile);
        UserProfile savedProfile = userProfileRepository.save(userProfile);
        return UserProfileMapper.mapToUserProfileDTO(savedProfile);
    }
}