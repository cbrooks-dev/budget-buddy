package com.budgetbuddy.budgetbuddy.user;

import com.budgetbuddy.budgetbuddy.transaction.Transaction;
import com.budgetbuddy.budgetbuddy.transaction.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        User user = userRepository
                .findById(id)
                .orElseThrow(UserNotFoundException::new);
        return transactionRepository.findAllByUserId(id);
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
