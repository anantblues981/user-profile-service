package com.fintracker.user_profile_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.UUID;

@Data
public class UserProfileDTO {

    private UUID userId;

    @NotBlank(message = "{user.firstName.required}")
    @Pattern(regexp = "^[A-Za-z\\s-]{1,50}$", message = "{user.firstName.invalid}")
    private String firstName;

    @NotBlank(message = "{user.lastName.required}")
    @Pattern(regexp = "^[A-Za-z\\s-]{1,50}$", message = "{user.lastName.invalid}")
    private String lastName;

    @NotBlank(message = "{user.email.required}")
    @Email(message = "{user.email.invalid}")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "{user.email.invalid}")
    private String email;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "{user.phone.invalid}")
    private String phone;

    @Pattern(regexp = "^[A-Z]{3}$", message = "{user.currency.invalid}")
    private String currency;
}
