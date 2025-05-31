package com.aivle.booksystem.service.user;

import com.aivle.booksystem.domain.User;
import com.aivle.booksystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String getToken() {
        User user = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));
        String token = user.getToken();

        if (token == null) {
            throw new RuntimeException("Token not found");
        }
        return token;
    }
}
