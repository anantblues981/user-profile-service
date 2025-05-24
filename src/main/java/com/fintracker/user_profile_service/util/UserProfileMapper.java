package com.fintracker.user_profile_service.util;

import com.fintracker.user_profile_service.dto.UserProfileDTO;
import com.fintracker.user_profile_service.model.UserProfile;

public class UserProfileMapper {
    public static UserProfile mapToUserProfile(UserProfileDTO profile) {
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(profile.getFirstName());
        userProfile.setLastName(profile.getLastName());
        userProfile.setEmail(profile.getEmail());
        userProfile.setPhone(profile.getPhone());
        userProfile.setCurrency(profile.getCurrency());
        return userProfile;
    }

    public static UserProfileDTO mapToUserProfileDTO(UserProfile userProfile) {
        UserProfileDTO profileDTO = new UserProfileDTO();
        profileDTO.setUserId(userProfile.getUserId());
        profileDTO.setFirstName(userProfile.getFirstName());
        profileDTO.setLastName(userProfile.getLastName());
        profileDTO.setEmail(userProfile.getEmail());
        profileDTO.setPhone(userProfile.getPhone());
        profileDTO.setCurrency(userProfile.getCurrency());
        return profileDTO;
    }
}
