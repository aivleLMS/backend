package com.aivle.booksystem.bookController;


import com.aivle.booksystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.aivle.booksystem.domain.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users") // 확인필요
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public User userName(@RequestBody User user) {return userService.createUser(user);}

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {return userService.findUserById(id);}

    // 또 뭘 맵핑해야할까?

}
