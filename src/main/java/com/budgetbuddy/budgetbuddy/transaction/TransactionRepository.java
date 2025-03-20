package com.budgetbuddy.budgetbuddy.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TransactionRepository
        extends ListCrudRepository<Transaction, Integer> {

    List<Transaction> findAllByUserId(@Positive @NotNull Integer userId);
}

