package com.login.service;

import java.util.Optional;

import com.login.model.User;

public interface UserService {
    void register(User user, String role);
    void increaseFailedAttempts(String username);
    void resetFailedAttempts(String username);
    void updateLastLogin(String username);
    Optional<User> findByUsername(String username);
}
