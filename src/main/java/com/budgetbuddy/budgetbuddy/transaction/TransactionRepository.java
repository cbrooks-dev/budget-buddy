package com.budgetbuddy.budgetbuddy.transaction;

import org.springframework.data.repository.ListCrudRepository;

public interface TransactionRepository
        extends ListCrudRepository<Transaction, Integer> {
}
