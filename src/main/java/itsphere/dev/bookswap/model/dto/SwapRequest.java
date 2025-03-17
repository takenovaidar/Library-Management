package itsphere.dev.bookswap.model.dto;

import lombok.Data;

@Data
public class SwapRequest {
    private long offeredBookId;
    private long requestedBookId;
}
