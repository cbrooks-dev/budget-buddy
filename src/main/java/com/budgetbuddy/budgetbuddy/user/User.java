package com.budgetbuddy.budgetbuddy.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record User (
        @Positive @Id @NotNull
        Integer id,
        @NotNull
        String email,
        @NotNull
        String password,
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @Version @NotNull
        Integer version
) {}
