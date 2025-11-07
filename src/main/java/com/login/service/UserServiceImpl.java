package com.login.service;

import com.login.model.AuditLog;
import com.login.model.Role;
import com.login.model.User;
import com.login.repositories.AuditLogRepository;
import com.login.repositories.RoleRepository;
import com.login.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuditLogRepository auditLogRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, 
                           PasswordEncoder passwordEncoder, AuditLogRepository auditLogRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.auditLogRepository = auditLogRepository;
    }

    private static final int MAX_FAILED_ATTEMPTS = 3;
    @Override
    public void increaseFailedAttempts(String username) {
        userRepository.findByUsername(username).ifPresent(user -> {
            int newFail = user.getFailedAttempt() + 1;
            user.setFailedAttempt(newFail);
            String action = "LOGIN_FAILED";

            if (newFail >= MAX_FAILED_ATTEMPTS) {
                user.setAccountLocked(true);
                action = "ACCOUNT_LOCKED";
            }

            userRepository.save(user);
            auditLogRepository.save(new AuditLog(username, action));
        });
    }

    @Override
    public void resetFailedAttempts(String username) {
        userRepository.findByUsername(username).ifPresent(user -> {
            user.setFailedAttempt(0);
            userRepository.save(user);
            auditLogRepository.save(new AuditLog(username, "LOGIN_SUCCESS"));
        });
    }
    @Override
    public void register(User user, String roleName) {
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
    }


    @Override
    public void updateLastLogin(String username) {
        userRepository.findByUsername(username).ifPresent(user -> {
            user.setLastLogin(LocalDateTime.now());
            userRepository.save(user);
        });
        
    }
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
