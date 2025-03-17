package itsphere.dev.bookswap.mapper.impl;

import itsphere.dev.bookswap.mapper.SwapMapper;
import itsphere.dev.bookswap.model.domain.Swap;
import itsphere.dev.bookswap.model.domain.SwapStatus;
import itsphere.dev.bookswap.model.dto.SwapRequest;
import itsphere.dev.bookswap.model.dto.SwapResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SwapMapperImpl implements SwapMapper {
    @Override
    public Swap toEntity(SwapRequest swapRequest) {
        if (swapRequest == null) {
            return null;
        }
        Swap swap = new Swap();
        swap.setOfferedBook(null);
        swap.setRequestedBook(null);
        swap.setStatus(SwapStatus.PENDING);
        swap.setCreatedAt(LocalDateTime.now());
        return swap;
    }

    @Override
    public SwapResponse toResponse(Swap swap) {
        if (swap == null) {
            return null;
        }
        SwapResponse swapResponse = new SwapResponse();
        swapResponse.setBookId(swap.getId());
        swapResponse.setOfferedBookId(swap.getOfferedBook().getBookId());
        swapResponse.setRequestedBookId(swap.getRequestedBook().getBookId());
        swapResponse.setCreatedAt(LocalDateTime.now());
        swapResponse.setStatus(swap.getStatus());
        return swapResponse;
    }
}
