package com.budgetbuddy.budgetbuddy.transaction;

import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public record Transaction(
        @Positive @Id
        Integer id,
        TransactionType transactionType,
        TransactionCategory transactionCategory,
        Double amount,
        LocalDate date
) {}
