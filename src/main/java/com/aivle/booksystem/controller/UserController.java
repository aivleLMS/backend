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
    public User userName(@RequestBody User users) {return userService.newUser(users);}

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {return userService.findUserById(id);}

    @GetMapping
    public User getToken(@PathVariable Long token) {return userService.checkToken(token);}

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User users){
        return userService.updateUser(id, users);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {userService.deleteUser(id);}
}
