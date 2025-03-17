package itsphere.dev.bookswap.mapper.impl;

import itsphere.dev.bookswap.mapper.AuthMapper;
import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.auth.RegisterRequest;
import org.springframework.stereotype.Component;

/**
 * Ручная реализация маппера для преобразования RegisterRequest в User.
 */
@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public User registerRequestToUser(RegisterRequest request) {
        if (request == null) {
            return null;
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setCity(request.getCity());
        // Обратите внимание: пароль не маппится здесь,
        // его необходимо шифровать в сервисе (например, через PasswordEncoder)
        return user;
    }
}

