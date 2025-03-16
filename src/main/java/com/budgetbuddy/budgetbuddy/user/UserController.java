package com.budgetbuddy.budgetbuddy.user;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* Create */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    /* Read All */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /* Read Specific */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return null; // TODO: stub
    }

    /* Update */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("")
    public void updateUser(@Valid @RequestBody User user) {
        userRepository.save(user);
    }

    /* Delete */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        // TODO: stub
    }
}
