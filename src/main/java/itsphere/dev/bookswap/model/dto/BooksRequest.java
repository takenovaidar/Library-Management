package itsphere.dev.bookswap.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BooksRequest {
    private String title;
    private String author;
    private String genre;
    private String state;
    private String city;
    private LocalDateTime createdAt;
    private String coverImageUrl;
    private Long userId;
}
