package itsphere.dev.bookswap.model.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private String city;
}
