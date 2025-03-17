package itsphere.dev.bookswap.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Swap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offered_book_id", nullable = false)
    private Books offeredBook;

    @ManyToOne
    @JoinColumn(name = "requested_book_id", nullable = false)
    private Books requestedBook;

    @Enumerated(EnumType.STRING)
    private SwapStatus status;

    private LocalDateTime createdAt;

    public Swap() {
        this.createdAt = LocalDateTime.now();
    }
}

