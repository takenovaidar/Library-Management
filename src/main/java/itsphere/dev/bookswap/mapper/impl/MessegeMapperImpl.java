package itsphere.dev.bookswap.mapper.impl;

import itsphere.dev.bookswap.mapper.MessegeMapper;
import itsphere.dev.bookswap.model.domain.Messege;
import itsphere.dev.bookswap.model.dto.MessegeRequest;
import itsphere.dev.bookswap.model.dto.MessegeResponse;
import org.springframework.stereotype.Component;

@Component
public class MessegeMapperImpl implements MessegeMapper {
    @Override
    public Messege toMessege(MessegeRequest request) {
        if (request == null) {
            return null;
        }
        Messege messege = new Messege();
        messege.setMessage(request.getMessage());
        return messege;
    }

    @Override
    public MessegeResponse toResponse(Messege messege) {
        if (messege == null) {
            return null;
        }
        MessegeResponse response = new MessegeResponse();
        response.setId(messege.getId());
        response.setSenderId(messege.getSender().getId());
        response.setRecipientId(messege.getRecipient().getId());
        response.setMessage(messege.getMessage());
        response.setCreatedAt(messege.getCreatedAt());
        return response;
    }
}
