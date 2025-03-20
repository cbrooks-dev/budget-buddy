package com.budgetbuddy.budgetbuddy.user;

import com.budgetbuddy.budgetbuddy.transaction.Transaction;
import com.budgetbuddy.budgetbuddy.transaction.TransactionRepository;
import com.budgetbuddy.budgetbuddy.transaction.TransactionType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    TransactionRepository transactionRepository;

    public UserService(UserRepository userRepository,
                       TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else throw new UserNotFoundException();
    }

    public List<Transaction> getUserTransactions(Integer id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException();
        } else return transactionRepository.findAllByUserId(id);
    }

    public List<Transaction> getUserExpenses(Integer id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException();
        } return transactionRepository
                .findAllByUserIdAndTransactionType(id, TransactionType.EXPENSE);
    }

    public List<Transaction> getUserIncomes(Integer id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException();
        } return transactionRepository
                .findAllByUserIdAndTransactionType(id, TransactionType.INCOME);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else throw new UserNotFoundException();
    }
}
