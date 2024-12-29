package uz.pdp.functionalInterfaces.methodReferenceExample;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String username;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public User(UserRegisterDTO dto) {
        this.setUsername(dto.getUserName());
        this.setPassword(dto.getPassword());
        this.setRole("User");
        this.setCreatedAt(LocalDateTime.now());
    }

    public User() {
    }
}
