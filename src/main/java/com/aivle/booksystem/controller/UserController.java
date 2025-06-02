package com.aivle.booksystem.controller;


import com.aivle.booksystem.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.aivle.booksystem.domain.User;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public User newUser(@RequestBody User user) {return userService.newUser(user);}

    @GetMapping("/{id}/token")
    public String getToken(@PathVariable Long id) {return userService.getToken(id);}

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {return userService.findUserById(id);}

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {userService.deleteUser(id);}
}
