package com.aivle.booksystem.controller;


import com.aivle.booksystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.aivle.booksystem.domain.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public User userName(@RequestBody User user) {return userService.newUser(user);}

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {return userService.findUserById(id);}

    @GetMapping
    public User getToken(@PathVariable Long token) {return userService.checkToken(token);}

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {userService.deleteUser(id);}
}
