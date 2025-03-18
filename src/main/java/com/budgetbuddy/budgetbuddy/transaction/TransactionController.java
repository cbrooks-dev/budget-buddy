package com.budgetbuddy.budgetbuddy.transaction;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/transactions")
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /* Create */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Transaction createTransaction
            (@Valid @RequestBody Transaction transaction)
    {
        return transactionService.createTransaction(transaction);
    }

    /* Read All */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    /* Read Specific */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Integer id) {
        return transactionService.getTransactionById(id);
    }

    /* Update */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("")
    public void updateTransaction(@Valid @RequestBody Transaction transaction) {
        transactionService.updateTransaction(transaction);
    }

    /* Delete */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Integer id) {
        transactionService.deleteTransaction(id);
    }
}
