package com.budgetbuddy.budgetbuddy.transaction;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    TransactionRepository transactionRepository;

    public Transaction getTransactionById(Integer id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent())
            return transaction.get();
        else throw new TransactionNotFoundException();
    }

    public void deleteTransaction(Integer id) {
        if (transactionRepository.existsById(id))
            transactionRepository.deleteById(id);
        else throw new TransactionNotFoundException();
    }
}
