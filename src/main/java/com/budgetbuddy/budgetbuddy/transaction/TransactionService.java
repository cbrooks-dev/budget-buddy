package com.budgetbuddy.budgetbuddy.transaction;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Integer id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent())
            return transaction.get();
        else throw new TransactionNotFoundException();
    }

    public void updateTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(Integer id) {
        if (transactionRepository.existsById(id))
            transactionRepository.deleteById(id);
        else throw new TransactionNotFoundException();
    }
}
