package com.login.controller;

import com.login.model.User;
import com.login.repositories.AuditLogRepository;
import com.login.service.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserServiceImpl userService;
   private final AuditLogRepository auditLogRepository;
    public AuthController(UserServiceImpl userService,AuditLogRepository auditLogRepository) {
        this.userService = userService;
        this.auditLogRepository=auditLogRepository;
    }
    @GetMapping("/audit-logs")
    public String viewAuditLogs(Authentication authentication, Model model) {
        if(authentication == null || !authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/auth/login";
        }
        model.addAttribute("logs", auditLogRepository.findAllByOrderByTimestampDesc());
        return "audit-logs"; 
    }

   
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; 
    }


    @PostMapping(value = "/register")
    public String registerForm(User user, @RequestParam String role, Model model) {
        
        try {
            userService.register(user, role);
            model.addAttribute("message", role.equalsIgnoreCase("ROLE_ADMIN") ?
                    "Admin registered successfully!" : "User registered successfully!");
           
            return "redirect:/auth/login?registered";
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "register";
        }
    }

  
    @PostMapping(value = "/register-json", consumes = "application/json")
    @ResponseBody
    public String registerJson(@RequestBody User user, @RequestParam String role) {
        userService.register(user, role);
        return role.equalsIgnoreCase("ROLE_ADMIN") ? "Admin registered successfully!" : "User registered successfully!";
    }

  
    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "error", required = false) String error,
                                @RequestParam(value = "logout", required = false) String logout,
                                @RequestParam(value = "registered", required = false) String registered,
                                Model model) {
        if (error != null) model.addAttribute("error", "Invalid username or password.");
        if (logout != null) model.addAttribute("message", "You have been logged out.");
        if (registered != null) model.addAttribute("message", "Registration successful. Please login.");
        return "login"; 
    }


    @GetMapping("/home")
    public String home(Authentication authentication, Model model) {
        if (authentication == null) {
            return "redirect:/auth/login";
        }

        boolean isAdmin = authentication.getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN"));

        model.addAttribute("username", authentication.getName());
        model.addAttribute("role", isAdmin ? "Admin" : "User");
        return "home"; 
    }

  
    @GetMapping("/login-success")
    @ResponseBody
    public String loginSuccess(Authentication authentication) {
        if (authentication == null) return "Not authenticated!";
        boolean isAdmin = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return isAdmin ? "Welcome Admin!" : "Welcome User!";
    }
}


