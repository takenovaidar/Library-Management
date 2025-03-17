package itsphere.dev.bookswap.controller;

import itsphere.dev.bookswap.model.dto.SwapRequest;
import itsphere.dev.bookswap.model.dto.SwapResponse;
import itsphere.dev.bookswap.service.SwapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swap")
public class SwapController {
    @Autowired
    private SwapService swapService;
    @PostMapping
    public SwapResponse createSwap(@RequestBody SwapRequest swapRequest) {
        return swapService.createSwap(swapRequest);
    }
    @PutMapping("/{id}/accept")
    private SwapResponse acceptSwap(@PathVariable Long id, @RequestParam Long userId) {
        return swapService.acceptSwap(id, userId);
    }
    @PutMapping("/{id}/reject")
    public SwapResponse rejectSwap(@PathVariable Long id, @RequestParam Long userId) {
        return swapService.rejectSwap(id, userId);
    }
}
