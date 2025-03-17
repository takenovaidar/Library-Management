package itsphere.dev.bookswap.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books_table")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    private String genre;
    private String state;
    private String city;
    private LocalDateTime createdAt;

    private String coverImageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
