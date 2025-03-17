package itsphere.dev.bookswap.controller;

import itsphere.dev.bookswap.model.dto.MessegeRequest;
import itsphere.dev.bookswap.model.dto.MessegeResponse;
import itsphere.dev.bookswap.service.MessegeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessegeService messegeService;

    public MessageController(MessegeService messegeService) {
        this.messegeService = messegeService;
    }

    @PostMapping
    public MessegeResponse sendMessage(@RequestBody MessegeRequest request) {
        return messegeService.sendMessege(request);
    }

    @GetMapping("{senderId}/{reciepientId}")
    public List<MessegeResponse> getMessages(
            @PathVariable Long senderId,
            @PathVariable Long reciepientId) {
        return messegeService.getMesseges(senderId, reciepientId);
    }
}
