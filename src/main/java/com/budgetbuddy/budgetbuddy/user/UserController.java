package com.budgetbuddy.budgetbuddy.user;

import com.budgetbuddy.budgetbuddy.transaction.Transaction;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* Create */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    /* Read All */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    /* Read Specific */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    /* Read All User Transactions */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/transactions/{id}")
    public List<Transaction> getUserTransactions(@PathVariable Integer id) {
        return userService.getUserTransactions(id);
    }

    /* Read All User Expenses */

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/transactions/expenses/{id}")
    public List<Transaction> getUserExpenses(@PathVariable Integer id) {
        return null; // TODO: stub
    }

    /* Read All User Incomes */

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/transactions/incomes/{id}")
    public List<Transaction> getUserIncomes(@PathVariable Integer id) {
        return null; // TODO: stub
    }


    /* Update */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("")
    public void updateUser(@Valid @RequestBody User user) {
        userService.updateUser(user);
    }

    /* Delete */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
