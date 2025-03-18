package com.budgetbuddy.budgetbuddy.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDate;

public record Transaction(
        @Positive @Id @NotNull
        Integer id,
        @Positive @NotNull
        Integer userId,
        @NotNull
        TransactionType transactionType,
        @NotNull
        TransactionCategory transactionCategory,
        @NotNull
        Double amount,
        @NotNull
        LocalDate date,
        @Version @NotNull
        Integer version
) {}
