package itsphere.dev.bookswap.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String city;
    private List<BooksResponse> books;
}
