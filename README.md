This is a Spring Boot Authentication System with role-based login, audit logging, and account locking after multiple failed attempts. It uses Spring Security for authentication and Thymeleaf for frontend pages. 
Swagger UI is also integrated for API documentation.
It Performs,
User registration and login with role selection (USER/ADMIN)
Password encryption using BCrypt
Account locking after 3 failed login attempts
Audit logging for login success, failure, and account lock
Role-based access control (Admin/User)
Home page after login
Logout functionality
Swagger API documentation

2.Technologies Used
Spring Boot , Spring Security , Spring Data JPA , Hibernate , Thymeleaf , H2 / MySQL (or any relational database) , Swagger OpenAPI , Maven

users table: Stores user accounts with fields for username, encrypted password, account status (enabled, account_locked), failed login attempts, and last login timestamp.
roles table: Holds role names (e.g., ADMIN, USER) for access control.
user_roles table: A join table that creates a many-to-many relationship between users and roles.
audit_logs table: Tracks user actions (like login/logout) with timestamps for security and compliance.

![user](https://github.com/user-attachments/assets/9374e9ad-f591-4490-9b0d-38a13d67fd1f)
![roles](https://github.com/user-attachments/assets/9c8a42be-1f6e-40fd-a495-5ff0988c9b03)
![audit_logs](https://github.com/user-attachments/assets/4432cf02-b736-4f88-ba86-a61dbee18e94)
![user description](https://github.com/user-attachments/assets/d448936e-1405-4041-bced-354714f7f8f7)
![audit_logs,roles description](https://github.com/user-attachments/assets/0b25dee5-c1cd-4b58-8811-dcd1267d36d7)
![output1](https://github.com/user-attachments/assets/dbefa866-1b2f-4134-851a-6dee3090803e)
![output2](https://github.com/user-attachments/assets/7a4ba472-e735-4972-8ef8-e3c1f168f56e)
![output3](https://github.com/user-attachments/assets/8a821249-5b35-4700-938f-ed7d537041e4)
![output4](https://github.com/user-attachments/assets/f0ffdc8f-2a77-47e1-81ed-e55949589089)
<img width="269" height="126" alt="{6EB63EDD-06E1-41E8-9BE6-0670C0F27DAA}" src="https://github.com/user-attachments/assets/8bc26100-352b-421b-9717-5d148369737d" />
<img width="272" height="215" alt="{36E1C226-2D23-447E-BF6E-1DBCFD851847}" src="https://github.com/user-attachments/assets/a851be62-4fa8-4881-9841-253834e2ef3c" />













      0 | 2025-11-07 16:55:12.783191 | $2a$10$zbPhxRSUF0RglvadxsKTk.eJYSeDRlEqAItqW49/Jo40OVDCC/ZRO | Muskan   | f

