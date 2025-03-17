package itsphere.dev.bookswap.mapper;

import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.auth.RegisterRequest;


public interface AuthMapper {
    User registerRequestToUser(RegisterRequest request);
}

