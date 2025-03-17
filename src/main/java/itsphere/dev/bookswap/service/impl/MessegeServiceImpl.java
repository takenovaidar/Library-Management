package itsphere.dev.bookswap.service.impl;

import itsphere.dev.bookswap.mapper.MessegeMapper;
import itsphere.dev.bookswap.model.domain.Messege;
import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.dto.MessegeRequest;
import itsphere.dev.bookswap.model.dto.MessegeResponse;
import itsphere.dev.bookswap.repository.MessegeRepository;
import itsphere.dev.bookswap.repository.UserRepository;
import itsphere.dev.bookswap.service.MessegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessegeServiceImpl implements MessegeService {

    @Autowired
    private MessegeRepository messegeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessegeMapper messegeMapper;

    @Override
    public MessegeResponse sendMessege(MessegeRequest request) {
        User sender = userRepository.findById(request.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found!"));
        User recipient = userRepository.findById(request.getRecipientId())
                .orElseThrow(() -> new RuntimeException("Recipient not found!"));
        Messege messege = new Messege();
        messege.setSender(sender);
        messege.setRecipient(recipient);

        Messege savedMessege = messegeRepository.save(messege);
        return messegeMapper.toResponse(savedMessege);
    }

    @Override
    public List<MessegeResponse> getMesseges(Long senderId, Long recipientId) {
        List<Messege> messeges = messegeRepository.findBySenderIdAndRecipientId(senderId, recipientId);
        return messeges.stream()
                .map(messegeMapper::toResponse)
                .collect(Collectors.toList());
    }
}

