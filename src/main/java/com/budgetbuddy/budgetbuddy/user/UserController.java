package com.budgetbuddy.budgetbuddy.user;

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
