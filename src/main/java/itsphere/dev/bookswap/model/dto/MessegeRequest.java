package itsphere.dev.bookswap.model.dto;

import lombok.Data;

@Data
public class MessegeRequest {
    private Long senderId;
    private Long recipientId;
    private String message;
}
