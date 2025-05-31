package com.aivle.booksystem.service.user;

import com.aivle.booksystem.domain.User;
import com.aivle.booksystem.exception.TokenNotFoundException;
import com.aivle.booksystem.exception.UserNotFoundException;
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
        User user = userRepository.findById(1L).orElseThrow(() -> new UserNotFoundException("유저가 등록되어 있지 않습니다."));
        String token = user.getToken();

        if (token == null || token.isBlank()) {
            throw new TokenNotFoundException("API key가 등록되어 있지 않습니다.");
        }
        return token;
    }
}
