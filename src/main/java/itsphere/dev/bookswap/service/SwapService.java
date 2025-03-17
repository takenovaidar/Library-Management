package itsphere.dev.bookswap.service;

import itsphere.dev.bookswap.model.dto.SwapRequest;
import itsphere.dev.bookswap.model.dto.SwapResponse;

public interface SwapService {
    SwapResponse createSwap(SwapRequest swapRequest);
    SwapResponse acceptSwap(Long id, Long userId);
    SwapResponse rejectSwap(Long id, Long userId);
}
