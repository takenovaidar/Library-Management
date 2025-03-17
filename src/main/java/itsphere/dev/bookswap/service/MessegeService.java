package itsphere.dev.bookswap.service;


import itsphere.dev.bookswap.model.dto.MessegeRequest;
import itsphere.dev.bookswap.model.dto.MessegeResponse;

import java.util.List;

public interface MessegeService {
    MessegeResponse sendMessege(MessegeRequest request);
    List<MessegeResponse> getMesseges(Long senderId, Long recipientId);

}
