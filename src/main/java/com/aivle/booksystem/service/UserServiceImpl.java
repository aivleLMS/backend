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
    public User newUser(User users) {return userRepository.save(users);}

    @Override
    public User findUserById (Long id) {
        return userRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("User not found")
        );
    }

    @Override
    public User checkToken(Long token) {
        return userRepository.findById(token).orElseThrow(
                () -> new EntityNotFoundException("Invalid token"));
    }

    @Override
    public User updateUser(Long id, User users) {
        User oldUser = findUserById(users.getId());

        oldUser.setToken(users.getToken());
        return userRepository.save(oldUser);
    }

    @Override
    public void deleteUser(Long id) {userRepository.deleteById(id);}
}
