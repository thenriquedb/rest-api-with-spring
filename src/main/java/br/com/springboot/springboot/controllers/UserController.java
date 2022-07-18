package br.com.springboot.springboot.controllers;

import br.com.springboot.springboot.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This code uses Spring @RestController annotation, which marks the class as a controller where
 * every method returns a domain object instead of a view. It is shorthand for including
 * both @Controller and @ResponseBody.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();

        if(userFind.isPresent()) {
            return userFind.get();
        }

        return null;
    }

    @PostMapping("/")
    public User create(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> list() {
        return users;
    }
}
