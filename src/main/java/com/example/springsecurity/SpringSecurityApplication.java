package com.example.springsecurity;

import com.example.springsecurity.dto.RegisterRequest;
import com.example.springsecurity.enums.ERole;
import com.example.springsecurity.models.Role;
import com.example.springsecurity.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {

            var admin = RegisterRequest.builder()
                    .username("admin")
                    .email("admin@mail.com")
                    .password("admin")
                    .build();



            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .username("moderator")
                    .email("moderator@mail.com")
                    .password("moderator")
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

        };
    }
}
