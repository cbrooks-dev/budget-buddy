package com.budgetbuddy.budgetbuddy.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/transaction")
@RestController
public class TransactionController {

    // create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return null; //TODO: stub
    }

    // read all
    @GetMapping("")
    public List<Transaction> getTransactions() {return null; //TODO: stub
    }

    // read specific
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Integer id) {
        return null; //TODO: stub
    }

    // update
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void updateTransaction(@PathVariable Integer id,
                                  @RequestBody Transaction transaction) {
        //TODO: stub
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Integer id) {
        //TODO: stub
    }
}
