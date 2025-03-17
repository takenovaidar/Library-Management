package itsphere.dev.bookswap.service;

import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.dto.UserRequest;

public interface UserService {
    User createUser(UserRequest request);
    User updateUserByEmail(String email, UserRequest request);
    User getUserById(Long id);
    void deleteUserById(Long userId);
}
