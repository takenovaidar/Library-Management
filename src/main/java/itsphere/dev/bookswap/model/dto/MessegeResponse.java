package itsphere.dev.bookswap.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessegeResponse {
    private Long id;
    private Long senderId;
    private Long recipientId;
    private String message;
    private LocalDateTime createdAt;
}
