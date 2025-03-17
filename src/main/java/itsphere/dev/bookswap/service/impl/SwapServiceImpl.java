package itsphere.dev.bookswap.service.impl;

import itsphere.dev.bookswap.mapper.SwapMapper;
import itsphere.dev.bookswap.model.domain.Swap;
import itsphere.dev.bookswap.model.domain.SwapStatus;
import itsphere.dev.bookswap.model.dto.SwapRequest;
import itsphere.dev.bookswap.model.dto.SwapResponse;
import itsphere.dev.bookswap.repository.BooksRepository;
import itsphere.dev.bookswap.repository.SwapRepository;
import itsphere.dev.bookswap.service.SwapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SwapServiceImpl implements SwapService {

    @Autowired
    private SwapRepository swapRepository;
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private SwapMapper swapMapper;
    @Override
    public SwapResponse createSwap(SwapRequest swapRequest) {
        Swap swap = swapMapper.toEntity(swapRequest);
        swap.setOfferedBook(booksRepository.findById(swapRequest.getOfferedBookId())
                .orElseThrow(() -> new RuntimeException("Offered book not found")));
        swap.setRequestedBook(booksRepository.findById(swapRequest.getRequestedBookId())
                .orElseThrow(() -> new RuntimeException("Requested book not found")));
        swap.setStatus(SwapStatus.PENDING);
        swap.setCreatedAt(LocalDateTime.now());

        Swap savedSwap = swapRepository.save(swap);
        return swapMapper.toResponse(savedSwap);
    }

    @Override
    public SwapResponse acceptSwap(Long id, Long userId) {
        Swap swap = swapRepository.findById(id).orElseThrow(() -> new RuntimeException("Swap not found"));

        if (!swap.getRequestedBook().getUser().getId().equals(userId)) {
            throw new RuntimeException("User not authorized to accept swap");
        }
        swap.setStatus(SwapStatus.ACCEPTED);
        Swap updatedSwap = swapRepository.save(swap);
        return swapMapper.toResponse(updatedSwap);
    }

    @Override
    public SwapResponse rejectSwap(Long id, Long userId) {
        Swap swap = swapRepository.findById(id).orElseThrow(() -> new RuntimeException("Swap not found"));
        if (!swap.getRequestedBook().getUser().getId().equals(userId)) {
            throw new RuntimeException("User not authorized to reject swap");
        }

        swap.setStatus(SwapStatus.REJECTED);
        Swap updatedSwap = swapRepository.save(swap);
        return swapMapper.toResponse(updatedSwap);
    }
}
