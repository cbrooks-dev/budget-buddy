package com.budgetbuddy.budgetbuddy.transaction;

import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record Transaction(
        @Positive
        Integer id,
        TransactionType transactionType,
        TransactionCategory transactionCategory,
        Double amount,
        LocalDate date
) {}
