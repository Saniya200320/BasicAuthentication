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

<img width="838" height="359" alt="{82963555-6C9D-4FCF-9B56-74347AD9B58A}" src="https://github.com/user-attachments/assets/0a988993-7ea8-4266-8c3c-8589d3f8a623" />
<img width="206" height="236" alt="{090C1287-08E2-4ADA-BD59-1102E338706F}" src="https://github.com/user-attachments/assets/cd49c6b0-aa32-47c3-915b-e8d957292786" />
<img width="613" height="335" alt="{960464A5-C206-4062-8856-28983BE7AC5A}" src="https://github.com/user-attachments/assets/f656bbbc-b581-442a-ba2d-ba081ecc7202" />
<img width="592" height="290" alt="{B76693E2-19F0-4E6A-92BC-3726948D8506}" src="https://github.com/user-attachments/assets/d19d6c19-47d1-42ef-8477-90f089848aca" />
<img width="304" height="159" alt="{6008FFFA-30C2-45E9-B17C-DD9617D919B8}" src="https://github.com/user-attachments/assets/0c37fd01-27b4-4aa0-b115-b58abccfcdf4" />
<img width="298" height="254" alt="{535DFBDE-D8DB-494C-BFC7-63FC03A17700}" src="https://github.com/user-attachments/assets/e0555756-5246-419d-b5ce-74f8f752f171" />

<img width="269" height="126" alt="{6EB63EDD-06E1-41E8-9BE6-0670C0F27DAA}" src="https://github.com/user-attachments/assets/8bc26100-352b-421b-9717-5d148369737d" />
<img width="272" height="215" alt="{36E1C226-2D23-447E-BF6E-1DBCFD851847}" src="https://github.com/user-attachments/assets/a851be62-4fa8-4881-9841-253834e2ef3c" />
<img width="278" height="233" alt="{AE72E9C5-ED1B-44C7-B9B1-483DFB8DC74B}" src="https://github.com/user-attachments/assets/51fefbfd-55f4-4832-be78-ecbdb9df3969" />















      0 | 2025-11-07 16:55:12.783191 | $2a$10$zbPhxRSUF0RglvadxsKTk.eJYSeDRlEqAItqW49/Jo40OVDCC/ZRO | Muskan   | f

