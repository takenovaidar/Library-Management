package itsphere.dev.bookswap.mapper.impl;

import itsphere.dev.bookswap.mapper.UserMapper;
import itsphere.dev.bookswap.model.auth.RegisterRequest;
import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.dto.UserRequest;
import itsphere.dev.bookswap.model.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserRequest request) {
        if (request == null) {
            return null;
        }

        User user = new User();
        user.setUsername(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCity(request.getCity());
        return user;
    }

    @Override
    public UserResponse toResponse(User user) {
        if (user == null) {
            return null;
        }

        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setCity(user.getCity());
        return userResponse;
    }

    @Override
    public User toUptadeEmail(UserRequest request, User user) {
       if (request == null || user == null) {
           return null;
       }
       user.setEmail(request.getEmail());
       return user;
    }

    @Override
    public User registerRequestToUser(RegisterRequest request) {
        if (request == null) {
            return null;
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCity(request.getCity());
        return user;
    }
}
