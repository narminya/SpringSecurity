package com.example.springsecurity.dto;

import com.example.springsecurity.models.Role;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Set<Role> role = new HashSet<>();
}
