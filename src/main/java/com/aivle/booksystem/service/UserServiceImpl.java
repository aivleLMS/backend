package com.aivle.booksystem.service;

import com.aivle.booksystem.domain.User;
import com.aivle.booksystem.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User userName(User user) {return userRepository.save(user);}

    @Override
    public User findUserById (Long id) {
        return userRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("User not found")
        );
    }

    @Override
    public User checkToken(Long token) {
        return null;
    }

    // 유저 삭제는?

}
