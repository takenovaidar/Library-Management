package itsphere.dev.bookswap.model.dto;
import itsphere.dev.bookswap.model.domain.SwapStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SwapResponse {
    private Long bookId;
    private Long offeredBookId;
    private Long requestedBookId;
    private SwapStatus status;
    private LocalDateTime createdAt;
}
